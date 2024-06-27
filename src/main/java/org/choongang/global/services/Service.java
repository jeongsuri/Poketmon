package org.choongang.global.services;


public interface Service<T> {
    default void process(T form) {}
    default T process() {
        return null;
    }
}