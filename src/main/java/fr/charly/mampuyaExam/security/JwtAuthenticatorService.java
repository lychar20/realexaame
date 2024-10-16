package fr.charly.mampuyaExam.security;

import fr.charly.mampuyaExam.DTO.UserLoginDTO;
import fr.charly.mampuyaExam.response.JwtResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtAuthenticatorService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public ResponseEntity<JwtResponse> authenticate(UserLoginDTO dto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

            String token = jwtService.generateToken(dto.getEmail());
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (AuthenticationException e) {
            System.out.println("ca marche pas idiot");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //
        // IF you want to use a login based on multiple fields (like email or username)
        // u should get the UserDetails from the impl. of UserDetailsService and use the
        // loadUserByUsername method to get the UserDetails
        //
//        UserDetails userDetails = userRedditishService.loadUserByUsername(dto.getEmail());
//        if (userDetails != null) {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            userDetails.getUsername(), dto.getPassword()));
//
//            String token = jwtService.generateToken(userDetails.getUsername());
//            return ResponseEntity.ok(new JwtResponse(token));
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
