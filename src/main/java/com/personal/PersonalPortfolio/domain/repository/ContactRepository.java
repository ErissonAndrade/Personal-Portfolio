package com.personal.PersonalPortfolio.domain.repository;

import com.personal.PersonalPortfolio.domain.model.pages.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
