package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Patient.findAll", query = "select a from Patient as a")
})
@Table(name = "PATIENT")
@Getter @Setter
@EqualsAndHashCode
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;
}