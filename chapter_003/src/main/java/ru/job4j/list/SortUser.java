package ru.job4j.list;



import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 13.11.2019
 */
public class SortUser {
    public Set<Usernew> sort(List<Usernew> list) {
        Set<Usernew> result = new TreeSet<>(list);
        return result;
    }
}
