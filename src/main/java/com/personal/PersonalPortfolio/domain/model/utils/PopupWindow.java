package com.personal.PersonalPortfolio.domain.model.utils;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PopupWindow extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ContactForm contactForm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactForm getContactForm() {
        return contactForm;
    }

    public void setContactForm(ContactForm contactForm) {
        this.contactForm = contactForm;
    }
}
