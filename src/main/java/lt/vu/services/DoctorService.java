package lt.vu.services;

import lt.vu.entities.Doctor;
import lt.vu.persistence.DoctorsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DoctorService {
    @Inject
    private DoctorsDAO doctorsDAO;

    @Transactional
    public List<Doctor> getDoctors(){
        List<Doctor> doctors = doctorsDAO.loadAll();

        return doctors;
    }

    @Transactional
    public void createDoctor(String name){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctorsDAO.persist(doctor);
    }

    @Transactional
    public void createDoctor(Doctor doctor){
        doctorsDAO.persist(doctor);
    }
}
