package com.gabriel.authentication.controller;

import java.security.Principal;

import javax.validation.constraints.NotBlank;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.authentication.model.ApplicationUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "Endpoints to manage User's information")
public class UserInfoController {

	
	@GetMapping("info")
	@ApiOperation(value = "Will retrieve the information from the user available in the token", response = ApplicationUser.class)
	public ResponseEntity<ApplicationUser> getUserInfo(@NotBlank @NonNull Principal principal) {
		ApplicationUser applicationUser = (ApplicationUser) ((UsernamePasswordAuthenticationToken) principal)
				.getPrincipal();
		return new ResponseEntity<>(applicationUser, HttpStatus.OK);
	}
}
