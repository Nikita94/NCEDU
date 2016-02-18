package Util;

import Dao.Impl.JarNameAndVersionDaoImpl;
import Dao.JarNameAndVersionDao;

/**
 * Created by nik on 18.02.2016.
 */
public class Factory {
    public static Factory instance = new Factory();
    public JarNameAndVersionDao navD;

    private Factory () {}

    public static Factory getInstance () {
        return Factory.instance;
    }

    public JarNameAndVersionDao getJarNameAndVersionDao(){
        if (navD == null)
            navD = new JarNameAndVersionDaoImpl();
        return navD;
    }
}
