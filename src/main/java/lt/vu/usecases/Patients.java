package lt.vu.usecases;
import lombok.Getter;
import lt.vu.entities.Patient;
import lt.vu.services.PatientService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Patients {
    @Inject
    private PatientService patientService;

    @Getter
    private List<Patient> allPatients;

    @PostConstruct
    public void init(){
        allPatients = patientService.getPatients();
    }
}
