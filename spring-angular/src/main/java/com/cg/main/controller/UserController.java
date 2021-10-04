package com.cg.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.User;
import com.cg.main.dao.IUserRepository;
import com.cg.main.service.CartServiceImpl;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	public IUserRepository iur;

	public User presentUser;
	
	@Autowired
	public CartServiceImpl csi;
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return iur.findAll();
	}
	
	@PostMapping("/add")
	public User addCustomer(@Valid @RequestBody User user) {
		System.out.println(user);
		presentUser = iur.save(user);
		csi.createCart(user);
		return presentUser;
	}
	
	/*
	 * @PutMapping("/updatePassword/{contactNo}/{newPassword}")
	public ResponseEntity<User> updateUser(@PathVariable("contactNo") String contactNo, @PathVariable(value="newPassword") String newPassword)throws UserNotFoundException{
		return new ResponseEntity<User>(service.updateUser(contactNo, newPassword), HttpStatus.OK);
	}
   
	@DeleteMapping("/removeUser/{contactNo}")
	public ResponseEntity<User> deleteUser(@PathVariable String contactNo) throws UserNotFoundException{
		User users=service.removeUser(contactNo);
		return new ResponseEntity<User>(users,HttpStatus.OK);
   }
	
	@GetMapping("/showUser/{contactNo}")
	public User getUserById(@PathVariable("contactNo")String contactNo) throws UserNotFoundException{
		User user=service.getUserById(contactNo);
		return user;
	}
	
	@GetMapping("/signin/{contactNo}/{password}")
	public ResponseEntity<User> loginUser(@PathVariable(value="contactNo") String contactNo,@PathVariable(value="password") String password )throws UserNotFoundException{
		User temp = service.signin(contactNo,password);
		return new ResponseEntity<User>(temp,HttpStatus.OK);
	}
	
	//@GetMapping("/showAll")
	//public User getalluser(){
		//User user=service.getalluser();
		//return user;
	//}
	
	@GetMapping("/signout/{contactNo}")
	public ResponseEntity<User> signoutUser(@PathVariable(value="contactNo") String contactNo){
		User temp = service.signout(contactNo);
		return new ResponseEntity<User>(temp,HttpStatus.OK);
	}
	
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	    
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage()));   
	        return errors;
	    }
	 * */
}
