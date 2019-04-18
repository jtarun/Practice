package com.jtarun.practice.salesforce;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The code is assumed to rate limit single API only. Little enhancement would be needed to make it work for multiple
 * APIs.
 */

enum License {
    LOW(10), MEDIUM(20), HIGH(50);

    private final int rate;
    License(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return this.rate;
    }
}

class User {
    private String userId;
    private License license;

    public User(String userId, License license) {
        this.userId = userId;
        this.license = license;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}


class RateLimitQueue {
    private Queue<Long> requestQueue;
    private int rateLimit;

    public RateLimitQueue(int rateLimit) {
        this.rateLimit = rateLimit;
        requestQueue = new LinkedList<>();
    }

    // This needs to be thread-safe.
    public synchronized boolean limit(Long timeInMs) {
        while (!requestQueue.isEmpty() && (requestQueue.peek() - timeInMs > 1000)) {
            requestQueue.poll();
        }

        if (requestQueue.size() >= rateLimit) {
            return false;
        }

        requestQueue.add(timeInMs);
        return true;
    }

}

class RateLimiterService {
    private static int API_LIMIT_PER_SEC = 1000;

    private RateLimitQueue apiRateLimitQueue;
    private Map<User, RateLimitQueue> userRateLimitQueueMap = new ConcurrentHashMap<>();

    public RateLimiterService() {
        apiRateLimitQueue = new RateLimitQueue(API_LIMIT_PER_SEC * 1000);
    }

    public boolean limit(User user) {

        // Check if the API limit exceeds.
        Long currentTimeInMs = System.currentTimeMillis();
        if (apiRateLimitQueue.limit(currentTimeInMs)) {
            return true;
        }

        RateLimitQueue rateLimitQueue = userRateLimitQueueMap.computeIfAbsent(user,
                k -> new RateLimitQueue(user.getLicense().getRate() * 1000));

        // Check if the user API limit exceeds.
        if (rateLimitQueue.limit(currentTimeInMs)) {
            return true;
        }

        return false;
    }
}

class Response {
    Map<String, String> headers;
    String body;
}

class RequestFailException extends Exception {
    public RequestFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestFailException(String message) {
        super(message);
    }
}

class APIController {
    private static int TIMEOUT_IN_SEC = 20;
    private static int RETRY_INTERVAL = 1;

    private UserProfileService userProfileService;
    private RateLimiterService rateLimiterService;

    public APIController() {
        this.rateLimiterService = new RateLimiterService();
    }

    public Response handleRequest(String apiUrl, String userId) throws RequestFailException {
        Response response = null;

        int totalTime = 0;
        while (response == null && totalTime < TIMEOUT_IN_SEC) {
            try {
                response = handleRequestOnce(apiUrl, userId);
            } catch (RequestFailException ex) {
                throw new RequestFailException("Request timed out!!!", ex);
            }
            totalTime += RETRY_INTERVAL;
            sleep(RETRY_INTERVAL);
        }
        return response;
    }

    private Response handleRequestOnce(String apiUrl, String userId) throws RequestFailException  {

        User user = userProfileService.getUserById(userId);
        if (rateLimiterService.limit(user)) {
            throw new RequestFailException("Too many requests!!!");
        }

        // call the API and return response;
        return callAPI(apiUrl, userId);
    }

    private Response callAPI(String url, String userId) {
        // Call the real api and return the response here.
        return null;
    }

    private void sleep(int intervalInSec) {
        // sleep for these many seconds.
        try {
            Thread.sleep(intervalInSec * 1000);
        } catch (InterruptedException ex) {
            // handle here.
        }
    }
}

class UserProfileService {
    private Map<String, User> userMap = new ConcurrentHashMap<>();
    public boolean addUser(User user) {
        if (userMap.containsKey(user.getUserId())) {
            return false;
        }
        userMap.put(user.getUserId(), user);
        return true;
    }

    public User getUserById(String userId) {
        return userMap.get(userId);
    }

}

public class RateLimiterDesign {

    public static void main(String[] args) {

        try {
            APIController apiController = new APIController();
            apiController.handleRequest("https://sample_url", "userguid");
        } catch (RequestFailException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
