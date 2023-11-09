package com.personal.PersonalPortfolio.domain.model.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class PopupWindow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<Text> texts;

    private ContactForm contactForm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }

    public ContactForm getContactForm() {
        return contactForm;
    }

    public void setContactForm(ContactForm contactForm) {
        this.contactForm = contactForm;
    }
}
