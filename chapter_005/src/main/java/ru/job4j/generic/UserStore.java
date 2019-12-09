package ru.job4j.generic;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * To do
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 09.12.2019
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}


