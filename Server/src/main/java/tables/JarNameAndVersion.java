package tables;

import javax.persistence.*;

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

    public JarNameAndVersion() {}

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
