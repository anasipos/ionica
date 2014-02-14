package org.imo.resources;

import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import com.yammer.dropwizard.hibernate.UnitOfWork;
import com.yammer.dropwizard.jersey.params.LongParam;
import org.apache.commons.collections4.CollectionUtils;
import org.imo.dao.PersonDAO;
import org.imo.entities.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO peopleDAO;

    public PersonResource(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @Path("/{personId}")
    @GET
    @UnitOfWork
    public Person getPerson(@PathParam("personId") LongParam personId) {
        final Optional<Person> person = peopleDAO.findById(personId.get());
        if (!person.isPresent()) {
            throw new NotFoundException("No such user.");
        }
        return person.get();
    }

    @GET
    @UnitOfWork
    public List<Person> getAllPersons() {
        List<Person> persons = peopleDAO.findAll();
        if (CollectionUtils.isEmpty(persons)) {
            throw new NotFoundException("No users exist.");
        }
        return persons;
    }

}
