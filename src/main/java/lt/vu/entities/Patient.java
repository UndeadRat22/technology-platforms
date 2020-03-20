package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name= "Patient.findAll", query = "select p from Patient as p")
})
@Getter @Setter
@EqualsAndHashCode
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "MAIN_DOCTOR_ID")
    private Doctor doctor;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
