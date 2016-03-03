package JSONParser;

import java.util.Set;

/**
 * Created by nik on 03.03.2016.
 */
public class DependenciesJars {
    boolean allDependencies = false;
    Set<String> setDep = null;

    public DependenciesJars(boolean allDependencies, Set<String> setDep) {
        this.allDependencies = allDependencies;
        this.setDep = setDep;
    }

    public boolean isAllDependencies() {
        return allDependencies;
    }

    public void setAllDependencies(boolean allDependencies) {
        this.allDependencies = allDependencies;
    }

    public Set<String> getSetDep() {
        return setDep;
    }

    public void setSetDep(Set<String> setDep) {
        this.setDep = setDep;
    }
}
