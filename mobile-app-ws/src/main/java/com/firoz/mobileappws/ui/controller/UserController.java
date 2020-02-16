package com.firoz.mobileappws.ui.controller;

import java.awt.PageAttributes.MediaType;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firoz.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.firoz.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

	
	@GetMapping
	public String getUsers(
			@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="limit") int limit,
			@RequestParam(value="sort", defaultValue = "desc" ,required = false) String sort
			) {
		return "get user was called with page " + page +" and limit " + limit + "and sort "+ sort;
	}
	
	
	@GetMapping(path="/{userID}", produces = {
			org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_XML_VALUE
			})
	public UserRest getUser(@PathVariable String userID) {
		UserRest userRest = new UserRest();
		userRest.setFirstName("ram");
		userRest.setLastName("korle");
		userRest.setEmail("lila@khela.com");
			
		return userRest;
	}
	
	@PostMapping(
			consumes  = {
					org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
					org.springframework.http.MediaType.APPLICATION_XML_VALUE
					},
					produces = {
							org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
							org.springframework.http.MediaType.APPLICATION_XML_VALUE
							}
			)
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());
		
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
		
	}
}
