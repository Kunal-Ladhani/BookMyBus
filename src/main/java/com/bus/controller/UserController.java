package com.bus.controller;

import com.bus.exception.InvalidCredentialException;
import com.bus.exception.UserAlreadyExistsException;
import com.bus.dto.MessageDTO;
import com.bus.dto.SessionDTO;
import com.bus.model.User;
import com.bus.dto.UserDTO;
import com.bus.service.UserAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserAuthenticationService service;

	@PostMapping(value = "/signup")
	public ResponseEntity<MessageDTO> userSignUp(@Valid @RequestBody User user) throws UserAlreadyExistsException {

		User signedUpUser = service.userSignUp(user);

		MessageDTO message = new MessageDTO();

		if (signedUpUser != null) {
			message.setMessage("Registered Successfully");
			message.setTimestamp(LocalDateTime.now());
		}

		return new ResponseEntity<MessageDTO>(message, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<SessionDTO> userSignIn(@Valid @RequestBody UserDTO user) throws UserAlreadyExistsException, InvalidCredentialException {
		SessionDTO sdt = service.userLogin(user);
		return new ResponseEntity<SessionDTO>(sdt, HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<MessageDTO> userLogout(@RequestParam(value = "key") String authKey) throws InvalidCredentialException {
		MessageDTO message = new MessageDTO();

		String msg = service.userLogout(authKey);
		message.setMessage(msg);
		message.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MessageDTO>(message, HttpStatus.OK);
	}

	@PutMapping("/profile")
	public ResponseEntity<String> updateUser(@Valid @RequestBody User user) throws InvalidCredentialException {
		service.updateUser(user);
		return new ResponseEntity<String>("User updated successfully...", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<User> deleteUser(@RequestParam Integer userid, @RequestParam String authKey) throws InvalidCredentialException {
		User u = service.deleteUser(userid, authKey);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@PostMapping("/appoint")
	public ResponseEntity<User> appointNewAdmin(@RequestParam("email") String email, @RequestParam("code") String passcode) throws InvalidCredentialException {
		User user = service.makeUserAdmin(email, passcode);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
