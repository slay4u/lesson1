package Dymura_hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {
    private final ReentrantLock lock = new ReentrantLock();
    private List<T> list = new ArrayList<>();

    T get(int index) {
        lock.lock();
        T i = list.get(index);
        lock.unlock();
        return i;
    }

    void add(T t) {
        lock.lock();
        list.add(t);
        lock.unlock();
    }

    void remove(T t) {
        lock.lock();
        list.remove(t);
        lock.unlock();
    }

    @Override
    public String toString() {
        return "ThreadSafeList{" +
                "list=" + list +
                '}';
    }
}
