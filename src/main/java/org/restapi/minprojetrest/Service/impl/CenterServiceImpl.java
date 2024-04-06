package org.restapi.minprojetrest.Service.impl;

import org.restapi.minprojetrest.Model.Centre;
import org.restapi.minprojetrest.Repository.CenterRepository;
import org.restapi.minprojetrest.Service.CenterService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImpl implements CenterService {

    CenterRepository centerRepository;
    public CenterServiceImpl(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    @Override
    public List<Centre> getAllCentres() {
        return centerRepository.findAll();
    }

    @Override
    public Optional<Centre> getCentreById(int id) {
        return centerRepository.findById(id);
    }

    @Override
    public Centre createCentre(Centre centre) {
        centerRepository.save(centre);
        return centre;
    }

    @Override
    public Centre updateCentre(int id, Centre centreDetails) {
        Optional<Centre> centre = centerRepository.findById(id);
        if(centre.isPresent()){
            Centre updatedCentre = centre.get();
            updatedCentre.setName(centreDetails.getName());
            updatedCentre.setAddress(centreDetails.getAddress());
            updatedCentre.setCity(centreDetails.getCity());
            updatedCentre.setMaxCapacity(centreDetails.getMaxCapacity());
            updatedCentre.setOpeningHours(centreDetails.getOpeningHours());
            return centerRepository.save(updatedCentre);
        }else{
            throw new RuntimeException("Centre not found with id: " + id);
        }
    }

    @Override
    public void deleteCentre(int id) {
        Optional<Centre> centre = centerRepository.findById(id);
        if (centre.isPresent()) {
            centerRepository.delete(centre.get());
        } else {
            throw new RuntimeException("Centre not found with id: " + id);
        }
    }
}
