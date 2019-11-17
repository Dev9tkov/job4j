package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;


/**
 * 3. Конвертация ArrayList в двухмерный массив[#187416]
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 11.11.2019
 */
public class ConvertList2Array {

    /**
     * Метод переводит List в двумерный массив.
     *
     * @param list list
     * @param rows кол-во столбцов
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = ((list.size() + (rows - 1)) / rows);
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
            for (Integer volume : list) {
                    array[i][j++] = volume;
                    if (j == cells) {
                        i++;
                        j = 0;
                    }
            }
        return array;
    }

    /**
     * Пройтись по всем элементам всех массивов в списке list и добавить их в один общий лист Integer.
     * @param list входящий
     * @return результирующий list
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] volume : list) {
            for (int j : volume) {
                result.add(j);
            }
        }
        return result;
    }
}