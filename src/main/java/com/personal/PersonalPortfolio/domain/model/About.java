package com.personal.PersonalPortfolio.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class About extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<SkillCard> skillCardList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SkillCard> getSkillCardList() {
        return skillCardList;
    }

    public void setSkillCardList(List<SkillCard> skillCardList) {
        this.skillCardList = skillCardList;
    }
}
