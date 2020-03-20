package lt.vu.persistence;

import lt.vu.entities.Doctor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DoctorsDAO {
    @Inject
    private EntityManager entityManager;

    public List<Doctor> loadAll() {
        return entityManager.createNamedQuery("Doctor.findAll", Doctor.class)
                .getResultList();
    }
    public void persist(Doctor doctor) {
        entityManager.persist(doctor);
    }
    public Doctor findOne(Integer id){
        return entityManager.find(Doctor.class, id);
    }
}
