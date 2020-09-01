package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user.getUserType()));
	}

	private List<SimpleGrantedAuthority> getAuthority(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	public void delete(Long id) {
		userDao.deleteById(id);
	}

	public User findOne(String username) {
		return userDao.findByEmail(username);
	}

	public User findById(Long id) {
		Optional<User> optionalUser = userDao.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    public UserDto update(UserDto userDto, Long id) {
        User user = findById(id);
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            userDao.save(user);
        }
        return userDto;
    }

    public ApiResponse save(UserDto user) {
		User founduser = userDao.findByEmail(user.getEmail());
		if(founduser == null) {
			User newUser = new User();
			newUser.setEmail(user.getEmail());
			newUser.setName(user.getName());
			newUser.setClientId(user.getClientId());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setUserType(user.getUserType());
			newUser.setActive(user.getActive());
			return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDao.save(newUser));//return ;
		}else{
			return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User Already exsist.",null);//return ;
		}

    }

    public ApiResponse deleteUser(Long id) {
		Optional<User> user= userDao.findById(id);
		if(user.isPresent())
		{
//			userDao.deleteById(id);
			user.get().setActive(false);
			userDao.save(user.get());
			return new ApiResponse(200,"Deleted Successfully",user);
		}
		else{
			return new ApiResponse(Status.Status_ERROR,"User Not Found",null);

		}


    }

	public ApiResponse getAll() {
		List<User> userList= userDao.getAllUsers();
		return new ApiResponse(200,"Fetch Successfully",userList);
	}

	public ApiResponse getUserById(Long id) {

		return new ApiResponse(200,"Fetch Successfully",userDao.findById(id));

	}

	public ApiResponse updateUser(Long id, UserDto userDTO) {
		User user =userDao.findById(id).get();

		User updatedUser = new User();
		updatedUser.setId(id);
		updatedUser.setName(userDTO.getName());
		updatedUser.setEmail(userDTO.getEmail());
		updatedUser.setActive(userDTO.getActive());
		if(userDTO.getPassword().equals(""))
		{
			updatedUser.setPassword(user.getPassword());
		}
		else{
			updatedUser.setPassword(userDTO.getPassword());
		}

		updatedUser.setUserType(user.getUserType());
		updatedUser.setClientId(user.getClientId());
		userDao.save(updatedUser);
		return new ApiResponse(200,"Updated Successfully",updatedUser);

	}
}
