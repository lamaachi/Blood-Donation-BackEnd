package org.restapi.minprojetrest.Service.impl;

import org.restapi.minprojetrest.Model.Region;
import org.restapi.minprojetrest.Model.Ville;
import org.restapi.minprojetrest.Repository.RegionRepository;
import org.restapi.minprojetrest.Repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VilleService {
    private final VilleRepository villeRepository;

    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public void saveAllVilles() {
        Map<String, List<String>> regionVillesMap = new HashMap<>();
        regionVillesMap.put("Tanger-Tétouan-Al Hoceïma", Arrays.asList("Tanger", "Tétouan", "Al Hoceïma"));
        regionVillesMap.put("L'Oriental", Arrays.asList("Oujda", "Nador", "Berkane"));
        regionVillesMap.put("Fès-Meknès", Arrays.asList("Fès", "Meknès", "Taza"));
        regionVillesMap.put("Rabat-Salé-Kénitra", Arrays.asList("Rabat", "Salé", "Kénitra"));
        regionVillesMap.put("Béni Mellal-Khénifra", Arrays.asList("Béni Mellal", "Khénifra"));
        regionVillesMap.put("Casablanca-Settat", Arrays.asList("Casablanca", "Settat"));
        regionVillesMap.put("Marrakech-Safi", Arrays.asList("Marrakech", "Essaouira"));
        regionVillesMap.put("Drâa-Tafilalet", Arrays.asList("Errachidia", "Ouarzazate"));
        regionVillesMap.put("Souss-Massa", Arrays.asList("Agadir", "Tiznit"));
        regionVillesMap.put("Guelmim-Oued Noun", Arrays.asList("Guelmim", "Tan-Tan"));
        regionVillesMap.put("Laâyoune-Sakia El Hamra", Arrays.asList("Laâyoune", "Boujdour"));
        regionVillesMap.put("Dakhla-Oued Ed-Dahab", Arrays.asList("Dakhla", "Aousserd"));

        regionVillesMap.values().forEach(villeNames -> {
            villeNames.forEach(villeName -> {
                Ville ville = Ville.builder().name(villeName).build();
                villeRepository.save(ville);
            });
        });
    }
}
