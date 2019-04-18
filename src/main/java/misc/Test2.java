package misc;

public class Test2 {

    private static double median(int[] x, int[] y) {
        int m = x.length;
        int n = y.length;

        if (m == 0 && n == 0) return 0.0;
        if (m == 0) return findMedian(y);
        if (n == 0) return findMedian(x);

        int min = min(x, y);  // Could have just used Integer.MIN_VALUE to reduce complexity.
        int max = max(x, y);  // Could have just used Integer.MAX_VALUE to reduce complexity.

        int total = m+n;
        double res;
        if (total % 2 == 0) {
            res = findKthSmallest(x, y, total/2, min, max) + findKthSmallest(x, y, total/2 + 1, min, max);
            res /= 2;
        } else {
            res = findKthSmallest(x, y, total/2+1, min, max);
        }

        return res;
    }

    // Find the kth smallest number.
    static double findKthSmallest(int[] x, int[] y, int k, int lo, int hi) {

        while (lo < hi) {
            int mid = hi - (int)(((long)hi - (long)lo)/2);

            if (smaller(x, y, mid) < k) {
                lo = mid;
            } else {
                hi = mid-1;
            }

        }

        return lo;
    }

    // Find the total number of values smaller than val in both x and y.
    static int smaller(int[] x, int[] y, int val) {
        int c1 = bs_smaller(x, val);
        int c2 = bs_smaller(y, val);

        return c1 + c2;
    }

    // Find the count of values smaller than val in x.
    static int bs_smaller(int[] x, int val) {
        int n = x.length;
        if (val > x[n-1]) return n;

        int lo = 0, hi = n-1;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;

            if (x[mid] >= val) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return lo;
    }

    static double findMedian(int[] a) {
        int n = a.length;
        if (n % 2 == 0) {
            return ((double)a[n/2-1]+ a[n/2]) / 2;
        } else {
            return a[n/2];
        }
    }

    static int min(int[] x, int[] y) {
        int min = x[0];

        for (int v : x) min = Math.min(v, min);
        for (int v : y) min = Math.min(v, min);

        return min;
    }

    static int max(int[] x, int[] y) {
        int max = x[0];

        for (int v : x) max = Math.max(v, max);
        for (int v : y) max = Math.max(v, max);

        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,7};
        int[] b = {2,4,6};

        System.out.println(median(a, b));
    }

}
