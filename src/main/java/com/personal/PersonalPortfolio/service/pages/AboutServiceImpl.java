package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import com.personal.PersonalPortfolio.domain.model.utils.SkillCard;
import com.personal.PersonalPortfolio.domain.repository.AboutRepository;
import com.personal.PersonalPortfolio.domain.repository.ApiRepository;
import com.personal.PersonalPortfolio.service.interfaces.AboutService;
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
    public About findById(Long id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("About nof found with id" + id));
    }

    @Override
    public About delete(Long id) {
        About aboutToDelete = aboutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("About not found with id" + id));
        aboutRepository.deleteById(id);
        return aboutToDelete;
    }

    @Override
    public About update(Long id, About aboutToUpdate) {
        About getAbout = aboutRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("About nof found with id" + id));

        getAbout.setSkillCardList(aboutToUpdate.getSkillCardList());
        getAbout.setTitle(aboutToUpdate.getTitle());
        getAbout.setText(aboutToUpdate.getText());

        aboutRepository.save(aboutToUpdate);

        return aboutToUpdate;
    }

    @Override
    public SkillCard getSkillCard(Long aboutId, Long skillCardId) {
        About about = this.findById(aboutId);

        return about.getSkillCardList().stream()
                .filter(skillCard -> skillCard.getId().equals(skillCardId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public SkillCard addSkillCard(Long aboutId, SkillCard skillCard) {
        About about = this.findById(aboutId);
        List<SkillCard> skillCardList = about.getSkillCardList();
        skillCardList.add(skillCard);

        aboutRepository.save(about);
        
        return skillCard;
    }

    @Override
    public SkillCard updateSkillCard(Long aboutId, Long skillCardId, SkillCard skillCardToUpdate) {
        About about = this.findById(aboutId);
        SkillCard getSkillCard = about.getSkillCardList().stream()
                .filter(skillCard -> skillCard.equals(skillCard.getId().equals(skillCardId)))
                .findFirst()
                .orElseThrow(null);
        getSkillCard.setName(skillCardToUpdate.getName());
        getSkillCard.setLevel(skillCardToUpdate.getLevel());

        aboutRepository.save(about);

        return getSkillCard;
    }




}
