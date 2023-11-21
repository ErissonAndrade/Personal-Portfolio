package com.personal.PersonalPortfolio.service.interfaces;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import com.personal.PersonalPortfolio.domain.model.utils.SkillCard;

public interface AboutService {
    About create(About aboutToCreate);
    About findById(Long id);

    About update(Long id, About aboutToUpdate);

    About delete(Long id);

    SkillCard getSkillCard(Long aboutId, Long skillCardId);

    SkillCard addSkillCard(Long aboutId, SkillCard skillCard);
    SkillCard updateSkillCard(Long aboutId, Long skillCardId, SkillCard skillCardToUpdate);

}
