package hibernate.lesson09.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    /*SessionFactory - отвечает за усттановку и поддержку соединения с БД
     * StandardServiceRegistry - позволяет ззагрузить настройки из файла hibernate.cfg.xml*/
    private static final SessionFactory sessionFactory = build();
    private static StandardServiceRegistry registry;

    private static SessionFactory build() {
        registry = new StandardServiceRegistryBuilder().configure("/hibernate/lesson09/hibernate.cfg.xml").build();
        /*На основе созданного по настройкам создается конфигурация фреймворка и фабрика сессий*/
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return sessionFactory;
    }
}
