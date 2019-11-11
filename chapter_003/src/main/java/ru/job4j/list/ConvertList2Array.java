package ru.job4j.list;

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
        int[] arraylist = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arraylist[i] = list.get(i);
        }
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < rows; j++) {
                if(i * rows + j < arraylist.length) {
                    array[i][j] = arraylist[i * rows + j ];
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}

