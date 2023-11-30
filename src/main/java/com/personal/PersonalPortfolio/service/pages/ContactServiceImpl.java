package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.pages.Contact;
import com.personal.PersonalPortfolio.domain.model.utils.ContactForm;
import com.personal.PersonalPortfolio.domain.model.utils.ContactInfoCard;
import com.personal.PersonalPortfolio.domain.repository.ContactRepository;
import com.personal.PersonalPortfolio.service.interfaces.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact create(Contact contactToCreate) {
        return contactRepository.save(contactToCreate);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Contact not found with id" + id));
    }

    @Override
    public Contact updateContact(Long id, Contact contactToUpdate) {
        Contact getContact = this.findById(id);

        getContact.setText(contactToUpdate.getText());
        getContact.setTitle(contactToUpdate.getTitle());
        getContact.setContactForm(contactToUpdate.getContactForm());
        getContact.setContactInfoCards(contactToUpdate.getContactInfoCards());

        contactRepository.save(getContact);

        return contactToUpdate;
    }

    @Override
    public Contact deleteContact(Long id) {
        Contact getContact = this.findById(id);

        contactRepository.deleteById(id);

        return getContact;
    }

    @Override
    public ContactForm getContactForm(Long contactId) {
        Contact getContact = this.findById(contactId);

        return getContact.getContactForm();
    }

    @Override
    public ContactForm addContactForm(Long contactId, ContactForm contactFormToCreate) {
        Contact getContact = this.findById(contactId);
        getContact.setContactForm(contactFormToCreate);

        contactRepository.save(getContact);

        return getContact.getContactForm();
    }

    @Override
    public ContactForm updateContactForm(Long contactId, ContactForm contactFormToUpdate) {
        Contact getContact = this.findById(contactId);
        getContact.setContactForm(contactFormToUpdate);

        contactRepository.save(getContact);

        return getContact.getContactForm();
    }

    @Override
    public ContactForm deleteContactForm(Long contactId) {
        Contact getContact = this.findById(contactId);
        getContact.setContactForm(null);

        contactRepository.save(getContact);

        return getContact.getContactForm();
    }

    @Override
    public ContactInfoCard getContactInfoCard(Long contactId, Long contactInfoCardId) {
        Contact getContact = this.findById(contactId);

        return getContact.getContactInfoCards().stream()
                .filter(contactInfoCard -> contactInfoCard.getId().equals(contactId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Contact info card not found with id: " + contactInfoCardId));
    }

    @Override
    public ContactInfoCard addContactInfoCard(Long contactId, ContactInfoCard newContactInfoCard) {
        Contact getContact = this.findById(contactId);
        List<ContactInfoCard> getContactInfoCards = getContact.getContactInfoCards();

        getContactInfoCards.add(newContactInfoCard);

        contactRepository.save(getContact);

        return newContactInfoCard;
    }

    @Override
    public ContactInfoCard updateContactInfoCard(Long contactId, Long contactInfoCardId, ContactInfoCard contactInfoCardToUpdate) {
        Contact getContact = this.findById(contactId);
        ContactInfoCard getContactInfoCard = getContact.getContactInfoCards().stream()
                .filter(contactInfoCard -> contactInfoCard.getId().equals(contactInfoCardId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Contact info card not found with id: " + contactInfoCardId));

        getContactInfoCard.setIconURL(contactInfoCardToUpdate.getIconURL());
        getContactInfoCard.setTitle(contactInfoCardToUpdate.getTitle());
        getContactInfoCard.setText(contactInfoCardToUpdate.getText());

        contactRepository.save(getContact);

        return contactInfoCardToUpdate;
    }

    @Override
    public ContactInfoCard deleteContactInfoCard(Long contactId, Long contactInfoCardId) {
        Contact getContact = this.findById(contactId);

        ContactInfoCard getContactInfoCard = getContact.getContactInfoCards().stream()
                .filter(contactInfoCard -> contactInfoCard.getId().equals(contactInfoCardId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Contact info card not found with id: " + contactInfoCardId));

        getContact.getContactInfoCards().remove(getContactInfoCard);

        contactRepository.save(getContact);

        return getContactInfoCard;
    }
}
