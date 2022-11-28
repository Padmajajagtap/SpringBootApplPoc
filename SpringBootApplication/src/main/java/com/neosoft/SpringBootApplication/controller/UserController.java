package com.neosoft.SpringBootApplication.controller;

import com.neosoft.SpringBootApplication.entity.UserMaster;
import com.neosoft.SpringBootApplication.model.UserRequest;
import com.neosoft.SpringBootApplication.model.UserResponse;
import com.neosoft.SpringBootApplication.service.IUserService;
import com.neosoft.SpringBootApplication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/save")
	public UserMaster Registration(@Valid  @RequestBody UserMaster userMaster){

		return userService.saveUserData(userMaster);
	}


	//3. method to Validate User details and generate the token.
	@PostMapping("/login")
	public ResponseEntity<UserResponse>  loginUser(@RequestBody UserRequest userRequest){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userRequest.getUsername(),
						userRequest.getPassword()
				));
		String token = jwtUtil.generateToken(userRequest.getUsername());
		return ResponseEntity.ok(
				new UserResponse(token, "Success! Generated "));
	}



	@GetMapping("/users")
	public List<UserMaster> getAllData(){
		return userService.findAllUserData();
	}


	@GetMapping("/get/{userMasterId}")
	public UserMaster fetchUserById(@PathVariable("userMasterId") int userMasterId){

		return userService.findUserById(userMasterId);
	}

	@GetMapping("/search")
	public ResponseEntity<List<UserMaster>> searchUserMasterData(@RequestParam("query") String query){
		return ResponseEntity.ok(userService.searchUserMaster(query));
	}


}
