package ru.job4j.comparator;
import java.util.Comparator;


/**
 * 3. Компаратор для строк.[#187404]
 * Нужно реализовать компаратор для сравнения двух массивов символов
 * Сравнение в лексикографическом порядке.
 *
 * String.charAt(int index) символ в строке под индексом
 * Integer.compare(int left, int right) сравение длин строк
 * Character.compare(o1, o2) сравнение символов лексикографически
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 17.11.2019
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = (left.length() > right.length()) ? right.length() : left.length();
        int index = 0;
        int result = 0;
        while (index < length) {
            char o1 = left.charAt(index);
            char o2 = right.charAt(index);
            if (o1 != o2) {
                result = Character.compare(o1, o2);
            }
            index++;
        }
        if (result == 0 && Integer.compare(left.length(), right.length()) == -1) {
            result = -1;
        }
        return result;
    }
}
