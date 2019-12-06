package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только четные цифры.
 * Итератор должен принимать список произвольных чисел
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 06.12.2019
 */
public class EvenIterator implements Iterator {
    private int[] numbers;
    private int index = 0;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result = true;
                index = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}
