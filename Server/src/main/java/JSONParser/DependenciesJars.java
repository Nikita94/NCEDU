package JSONParser;

import java.util.Set;

/**
 * Created by nik on 03.03.2016.
 */
public class DependenciesJars {
    String infoAboutDependencies = "";
    Set<String> setDep = null;

    public DependenciesJars(String allDependencies, Set<String> setDep) {
        this.infoAboutDependencies = allDependencies;
        this.setDep = setDep;
    }

    public String isAllDependencies() {
        return infoAboutDependencies;
    }

    public void setAllDependencies(String allDependencies) {
        this.infoAboutDependencies = allDependencies;
    }

    public Set<String> getSetDep() {
        return setDep;
    }

    public void setSetDep(Set<String> setDep) {
        this.setDep = setDep;
    }
}
