package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Appointment.findAll", query = "select a from Appointment as a")
})
@Table(name = "APPOINTMENT")
@Getter @Setter
@EqualsAndHashCode
public class Appointment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TIME")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;
}