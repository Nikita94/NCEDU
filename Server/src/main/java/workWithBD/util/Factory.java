package workWithBD.util;

import workWithBD.DaoImpl.ParentJarAndHisDependeciesImpl;
import workWithBD.Dao.ParentJarAndHisDependecies;
import workWithBD.DaoImpl.ParentJarAndHisDependeciesImpl;

/**
 * Created by nik on 18.02.2016.
 */
public class Factory {
    public static Factory instance = new Factory();
    public ParentJarAndHisDependeciesImpl navD;

    private Factory () {}

    public static Factory getInstance () {
        return Factory.instance;
    }

    public ParentJarAndHisDependecies getJarNameAndVersionDao(){
        if (navD == null)
            navD = new ParentJarAndHisDependeciesImpl();
        return navD;
    }
}
