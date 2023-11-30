package com.personal.PersonalPortfolio.service.interfaces;

import com.personal.PersonalPortfolio.domain.model.pages.Contact;
import com.personal.PersonalPortfolio.domain.model.utils.ContactForm;
import com.personal.PersonalPortfolio.domain.model.utils.ContactInfoCard;

public interface ContactService {
    Contact create(Contact contactToCreate);

    Contact findById(Long id);

    Contact updateContact(Long id, Contact contactToUpdate);

    Contact deleteContact(Long id);

    ContactForm getContactForm(Long contactId);

    ContactForm addContactForm(Long contactId, ContactForm contactFormToCreate);

    ContactForm updateContactForm(Long contactId, ContactForm contactFormToUpdate);

    ContactForm deleteContactForm(Long contactId);

    ContactInfoCard getContactInfoCard(Long contactId, Long contactInfoCardId);

    ContactInfoCard addContactInfoCard(Long contactId, ContactInfoCard newContactInfoCard);

    ContactInfoCard updateContactInfoCard(Long contactId, Long contactInfoCardId, ContactInfoCard contactInfoCardToUpdate);

    ContactInfoCard deleteContactInfoCard(Long contactId, Long contactInfoCardId);

}
