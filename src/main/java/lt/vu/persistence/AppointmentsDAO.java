package lt.vu.persistence;

import lt.vu.entities.Appointment;
import lt.vu.entities.Doctor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AppointmentsDAO {
    @Inject
    private EntityManager entityManager;

    public List<Appointment> loadAll() {
        return entityManager.createNamedQuery("Appointment.findAll", Appointment.class)
                .getResultList();
    }
    public void persist(Appointment appointment) {
        entityManager.persist(appointment);
    }
    public Appointment findOne(Integer id){
        return entityManager.find(Appointment.class, id);
    }
}
