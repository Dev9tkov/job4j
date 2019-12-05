package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Необходимо создать итератор для двухмерного массива
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 05.12.2019
 */
public class ArrayIterator implements Iterator {
    private final int[][] values;
    private int position = 0;
    private int size;

    public ArrayIterator(final int[][] values) {
        this.values = values;
        this.size = sizeArray(values);
    }

    private int sizeArray(final int[][] values) {
        int count = 0;
        for (int[] array : values) {
            for (int data : array) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return size > position;
    }

    @Override
    public Object next() {
        int count = 0;
        int result = 0;
        for(int[] array : values) {
            for(int data : array) {
                if (count == position) {
                    position++;
                    result = data;
                    return result;
                } else {
                    count++;
                }
            }
        }
        return result;
    }
}
