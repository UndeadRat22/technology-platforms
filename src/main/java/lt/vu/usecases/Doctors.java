package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Doctor;
import lt.vu.services.DoctorService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Doctors {
    @Inject
    private DoctorService doctorService;

    @Getter
    private List<Doctor> allDoctors;

    @Getter @Setter
    private Doctor doctorToCreate = new Doctor();

    @PostConstruct
    public void init() {
        allDoctors = doctorService.getDoctors();
    }

    @Transactional
    public String createDoctor(){
        doctorService.createDoctor(doctorToCreate);
        return "index?faces-redirect=true";
    }
}
