package lt.vu.services;

import lt.vu.entities.Patient;
import lt.vu.persistence.PatientsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PatientService {
    @Inject
    private PatientsDAO patientsDAO;

    @Transactional
    public List<Patient> getPatients(){
        List<Patient> patients = patientsDAO.loadAll();

        return patients;
    }

    @Transactional
    public void createPatient(String name){
        Patient patient = new Patient();
        patient.setName(name);
        patientsDAO.persist(patient);
    }
}
