package lt.vu.rest;
import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Sector;
import lt.vu.persistence.SectorDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/sectors")
public class SectorsController {
    @Inject
    @Setter @Getter
    private SectorDAO sectorDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Sector sector = sectorDAO.findOne(id);
        if (sector == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        SectorDto dto = new SectorDto();
        dto.setName(sector.getName());
        dto.setId(sector.getId());

        return Response.ok(dto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer id,
            SectorDto sectorDto) {
        try {
            Sector existingSector = sectorDAO.findOne(id);
            if (existingSector == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingSector.setName(sectorDto.getName());
            sectorDAO.update(existingSector);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(
            SectorDto playerData) {
        Sector sector = new Sector();
        sector.setName(playerData.getName());
        sectorDAO.persist(sector);
        return Response.ok().build();
    }
}
