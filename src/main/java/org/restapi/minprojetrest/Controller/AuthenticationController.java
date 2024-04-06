package org.restapi.minprojetrest.Controller;

import org.restapi.minprojetrest.Model.AppUser;
import org.restapi.minprojetrest.Model.AuthenticationResponse;
import org.restapi.minprojetrest.Service.impl.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/")
public class AuthenticationController {
        private  final AuthServiceImpl authService;

    public AuthenticationController(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AppUser request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AppUser request) {

        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/profile")
    public ResponseEntity<Authentication> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }
}
