package tables;

import javax.persistence.*;

/**
 * Created by nik on 18.02.2016.
 */

@Entity
@Table(name = "dependencies")
public class Dependencies {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    @JoinColumn(name = "d_id")
    private JarNameAndVersion d_id;

    @Column(name = "name_and_version")
    private String nameAndVersionD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JarNameAndVersion getD_id() {
        return d_id;
    }

    public Dependencies(JarNameAndVersion d_id, String nameAndVersionD) {
        this.d_id = d_id;
        this.nameAndVersionD = nameAndVersionD;
    }

    public void setD_id(int JarNameAndVersion) {
        this.d_id = d_id;
    }

    public String getNameAndVersionD() {
        return nameAndVersionD;
    }

    public void setNameAndVersionD(String nameAndVersionD) {
        this.nameAndVersionD = nameAndVersionD;
    }
}
