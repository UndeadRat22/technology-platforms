package lt.vu.services;

import lt.vu.entities.Appointment;
import lt.vu.entities.Doctor;
import lt.vu.entities.Patient;
import lt.vu.persistence.AppointmentsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AppointmentService {
    @Inject
    private AppointmentsDAO appointmentsDAO;

    @Transactional
    public List<Appointment> getAppointmentsForPatient(Integer patientId){
        return appointmentsDAO.loadAll().stream()
                .filter(appointment -> appointment.getPatient().getId().equals(patientId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void createAppointment(Patient patient, Doctor doctor, Date date){
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setTime(date);

        appointmentsDAO.persist(appointment);
    }
}
