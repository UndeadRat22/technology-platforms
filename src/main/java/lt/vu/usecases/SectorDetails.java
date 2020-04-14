package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Doctor;
import lt.vu.entities.Sector;
import lt.vu.mybatis.dao.SectorMapper;
import lt.vu.persistence.DoctorDAO;
import lt.vu.persistence.SectorDAO;
import lt.vu.services.ParameterCollector;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
public class SectorDetails {
    @Inject
    private SectorMapper sectorMapper;
    @Inject
    private SectorDAO sectorDAO;
    @Inject
    private DoctorDAO doctorDAO;

    @Inject
    private ParameterCollector parameterCollector;

    @Getter @Setter
    private Sector sector;

    @Getter @Setter
    private Doctor newDoctor = new Doctor();

    @PostConstruct
    public void init(){
        Integer sectorId = parameterCollector.getInt("sectorId");
        sector = sectorDAO.findOne(sectorId);
    }

    @Transactional
    public String createDoctor(){
        newDoctor.setSector(sector);
        doctorDAO.persist(newDoctor);
        return "sectors?faces-redirect=true&sectorId=" + sector.getId();
    }

    @Transactional
    public String updateSectorName(){
        lt.vu.mybatis.model.Sector updatedSector = new lt.vu.mybatis.model.Sector();
        updatedSector.setId(sector.getId());
        updatedSector.setName(sector.getName());
        sectorMapper.updateByPrimaryKey(updatedSector);

        return "sectors?faces-redirect=true&sectorId=" + sector.getId();
    }
}
