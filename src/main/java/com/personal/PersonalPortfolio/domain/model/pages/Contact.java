package com.personal.PersonalPortfolio.domain.model.pages;

import com.personal.PersonalPortfolio.domain.model.utils.ContactForm;
import com.personal.PersonalPortfolio.domain.model.utils.ContactInfoCard;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    private ContactForm contactForm;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactInfoCard> contactInfoCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ContactForm getContactForm() {
        return contactForm;
    }

    public void setContactForm(ContactForm contactForm) {
        this.contactForm = contactForm;
    }

    public List<ContactInfoCard> getContactInfoCards() {
        return contactInfoCards;
    }

    public void setContactInfoCards(List<ContactInfoCard> contactInfoCards) {
        this.contactInfoCards = contactInfoCards;
    }
}
