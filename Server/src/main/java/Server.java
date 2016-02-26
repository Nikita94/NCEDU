import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import workWithBD.tables.Dependencies;
import workWithBD.tables.JarNameAndVersion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 17.02.2016.
 */
public class Server {
    public static void main (String argv[]) {
        /* Factory factory = Factory.getInstance();
        JarNameAndVersionDao navD = factory.getJarNameAndVersionDao();

        JarNameAndVersion nav = new JarNameAndVersion();
        nav.setNameAndVersion("lolka");
        navD.addNameAndVersion(nav);

        List<JarNameAndVersion> allnav = navD.getAll();
        for (JarNameAndVersion navv : allnav)
        {
            System.out.println("ID " + navv.getId() + " name " + navv.getNameAndVersion());
        }*/

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        JarNameAndVersion nav = new JarNameAndVersion("test-1.0.0.1");
        List<Dependencies> dependenciesList = new ArrayList<Dependencies>();
        dependenciesList.add(new Dependencies(nav, "test2_for_test-3.0.0"));
        dependenciesList.add(new Dependencies(nav, "test2_for_test2-4.0.0"));
        nav.setDependencies(dependenciesList);

        session.save(nav);
        session.getTransaction().commit();
        session.close();
    }
}
