package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Метод, который принимает в себя список пользователей и конвертирует
 * его в Map с ключом Integer id и соответствующим ему User.
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 12.11.2019
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for(User volume : list) {
            result.put(volume.getId(), volume);
        }
        return result;
    }
}
