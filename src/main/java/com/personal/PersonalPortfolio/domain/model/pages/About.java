package com.personal.PersonalPortfolio.domain.model.pages;

import com.personal.PersonalPortfolio.domain.model.utils.SkillCard;
import com.personal.PersonalPortfolio.domain.model.utils.Text;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class About extends Text {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
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
