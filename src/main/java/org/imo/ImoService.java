package org.imo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import org.imo.dao.PersonDAO;
import org.imo.entities.Person;
import org.imo.resources.PersonResource;

public class ImoService extends Service<ImoConfiguration> {

    private final HibernateBundle<ImoConfiguration> hibernate = new HibernateBundle<ImoConfiguration>(Person.class) {
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
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(ImoConfiguration configuration,
                    Environment environment) {
        final PersonDAO dao = new PersonDAO(hibernate.getSessionFactory());
        environment.addResource(new PersonResource(dao));
    }

}