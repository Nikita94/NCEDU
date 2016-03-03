package workWithBD.util;

import workWithBD.DaoImpl.ParentJarAndHisDependenciesImpl;
import workWithBD.Dao.ParentJarAndHisDependencies;

/**
 * Created by nik on 18.02.2016.
 */
public class Factory {
    public static Factory instance = new Factory();
    public ParentJarAndHisDependenciesImpl navD;

    private Factory () {}

    public static Factory getInstance () {
        return Factory.instance;
    }

    public ParentJarAndHisDependencies getJarNameAndVersionDao(){
        if (navD == null)
            navD = new ParentJarAndHisDependenciesImpl();
        return navD;
    }
}
