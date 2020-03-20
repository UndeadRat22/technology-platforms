package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;

import lt.vu.entities.Sector;
import lt.vu.persistence.SectorDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Sectors {
    @Inject
    private SectorDAO sectorDAO;

    @Getter @Setter
    private Sector newSector = new Sector();

    @Getter
    private List<Sector> allSectors;

    @PostConstruct
    public void init(){
        loadAllSectors();
    }

    @Transactional
    private void loadAllSectors(){
        allSectors = sectorDAO.loadAll();
    }

    @Transactional
    public String createSector(){
        sectorDAO.persist(newSector);
        return "index?faces-redirect=true";
    }


}
