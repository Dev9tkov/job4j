package ru.job4j.transform;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 26.11.2019
 */
public class MatrixtolistTest {
    @Test
    public void whenMatrixThenList() {
        Matrixtolist matr = new Matrixtolist();
        Integer[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = matr.matrix(input);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));

    }
}
