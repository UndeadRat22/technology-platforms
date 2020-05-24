package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Doctor;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.DoctorDAO;
import lt.vu.services.ParameterCollector;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;

@ViewScoped
@Named
@Getter @Setter
public class UpdateDoctorDetails implements Serializable {

    private Doctor doctor;
    @Inject
    private ParameterCollector parameterCollector;
    @Inject
    private DoctorDAO doctorDAO;

    @PostConstruct
    private void init(){
        Integer doctorId = parameterCollector.getInt("doctorId");
        doctor = doctorDAO.findOne(doctorId);
    }

    @Transactional
    @LoggedInvocation
    public String updateDoctorName(){
        try {
            doctorDAO.update(this.doctor);
        } catch (OptimisticLockException e){
            return refreshPageString() + "&error=optimistic-lock-exception";
        }
        return refreshPageString();
    }

    private String refreshPageString(){
        return "doctors?faces-redirect=true&doctorId=" + doctor.getId();
    }
}
