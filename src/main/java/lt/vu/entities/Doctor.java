package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Doctor.findAll", query = "select a from Doctor as a")
})
@Table(name = "DOCTOR")
@Getter @Setter
@EqualsAndHashCode
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients = new ArrayList<>();
}
