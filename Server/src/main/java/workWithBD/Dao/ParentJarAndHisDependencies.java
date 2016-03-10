package workWithBD.Dao;

import JSONParser.DependenciesJars;
import workWithBD.tables.Dependencies;
import workWithBD.tables.JarNameAndVersion;

import java.util.List;
import java.util.Set;

/**
 * Created by nik on 18.02.2016.
 */
public interface ParentJarAndHisDependencies {
    public JarNameAndVersion getIDFromFirstTable (String name);
    public List<Dependencies> getNamesOnFK(JarNameAndVersion parentJar);
    public Set<String> getAllDependenciesForOneJar (String name);
    public DependenciesJars checkDependencies(List<String> jarNames);
    public Set<String> getAllDependenciesAllJars(List<String> jarNames);
}
