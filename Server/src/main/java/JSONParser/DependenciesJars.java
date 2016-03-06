package JSONParser;

import java.util.Set;

/**
 * Created by nik on 03.03.2016.
 */
public class DependenciesJars {
    String allDependencies = "DB does not have information about jars";
    Set<String> setDep = null;

    public DependenciesJars(String allDependencies, Set<String> setDep) {
        this.allDependencies = allDependencies;
        this.setDep = setDep;
    }

    public DependenciesJars (Set<String> setDep) {
        this.setDep = setDep;
    }

    public String isAllDependencies() {
        return allDependencies;
    }

    public void setAllDependencies(String allDependencies) {
        this.allDependencies = allDependencies;
    }

    public Set<String> getSetDep() {
        return setDep;
    }

    public void setSetDep(Set<String> setDep) {
        this.setDep = setDep;
    }
}
