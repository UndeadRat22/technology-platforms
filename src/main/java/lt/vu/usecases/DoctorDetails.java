package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Doctor;
import lt.vu.entities.Patient;
import lt.vu.persistence.DoctorDAO;
import lt.vu.persistence.PatientDAO;
import lt.vu.persistence.SectorDAO;
import lt.vu.services.ParameterCollector;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class DoctorDetails {
    @Inject
    private DoctorDAO doctorDAO;
    @Inject
    private PatientDAO patientDAO;
    @Inject
    private ParameterCollector parameterCollector;

    @Getter @Setter
    private Doctor doctor;

    @Getter @Setter
    private Patient newPatient = new Patient();

    //TODO: appointments List<Appointment>

    @PostConstruct
    public void init(){
        Integer sectorId = parameterCollector.getInt("doctorId");
        doctor = doctorDAO.findOne(sectorId);
    }

    @Transactional
    public String createPatient(){
        newPatient.setDoctor(doctor);
        patientDAO.persist(newPatient);
        return "doctors?faces-redirect=true&doctorId=" + doctor.getId();
    }
}
