package workWithBD.DaoImpl;

import workWithBD.Dao.ParentJarAndHisDependecies;
import workWithBD.util.HibernateUtil;
import org.hibernate.Session;
import workWithBD.tables.JarNameAndVersion;

import java.util.List;

/**
 * Created by nik on 18.02.2016.
 */
public class ParentJarAndHisDependeciesImpl implements ParentJarAndHisDependecies {
    public void addNameAndVersion(JarNameAndVersion nav) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(nav);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen())
            session.close();
        }
    }

    public List<JarNameAndVersion> getAll() {
        List<JarNameAndVersion> allnav = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            allnav = session.createCriteria(JarNameAndVersion.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return allnav;
    }
}
