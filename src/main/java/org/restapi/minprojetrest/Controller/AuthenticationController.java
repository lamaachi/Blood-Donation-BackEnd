package org.restapi.minprojetrest.Controller;

import jakarta.transaction.Transactional;
import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.AuthenticationResponse;
import org.restapi.minprojetrest.Model.DTO.AppUserDTO;
import org.restapi.minprojetrest.Repository.AppUserRepository;
import org.restapi.minprojetrest.Service.impl.AuthServiceImpl;
import org.restapi.minprojetrest.Service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/api/v1/")
public class AuthenticationController {
        private  final AuthServiceImpl authService;
        private final UserServiceImpl userService;

    public AuthenticationController(AuthServiceImpl authService, UserServiceImpl userService, AppUserRepository appUserRepository) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AppUser request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AppUser request) {

        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/profile")
    public ResponseEntity<AppUserDTO> getUserByUsername(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        AppUserDTO userDTO = userService.getAppUserByUsername(username);
        return ResponseEntity.ok(userDTO);
    }


    @DeleteMapping("/user/delete/{userId}")
    @Transactional
    public ResponseEntity<String> removeUser(@PathVariable Long userId) {
        userService.removeuser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
