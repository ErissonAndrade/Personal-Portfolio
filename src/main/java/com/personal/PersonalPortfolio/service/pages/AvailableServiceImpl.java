package com.personal.PersonalPortfolio.service.pages;

import com.personal.PersonalPortfolio.domain.model.pages.AvailableServices;
import com.personal.PersonalPortfolio.domain.model.utils.ServiceCard;
import com.personal.PersonalPortfolio.domain.repository.ServiceRepository;
import com.personal.PersonalPortfolio.service.interfaces.AvailableServicesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AvailableServiceImpl implements AvailableServicesService {
    private final ServiceRepository serviceRepository;
    AvailableServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
    @Override
    public AvailableServices findById(Long id) {
        return serviceRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Service not found with the id" + id));
    }

    @Override
    public AvailableServices createAvailableServices(AvailableServices availableServices) {
        return serviceRepository.save(availableServices);
    }

    @Override
    public AvailableServices updateAvailableServices(Long id, AvailableServices availableServices) {
        AvailableServices getAvailableServices = this.findById(id);

        getAvailableServices.setServiceCards(availableServices.getServiceCards());
        getAvailableServices.setText(availableServices.getText());
        getAvailableServices.setTitle(availableServices.getText());

        return this.serviceRepository.save(getAvailableServices);
    }

    @Override
    public AvailableServices deleteAvailableServices(Long id) {
        this.serviceRepository.deleteById(id);
        return null;
    }

    @Override
    public String getType(Long availableServicesId, Long typeId) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);

        return getAvailableServices.getType();
    }

    @Override
    public String createType(Long availableServicesId, String type) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);
        getAvailableServices.setType(type);

        this.serviceRepository.save(getAvailableServices);
        return getAvailableServices.getType();
    }

    @Override
    public String deleteType(Long availableServicesId, String typeId) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);

        getAvailableServices.setType(null);

        this.serviceRepository.save(getAvailableServices);

        return getAvailableServices.getType();
    }

    @Override
    public String updateType(Long availableServicesId, String type) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);

        getAvailableServices.setType(type);

        this.serviceRepository.save(getAvailableServices);

        return getAvailableServices.getType();
    }

    @Override
    public List<ServiceCard> getServiceCards(Long availableServicesId) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);

        return getAvailableServices.getServiceCards();
    }

    @Override
    public ServiceCard getServiceCard(Long availableServicesId, Long serviceCardId) {
        List<ServiceCard> serviceCardsList = this.getServiceCards(availableServicesId);

        ServiceCard findServiceCard = serviceCardsList.stream()
                .filter(serviceCard -> serviceCard.getId().equals(serviceCardId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No service card found with id " + serviceCardId));


        return findServiceCard;
    }

    @Override
    public ServiceCard createServiceCard(Long availableServicesId, ServiceCard serviceCard) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);

        List<ServiceCard> serviceCardsList = this.getServiceCards(availableServicesId);

        serviceCardsList.add(serviceCard);

        this.serviceRepository.save(getAvailableServices);

        return serviceCard;
    }

    @Override
    public ServiceCard deleteServiceCard(Long availableServicesId, Long serviceCardId) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);

        List<ServiceCard> serviceCardsList = this.getServiceCards(availableServicesId);

        ServiceCard findServiceCard = this.getServiceCard(availableServicesId, serviceCardId);

        serviceCardsList.remove(findServiceCard);

        this.serviceRepository.save(getAvailableServices);

        return findServiceCard;
    }

    @Override
    public ServiceCard updateServiceCard(Long availableServicesId, Long serviceCardId, ServiceCard serviceCard) {
        AvailableServices getAvailableServices = this.findById(availableServicesId);
        ServiceCard getServiceCard = this.getServiceCard(availableServicesId, serviceCardId);

        getServiceCard.setIcon(serviceCard.getIcon());
        getServiceCard.setPopupWindow(getServiceCard.getPopupWindow());
        getServiceCard.setText(getServiceCard.getText());
        getServiceCard.setTitle(getServiceCard.getTitle());

        this.serviceRepository.save(getAvailableServices);

        return serviceCard;
    }
}
