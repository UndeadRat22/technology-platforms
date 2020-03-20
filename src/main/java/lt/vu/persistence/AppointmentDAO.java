package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Appointment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AppointmentDAO {
    @Inject
    @Setter
    private EntityManager entityManager;

    public void persist(Appointment appointment) {
        entityManager.persist(appointment);
    }

    public List<Appointment> loadAll(){
        return entityManager.createNamedQuery("Appointment.findAll", Appointment.class)
                .getResultList();
    }

    public Appointment findOne(Integer id){
        return entityManager.find(Appointment.class, id);
    }

    public Appointment update(Appointment doctor){
        return entityManager.merge(doctor);
    }
}
