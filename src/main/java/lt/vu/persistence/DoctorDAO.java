package lt.vu.persistence;
        import lt.vu.entities.Doctor;
        import javax.enterprise.context.ApplicationScoped;
        import javax.inject.Inject;
        import javax.persistence.EntityManager;
        import java.util.List;

@ApplicationScoped
public class DoctorDAO {
    @Inject
    private EntityManager entityManager;

    public void persist(Doctor doctor) {
        entityManager.persist(doctor);
    }

    public List<Doctor> loadAll(){
        return entityManager.createNamedQuery("Doctor.findAll", Doctor.class)
                .getResultList();
    }

    public Doctor findOne(Integer id){
        return entityManager.find(Doctor.class, id);
    }

    public Doctor update(Doctor doctor){
        return entityManager.merge(doctor);
    }
}
