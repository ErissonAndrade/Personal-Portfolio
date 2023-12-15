package com.personal.PersonalPortfolio.service.interfaces;

import com.personal.PersonalPortfolio.domain.model.pages.AvailableServices;
import com.personal.PersonalPortfolio.domain.model.utils.ServiceCard;

import java.util.List;

public interface AvailableServicesService {
    AvailableServices findById(Long id);

    AvailableServices createAvailableServices(AvailableServices availableServices);

    AvailableServices updateAvailableServices(Long id, AvailableServices availableServices);

    AvailableServices deleteAvailableServices(Long id);

    String getType(Long availableServicesId, Long typeId);

    String createType(Long availableServicesId, String type);

    String deleteType(Long availableServicesId, String typeId);

    String updateType(Long availableServicesId, String type);

    List<ServiceCard> getServiceCards(Long availableServicesId);

    ServiceCard getServiceCard(Long availableServicesId, Long serviceCardId);

    ServiceCard createServiceCard(Long availableServicesId, ServiceCard serviceCard);

    ServiceCard deleteServiceCard(Long availableServicesId, Long serviceCardId);

    ServiceCard updateServiceCard(Long availableServicesId, Long serviceCardId, ServiceCard serviceCard);
}
