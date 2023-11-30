package com.personal.PersonalPortfolio.service.interfaces;

import com.personal.PersonalPortfolio.domain.model.pages.Home;

public interface HomeService {

    Home createHome(Home home);

    Home getHomeById(Long id);

    Home updateHome(Long id, Home newHome);

    Home deleteHome(Long id);

    String createGreetings(Long homeId, String newGreetings);
    String getGreetings(Long homeId);

    String updateGreetings(Long homeId, String newGreetings);

    String deleteGreetings(Long homeId);

    String createName(Long homeId, String name);

    String getName(Long homeId);

    String updateName(Long homeId, String newName);

    String deleteName(Long homeId);

    String createRole(Long homeId, String newRole);
    String getRole(Long id);

    String updateRole(Long homeId, String newRole);

    String deleteRole(Long homeId);

   String createIntro(Long homeId, String newIntro);

   String getIntro(Long homeId);

   String updateIntro(Long homeId, String newIntro);

   String deleteIntro(Long homeId);
   String createPictureURL(Long homeId, String newUrl);

   String getPictureURL(Long homeId);

   String updatePictureUrl(Long homeId, String newPictureUrl);

   String deletePictureUrl(Long homeId);
}
