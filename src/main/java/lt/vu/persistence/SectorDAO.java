package lt.vu.persistence;

import lombok.Setter;
import lt.vu.entities.Sector;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SectorDAO {
    @Inject @Setter
    private EntityManager entityManager;

    public void persist(Sector sector) {
        entityManager.persist(sector);
    }

    public List<Sector> loadAll(){
        return entityManager.createNamedQuery("Sector.findAll", Sector.class)
                .getResultList();
    }

    public Sector findOne(Integer id){
        return entityManager.find(Sector.class, id);
    }

    public Sector update(Sector sector){
        return entityManager.merge(sector);
    }
}
