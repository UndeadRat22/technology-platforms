package lt.vu.persistence;

import lt.vu.entities.Patient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PatientsDAO {
    @Inject
    private EntityManager entityManager;

    public List<Patient> loadAll(){
        return entityManager.createNamedQuery("Patient.findAll", Patient.class)
                .getResultList();
    }

    public void persist(Patient patient){
        entityManager.persist(patient);
    }

    public Patient findOne(Integer id){
        return entityManager.find(Patient.class, id);
    }
}
