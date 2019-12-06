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
    private int row = 0;
    private int col = 0;

    public ArrayIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return  row < values.length && col < values[row].length;
    }

    @Override
    public Object next() {
        int result = values[row][col];
        col++;
        if (col == values[row].length) {
            col = 0;
            row++;
        }
        return result;
    }
}
