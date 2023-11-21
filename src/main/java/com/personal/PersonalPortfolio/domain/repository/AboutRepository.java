package com.personal.PersonalPortfolio.domain.repository;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {

}
