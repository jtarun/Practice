package com.jtarun.practice.design_patterns;

import java.util.LinkedList;
import java.util.List;

interface Observer<T> {
    void update(T message);
}

interface IObservable<T> {
    void update(T message);
}

class Observable<T> implements IObservable<T> {
    private List<Observer<T>> observers = new LinkedList<>();

    public void add(Observer<T> observer) {
        if (observers.contains(observer)) return;
        observers.add(observer);
    }

    public void update(T message) {
        for (Observer<T> o : observers) o.update(message);
    }
}

public class MessageNotificationSystem {
}
