package org.imo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import org.imo.dao.OfferDAO;
import org.imo.entities.Offer;
import org.imo.restresources.OfferResource;

public class ImoService extends Service<ImoConfiguration> {

    private final HibernateBundle<ImoConfiguration> hibernate = new HibernateBundle<ImoConfiguration>(Offer.class) {
        @Override
        public DatabaseConfiguration getDatabaseConfiguration(ImoConfiguration configuration) {
            return configuration.getDatabaseConfiguration();
        }
    };

    public static void main(String[] args) throws Exception {
        new ImoService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ImoConfiguration> bootstrap) {
        bootstrap.setName("Imobiliare");
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new AssetsBundle("/web/", "/"));
    }

    @Override
    public void run(ImoConfiguration configuration,
                    Environment environment) {
        final OfferDAO dao = new OfferDAO(hibernate.getSessionFactory());
        environment.addResource(new OfferResource(dao));
    }

}