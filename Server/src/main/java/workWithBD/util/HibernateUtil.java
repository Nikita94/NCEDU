package workWithBD.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by nik on 18.02.2016.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    HibernateUtil () {}

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory () {
        return sessionFactory;
    }
}
