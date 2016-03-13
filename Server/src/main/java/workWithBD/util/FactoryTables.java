package workWithBD.util;

import workWithBD.DaoImpl.ParentJarAndHisDependenciesImpl;
import workWithBD.Dao.ParentJarAndHisDependencies;

/**
 * Created by nik on 18.02.2016.
 */
public class FactoryTables {
    public static FactoryTables instance = new FactoryTables();
    public ParentJarAndHisDependenciesImpl navD;

    private FactoryTables() {}

    public static FactoryTables getInstance () {
        return FactoryTables.instance;
    }

    public ParentJarAndHisDependencies getJarNameAndVersionDao(){
        if (navD == null)
            navD = new ParentJarAndHisDependenciesImpl();
        return navD;
    }
}
