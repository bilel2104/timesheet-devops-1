package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.debug("user +++ : ", user);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("error methode retrieveAll: "+ e);		}

		return users;
	}


	@Override
	public User addUser(User u) {
		User userSaved = new User();
		try {
			l.info("In addUser() : ");
			userSaved = userRepository.save(u);
			l.debug("user added +++ : ", userSaved);
			
			l.info("Out of addUser() : ");

		}catch (Exception e) {
			l.error("Error in addUser() : ", e);
		}
		
		return userSaved;
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In updateUser() : ");
		User userSaved = userRepository.save(u);
		l.debug("user updated  +++ : ",userSaved);

		l.info("Out of updateUser() : ");
		return userSaved;
	}

	@Override
	public void deleteUser(String id) {

		l.info("In deleteUser() : ");
		userRepository.deleteById(Long.parseLong(id));
		l.debug("user deleted with id: ", id);
		l.info("Out of deleteUser() : ");
	}

	@Override
	public User retrieveUser(String id) {

		User u = null;

		try {
			l.info("In retrieveUser() : ");

			u =  userRepository.findById(Long.parseLong(id)).get(); 
			l.info("Out retrieveUser() : ");

		} catch (Exception e) {
		}
		return u; 
	}

}
