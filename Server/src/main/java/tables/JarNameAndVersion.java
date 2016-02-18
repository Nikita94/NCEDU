package tables;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nik on 17.02.2016.
 */
@Entity
@Table(name="jar_name_and_version")
public class JarNameAndVersion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name_and_version")
    private String nameAndVersion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jar_name_and_version")
    private List<Dependencies> dependencies;

    public JarNameAndVersion () {}

    public JarNameAndVersion(String nameAndVersion, List<Dependencies> dependencies) {
        this.nameAndVersion = nameAndVersion;
        this.dependencies = dependencies;
    }

    public List<Dependencies> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependencies> dependencies) {
        this.dependencies = dependencies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAndVersion() {
        return nameAndVersion;
    }

    public void setNameAndVersion(String nameAndVersion) {
        this.nameAndVersion = nameAndVersion;
    }
}
