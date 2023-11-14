package com.personal.PersonalPortfolio.domain.model.pages;

import com.personal.PersonalPortfolio.domain.model.utils.ServiceCard;
import com.personal.PersonalPortfolio.domain.model.utils.Text;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Service extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ServiceCard> serviceCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ServiceCard> getServiceCards() {
        return serviceCards;
    }

    public void setServiceCards(List<ServiceCard> serviceCards) {
        this.serviceCards = serviceCards;
    }
}
