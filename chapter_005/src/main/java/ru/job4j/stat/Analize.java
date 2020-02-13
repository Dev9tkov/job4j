package ru.job4j.stat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Задание сводиться к определению разницы между начальным состояние массива и измененным.
 *
 * @author Ilya Devyatkov
 * @version 01
 * @since 21.12.2019
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, User> mapCurrent = new HashMap<>();

        for (User volume : current) {
            mapCurrent.put(volume.getId(), volume);
        }

        for (User users : previous) {
            if (mapCurrent.containsKey(users.getId()) && !mapCurrent.containsValue(users)) {
                changed++;
            } else if (!mapCurrent.containsKey(users.getId())) {
                deleted++;
            }
        }
        added = mapCurrent.size() - previous.size() + deleted;
        Info info = new Info(added, changed, deleted);
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }

        @Override
        public String toString() {
            return "Info{" + "added=" + added + ", changed=" + changed + ", deleted=" + deleted + '}';
        }
    }
}
