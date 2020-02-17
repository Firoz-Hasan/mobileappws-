package com.firoz.mobileappws.ui.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

	Map<String, UserRest> users;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit",defaultValue = "1") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page " + page + " and limit " + limit + "and sort " + sort;
	}

	@GetMapping(path = "/{userID}", produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
		/*
		 * UserRest userRest = new UserRest(); userRest.setFirstName("ram");
		 * userRest.setLastName("korle"); userRest.setEmail("lila@khela.com");
		 * 
		 * return userRest;
		 */

		if (users.containsKey(userID)) {
			return new ResponseEntity<UserRest>(users.get(userID), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/status/{userID}", produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUserWithStatusReturn(@PathVariable String userID) {
		UserRest userRest = new UserRest();
		userRest.setFirstName("ram");
		userRest.setLastName("korle");
		userRest.setEmail("lila@khela.com");

		return new ResponseEntity<UserRest>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping(consumes = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_XML_VALUE }, produces = {
					org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
					org.springframework.http.MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmail(userDetails.getEmail());

		String userID = UUID.randomUUID().toString();
		returnValue.setUserId(userID);
		if (users == null)
			users = new HashMap<String, UserRest>();
			users.put(userID, returnValue);
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
