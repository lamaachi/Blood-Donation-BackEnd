package org.restapi.minprojetrest.Controller;

import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Repository.AppUserRepository;
import org.restapi.minprojetrest.Service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserServiceImpl userService;
    private final AppUserRepository appUserRepository;
    public UserController(UserServiceImpl userService, AppUserRepository appUserRepository) {
        this.userService = userService;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/users")
    public List<AppUser> getAll(){
        return  userService.getAllUSers();
    }

    @GetMapping("/connected")
    public List<AppUser> findByName(@RequestBody String username ){
        Optional<AppUser> user = appUserRepository.findByUsername(username);
        return user.map(appUser -> (List<AppUser>) ResponseEntity.ok(appUser)).orElseGet(() -> (List<AppUser>) ResponseEntity.notFound().build());
    }


}
