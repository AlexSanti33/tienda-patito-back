package com.tiendapatito.validarpedido.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapatito.validarpedido.dto.LoginResponse;
import com.tiendapatito.validarpedido.dto.LoginUserDto;
import com.tiendapatito.validarpedido.dto.RegisterUserDto;
import com.tiendapatito.validarpedido.entities.User;
import com.tiendapatito.validarpedido.service.AuthenticationService;
import com.tiendapatito.validarpedido.service.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationApi {

	  @Autowired
	  private JwtService jwtService;
	  
	  @Autowired
	  private AuthenticationService authenticationService;



	    @PostMapping("/signup")
	    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
	        User registeredUser = authenticationService.signup(registerUserDto);

	        return ResponseEntity.ok(registeredUser);
	    }

	    @PostMapping("/login")
	    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
	        User authenticatedUser = authenticationService.authenticate(loginUserDto);

	        String jwtToken = jwtService.generateToken(authenticatedUser);

	        LoginResponse loginResponse = new LoginResponse().builder().token(jwtToken).expiresIn(jwtService.getExpirationTime()).empleado(authenticatedUser.getEmpleado()).build();

	        return ResponseEntity.ok(loginResponse);
	    }
}
