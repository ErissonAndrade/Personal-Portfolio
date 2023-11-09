package com.personal.PersonalPortfolio.domain.repository;

import com.personal.PersonalPortfolio.domain.model.API;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIRepository extends JpaRepository<API, Long> {

}
