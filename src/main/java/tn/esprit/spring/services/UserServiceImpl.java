package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l =LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.debug("user +++ : " + user);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In method Add User");
		User uSaved = userRepository.save(u);
		l.info("Utilisateur Ajoute");
		return uSaved;
	}

	@Override 
	public User updateUser(User u) { 
		l.info("update en cours");
		User uSaved = userRepository.save(u);
		l.info("update done!!");
		return uSaved;
	}

	@Override
	public void deleteUser(String id) {
		l.info("Deleting User ...");
		userRepository.deleteById(Long.parseLong(id));
		l.info("User {} deleted succesfully!",id);
	}

	@Override
	public User retrieveUser(String id) {
		l.info("Recherche user en cours...");
		User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("user {} retrieved",u);
		return u;
	}

}
