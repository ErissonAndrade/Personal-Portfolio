package com.personal.PersonalPortfolio.domain.repository;

import com.personal.PersonalPortfolio.domain.model.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {

}
