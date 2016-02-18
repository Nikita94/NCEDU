import Dao.JarNameAndVersionDao;
import Util.Factory;
import tables.JarNameAndVersion;

import java.util.List;

/**
 * Created by nik on 17.02.2016.
 */
public class Server {
    public static void main (String argv[]) {
        Factory factory = Factory.getInstance();
        JarNameAndVersionDao navD = factory.getJarNameAndVersionDao();

        JarNameAndVersion nav = new JarNameAndVersion();
        nav.setNameAndVersion("lolka");
        navD.addNameAndVersion(nav);

        /* List<JarNameAndVersion> allnav = navD.getAll();
        for (JarNameAndVersion navv : allnav)
        {
            System.out.println("ID " + navv.getId() + " name " + navv.getNameAndVersion());
        }*/
    }
}
