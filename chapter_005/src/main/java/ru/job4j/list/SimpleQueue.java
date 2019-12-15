package ru.job4j.list;

/**
 * Нужно реализовать очередь
 * Описание Queue - очередь. Описывается FIFO - first input first output
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 12.12.2019
 */
public class SimpleQueue<T> {
    SimpleStack<T> in = new SimpleStack<>();
    SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if(out.size() == 0) {
            int queuesize = in.size();
            for (int i = 0; i < queuesize; i++) {
                out.push(in.poll());
            }
        }
        return out.poll();
    }

    public void push(T value) {
        in.push(value);
    }

    public int size() {
        return in.size() + out.size();
    }
}
