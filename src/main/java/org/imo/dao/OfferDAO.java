package org.imo.dao;

import com.google.common.base.Optional;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.imo.entities.Offer;

import java.util.List;

public class OfferDAO extends AbstractDAO<Offer> {
    public OfferDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Offer> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Offer create(Offer offer) {
        return persist(offer);
    }

    public List<Offer> findAll() {
        return list(namedQuery("org.imo.entities.Offer.findAll"));
    }
}
