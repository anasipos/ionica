package org.imo.entities;

import javax.persistence.*;

@Entity
@Table(name = "offers")
@NamedQueries({
    @NamedQuery(
        name = "org.imo.entities.Offer.findAll",
        query = "SELECT o FROM Offer o"
    ),
    @NamedQuery(
        name = "org.imo.entities.Offer.findById",
        query = "SELECT o FROM Offer o WHERE o.id = :id"
    )
})
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "offerType", nullable = false)
    private String type;

    @Column(name = "offerCity", nullable = false)
    private String city;

    @Column(name = "offerZone", nullable = false)
    private String zone;

    @Column(name = "status", nullable = false)
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
