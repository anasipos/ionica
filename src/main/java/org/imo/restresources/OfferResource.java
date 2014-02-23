package org.imo.restresources;

import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.dropwizard.jersey.params.LongParam;
import org.apache.commons.collections4.CollectionUtils;
import org.imo.dao.OfferDAO;
import org.imo.entities.Offer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/offers")
@Produces(MediaType.APPLICATION_JSON)
public class OfferResource {

    private final OfferDAO offerDAO;

    public OfferResource(OfferDAO offerDAO) {
        this.offerDAO = offerDAO;
    }

    @Path("/{offerId}")
    @GET
    @UnitOfWork
    public Offer getOffer(@PathParam("offerId") LongParam offerId) {
        final Optional<Offer> offer = offerDAO.findById(offerId.get());
        if (!offer.isPresent()) {
            throw new NotFoundException("No such offer.");
        }
        return offer.get();
    }

    @GET
    @UnitOfWork
    public List<Offer> getAllOffers() {
        List<Offer> offers = offerDAO.findAll();
        if (CollectionUtils.isEmpty(offers)) {
            throw new NotFoundException("No offers exist.");
        }
        return offers;
    }
}
