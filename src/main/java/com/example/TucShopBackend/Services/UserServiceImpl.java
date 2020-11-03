package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.TokenDTO;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.Token;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.TokenRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import org.apache.tomcat.jni.Local;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


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
			if(user.getAccountAccessKey().equalsIgnoreCase("trial")) {
					newUser.setAccountAccessKey(user.getAccountAccessKey());
					newUser.setAccountAccessDate(LocalDate.now());
					newUser.setAccountExpire(LocalDate.now().plusMonths(1));
			}
			else {

				if(user.getAccountAccessKey().equalsIgnoreCase("permanet")){
					newUser.setAccountAccessKey(user.getAccountAccessKey());
					newUser.setAccountAccessDate(LocalDate.now());
					newUser.setAccountExpire(LocalDate.now().plusYears(1));
					return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",	userDao.save(newUser));//return ;
				}

			}
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

	public ApiResponse updateUser(Long id, @NotNull UserDto userDTO) {
		User user =userDao.findById(id).get();


//		updatedUser.setId(id);
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setActive(userDTO.getActive());
		if(!userDTO.getPassword().equals(""))
		{
			user.setPassword(userDTO.getPassword());
		}


		user.setUserType(user.getUserType());
		user.setClientId(user.getClientId());
		userDao.save(user);
		return new ApiResponse(200,"Updated Successfully",user);

	}

	public ApiResponse getUserByLogin (String user){
		return new ApiResponse (Status.Status_Ok, "Successfully get User Date and time", userDao.getUserByLogin(user));
	}



}
