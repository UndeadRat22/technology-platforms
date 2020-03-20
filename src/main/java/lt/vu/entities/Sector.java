package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Sector.findAll", query = "select s from Sector as s")
})
@Table(name = "SECTOR")
@Getter @Setter
@EqualsAndHashCode
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "sector")
    private List<Doctor> doctors = new ArrayList<>();
}
