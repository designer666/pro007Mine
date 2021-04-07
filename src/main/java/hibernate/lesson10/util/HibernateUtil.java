package hibernate.lesson10.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    /*SessionFactory - отвечает за установку и поддержку соединения с БД
     * StandardServiceRegistry - позволяет ззагрузить настройки из файла hibernate.cfg.xml*/
    /*private static final SessionFactory sessionFactory = new Configuration().configure("/hibernate/lesson10/hibernate.cfg.xml").buildSessionFactory();;
    private static StandardServiceRegistry registry;

    private static SessionFactory build() {
        registry = new StandardServiceRegistryBuilder().configure("/hibernate/lesson10/hibernate.cfg.xml").build();
        *//*На основе созданного по настройкам создается конфигурация фреймворка и фабрика сессий*//*
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return sessionFactory;
    }*/

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // load from different directory
            SessionFactory sessionFactory = new Configuration().configure("/hibernate/lesson10/hibernate.cfg.xml").buildSessionFactory();

            return sessionFactory;

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return sessionFactory;
    }
}
