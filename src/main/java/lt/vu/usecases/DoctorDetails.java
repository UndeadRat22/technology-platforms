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
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@SessionScoped
@Named
public class DoctorDetails implements Serializable {
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
        Integer doctorId = parameterCollector.getInt("doctorId");
        doctor = doctorDAO.findOne(doctorId);
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
