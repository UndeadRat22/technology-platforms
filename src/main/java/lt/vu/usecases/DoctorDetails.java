package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Appointment;
import lt.vu.entities.Doctor;
import lt.vu.entities.Patient;
import lt.vu.mybatis.dao.DoctorMapper;
import lt.vu.persistence.AppointmentDAO;
import lt.vu.persistence.DoctorDAO;
import lt.vu.persistence.PatientDAO;
import lt.vu.persistence.SectorDAO;
import lt.vu.services.AppointmentDateParser;
import lt.vu.services.ParameterCollector;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Model
public class DoctorDetails {
    @Inject
    private DoctorMapper doctorMapper;
    @Inject
    private DoctorDAO doctorDAO;
    @Inject
    private PatientDAO patientDAO;
    @Inject
    private AppointmentDAO appointmentDAO;
    @Inject
    private ParameterCollector parameterCollector;
    @Inject
    private AppointmentDateParser appointmentDateParser;

    @Getter @Setter
    private Doctor doctor;

    @Getter @Setter
    private Patient newPatient = new Patient();

    @Getter @Setter
    private String newAppointmentTime = new String();

    @Getter @Setter
    private Appointment newAppointment = new Appointment();

    @PostConstruct
    public void init(){
        Integer sectorId = parameterCollector.getInt("doctorId");
        doctor = doctorDAO.findOne(sectorId);
    }

    @Transactional
    public String createPatient(){
        newPatient.setDoctor(doctor);
        patientDAO.persist(newPatient);
        return refreshPageString();
    }

    @Transactional
    public String createAppointment(Patient patient){

        LocalDateTime date = appointmentDateParser.parse(newAppointmentTime);
        newAppointment.setTime(date);

        newAppointment.setPatient(patient);
        newAppointment.setDoctor(doctor);

        appointmentDAO.persist(newAppointment);

        return refreshPageString();
    }

    private String refreshPageString(){
        return "doctors?faces-redirect=true&doctorId=" + doctor.getId();
    }
}
