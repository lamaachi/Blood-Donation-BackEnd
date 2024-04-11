package org.restapi.minprojetrest.Service.impl;

import jakarta.transaction.Transactional;
import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.DTO.AppUserDTO;
import org.restapi.minprojetrest.Repository.AppUserRepository;
import org.restapi.minprojetrest.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final AppUserRepository appUserRepository;

    public UserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public List<AppUser> getAllUSers() {
        return appUserRepository.findAll();
    }

    @Override
    public void removeuser(Long id) {
        appUserRepository.deleteById(id);
    }

    @Transactional()
    public AppUserDTO getAppUserByUsername(String username) {
        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(username);
        AppUser appUser = optionalAppUser.orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        return AppUserDTO.toDto(appUser);
    }
}
