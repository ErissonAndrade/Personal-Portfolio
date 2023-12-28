package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import com.personal.PersonalPortfolio.domain.model.utils.SkillCard;
import com.personal.PersonalPortfolio.domain.repository.AboutRepository;
import com.personal.PersonalPortfolio.domain.repository.ApiRepository;
import com.personal.PersonalPortfolio.service.interfaces.AboutService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AboutServiceImpl implements AboutService {
    private final AboutRepository aboutRepository;
    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public About create(About aboutToCreate) {
        return aboutRepository.save(aboutToCreate);
    }

    @Override
    public About getAboutById(Long id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("About not found with id" + id));
    }

    @Override
    public About delete(Long id) {
        About aboutToDelete = getAboutById(id);

        aboutRepository.deleteById(id);

        return aboutToDelete;
    }

    @Override
    public About update(Long id, About aboutToUpdate) {
        About getAbout = getAboutById(id);

        getAbout.setSkillCardList(aboutToUpdate.getSkillCardList());
        getAbout.setTitle(aboutToUpdate.getTitle());
        getAbout.setText(aboutToUpdate.getText());

        aboutRepository.save(getAbout);

        return aboutToUpdate;
    }

    @Override
    public SkillCard getSkillCard(Long aboutId, Long skillCardId) {
        About getAbout = this.getAboutById(aboutId);

        return getAbout.getSkillCardList().stream()
                .filter(skillCard -> skillCard.getId().equals(skillCardId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("SkillCard not found with id" + skillCardId));
    }

    @Override
    public SkillCard addSkillCard(Long aboutId, SkillCard skillCard) {
        About getAbout = this.getAboutById(aboutId);
        List<SkillCard> skillCardList = getAbout.getSkillCardList();
        skillCardList.add(skillCard);

        aboutRepository.save(getAbout);

        return skillCard;
    }

    @Override
    public SkillCard updateSkillCard(Long aboutId, Long skillCardId, SkillCard skillCardToUpdate) {
        About getAbout= this.getAboutById(aboutId);

        SkillCard getSkillCard = this.getSkillCard(aboutId, skillCardId);

        getSkillCard.setName(skillCardToUpdate.getName());
        getSkillCard.setLevel(skillCardToUpdate.getLevel());

        aboutRepository.save(getAbout);

        return getSkillCard;
    }

    @Override
    public SkillCard deleteSkillCard(Long aboutId, Long skillCardId) {
        About getAbout = this.getAboutById(aboutId);

        SkillCard getSkillCard = this.getSkillCard(aboutId, skillCardId);

        getAbout.getSkillCardList().remove(getSkillCard);

        aboutRepository.save(getAbout);

        return getSkillCard;
    }
}
