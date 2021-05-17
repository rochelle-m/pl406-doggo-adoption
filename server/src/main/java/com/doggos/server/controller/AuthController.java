package com.doggos.server.controller;

import com.doggos.server.model.ERole;
import com.doggos.server.model.Role;
import com.doggos.server.model.User;
import com.doggos.server.payload.request.SigninRequest;
import com.doggos.server.payload.request.SignupRequest;
import com.doggos.server.payload.response.JwtResponse;
import com.doggos.server.repository.RoleRepository;
import com.doggos.server.repository.UserRepository;
import com.doggos.server.security.jwt.JwtUtils;
import com.doggos.server.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins="http://localhost:5000", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
            
    JwtUtils jwtUtils;

    @PostMapping(value="/signin", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticate(@RequestBody SigninRequest _user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(_user.getUsername(), _user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream().
                map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(
                jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles
        ));
    }

    @PostMapping(value="/signup", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signup(@RequestBody SignupRequest _user) {
        if (userRepository.existsByEmail(_user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in user");
        }
        if (userRepository.existsByUsername(_user.getUsername())) {
            return ResponseEntity.badRequest().body("Error: Username is already in user");
        }

        User user = new User(_user.getUsername(), _user.getEmail(), passwordEncoder.encode(_user.getPassword()));

        Set<String> strRoles = _user.getRoles();
        Set<Role> userRoles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByRole(ERole.ROLE_USER).
                    orElseThrow(() -> new RuntimeException("Role not found"));

            userRoles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "staff":
                        Role staffRole = roleRepository.findByRole(ERole.ROLE_STAFF).
                                orElseThrow(() -> new RuntimeException("Role not found"));

                        userRoles.add(staffRole);
                        break;
                    case "volunteer":
                        Role volunteerRole = roleRepository.findByRole(ERole.ROLE_VOLUNTEER).
                                orElseThrow(() -> new RuntimeException("Role not found"));

                        userRoles.add(volunteerRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByRole(ERole.ROLE_USER).
                                orElseThrow(() -> new RuntimeException("Role not found"));

                        userRoles.add(userRole);
                }
            });
        }

        user.setRoles(userRoles);
        userRepository.save(user);

        return ResponseEntity.ok("User registered");
    }
}
