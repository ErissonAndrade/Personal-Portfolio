package com.personal.PersonalPortfolio.controller;

import com.personal.PersonalPortfolio.domain.model.pages.About;
import com.personal.PersonalPortfolio.domain.model.utils.SkillCard;
import com.personal.PersonalPortfolio.service.interfaces.AboutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about")
public class AboutController {
    private final AboutService aboutService;
    AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public About about() {
        return this.aboutService.getAboutById(1L);
    }

    @GetMapping("/{id}")
    public About getAbout(@PathVariable Long id) {
        return this.aboutService.getAboutById(id);
    }

    @PostMapping
    public About createAbout(@RequestBody About aboutToCreate){
        return this.aboutService.create(aboutToCreate);
    }

    @PutMapping("/{id}")
    public About updateAbout(@PathVariable Long id, @RequestBody About aboutToUpdate){
        return this.aboutService.update(id, aboutToUpdate);
    }

    @DeleteMapping("/{id}")
    public About deleteAbout(@PathVariable Long id){
        return this.aboutService.delete(id);
    }

    @GetMapping("/{id}/skill-cards")
    public List<SkillCard> getAboutSkills(@PathVariable Long id){
        return this.aboutService.getAboutById(id).getSkillCardList();
    }

    @PostMapping("/{id}/skill-cards")
    public SkillCard addAboutSkill(@PathVariable Long id, @RequestBody SkillCard skillCard){
        return this.aboutService.addSkillCard(id, skillCard);
    }

    @PutMapping("/{id}/skill-cards/{skillCardId}")
    public SkillCard updateAboutSkill(@PathVariable Long id, @PathVariable Long skillCardId, @RequestBody SkillCard skillCardToUpdate){
        return this.aboutService.updateSkillCard(id, skillCardId, skillCardToUpdate);
    }

    @DeleteMapping("/{id}/skill-cards/{skillCardId}")
    public SkillCard deleteAboutSkill(@PathVariable Long id, @PathVariable Long skillCardId){
        return this.aboutService.deleteSkillCard(id, skillCardId);
    }
}
