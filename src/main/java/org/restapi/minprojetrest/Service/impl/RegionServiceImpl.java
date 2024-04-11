package org.restapi.minprojetrest.Service.impl;

import org.restapi.minprojetrest.Model.Region;
import org.restapi.minprojetrest.Repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegionServiceImpl {
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> saveAllRegions() {
        List<String> regionNames = Arrays.asList(
                "Tanger-Tétouan-Al Hoceïma",
                "L'Oriental",
                "Fès-Meknès",
                "Rabat-Salé-Kénitra",
                "Béni Mellal-Khénifra",
                "Casablanca-Settat",
                "Marrakech-Safi",
                "Drâa-Tafilalet",
                "Souss-Massa",
                "Guelmim-Oued Noun",
                "Laâyoune-Sakia El Hamra",
                "Dakhla-Oued Ed-Dahab"
        );

        return regionRepository.saveAll(
                regionNames.stream()
                        .map(name -> Region.builder().name(name).build())
                        .toList()
        );
    }
}
