package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @author Ilya Devyatkov
 * @since 27.05.2020
 */
public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            ItemHBR item = create(new ItemHBR("Hibernate"), sf);
            System.out.println("create: " + item);
            item.setName("Learn Hibernate 5");
            update(item, sf);
            System.out.println("update: " + item);
            ItemHBR rsl = findById(item.getId(), sf);
            System.out.println("findById: " + rsl);
            delete(item.getId(), sf);
            List<ItemHBR> list = findAll(sf);
            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static ItemHBR create(ItemHBR item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(ItemHBR item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemHBR item = new ItemHBR(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<ItemHBR> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.ItemHBR").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static ItemHBR findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemHBR result = session.get(ItemHBR.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
