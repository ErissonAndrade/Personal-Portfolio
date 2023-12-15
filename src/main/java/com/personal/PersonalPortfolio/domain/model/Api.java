package com.personal.PersonalPortfolio.domain.model;

import com.personal.PersonalPortfolio.domain.model.pages.*;
import jakarta.persistence.*;

@Entity
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Home home;

    @OneToOne(cascade = CascadeType.ALL)
    private About about;

    @OneToOne(cascade = CascadeType.ALL)
    private AvailableServices availableServices;

    @OneToOne(cascade = CascadeType.ALL)
    private Portfolio portfolio;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

    public AvailableServices getService() {
        return availableServices;
    }

    public void setService(AvailableServices availableServices) {
        this.availableServices = availableServices;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
