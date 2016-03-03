package workWithBD.DaoImpl;

import JSONParser.DependenciesJars;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import workWithBD.tables.Dependencies;
import workWithBD.Dao.ParentJarAndHisDependencies;
import workWithBD.util.HibernateUtil;
import org.hibernate.Session;
import workWithBD.tables.JarNameAndVersion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nik on 18.02.2016.
 */
public class ParentJarAndHisDependenciesImpl implements ParentJarAndHisDependencies {
    private static Set<String> listNames = new HashSet<String>();
    static int inc = 0;
    public void removeSetDependencies() {
        listNames.clear();
        inc = 0;
    }

    @Override
    public DependenciesJars checkDependencies(List<String> jarNames) {
        Set<String> setDep = getAllDependenciesAllJars(jarNames);
        Set<String> sendedData = new HashSet<>(jarNames);
        DependenciesJars dependenciesJars = null;
        if (sendedData.containsAll(setDep))
            dependenciesJars = new DependenciesJars(true, setDep);
        else
            dependenciesJars = new DependenciesJars(false, setDep);
        return dependenciesJars;
    }

    @Override
    public Set<String> getAllDependenciesAllJars(List<String> jarNames) {
        Set<String> setNames = new HashSet<String>();
        for (String str : jarNames) {
            Set<String> set = getAllDependenciesForOneJar(str);
            if (set != null)
                setNames.addAll(set);
        }
        return setNames;
    }

    public JarNameAndVersion getIDFromFirstTable (String name) {
        Session session = null;
        List <JarNameAndVersion> listNames = null;
        int id = 0;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(JarNameAndVersion.class);
            listNames = criteria.add(Restrictions.eq("nameAndVersion", name)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen())
                session.close();
        }
        if (listNames.size() == 0)
            return null;
        return listNames.get(0);
    }

    public List<Dependencies> getNamesOnFK(JarNameAndVersion parentJar) {
        Session session = null;
        List <Dependencies> listNames = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Dependencies.class);
            listNames = criteria.add(Restrictions.eq("d_id", parentJar)).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return listNames;
    }

    public Set<String> getAllDependenciesForOneJar(String name) {
        JarNameAndVersion nav = getIDFromFirstTable(name);
        List<Dependencies> listDependencies = getNamesOnFK(nav);
        listNames.add(name);
        inc = inc + 1;
        if (inc != listNames.size())
            return null;
        for (Dependencies dep : listDependencies) {
            getAllDependenciesForOneJar(dep.getNameAndVersionD());
        }
        return listNames;
    }


}
