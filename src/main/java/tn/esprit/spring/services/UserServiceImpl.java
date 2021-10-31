package tn.esprit.spring.services;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	// TODO Logger à ajouter  
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {	
	
			// TODO Log à ajouter en début de la méthode 
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs   
			} 
			// TODO Log à ajouter à la fin de la méthode 
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
	}
// git test
	@Override
	public User retrieveUser(String id) {
		User u = null;
		try{
			// TODO Log à ajouter en début de la méthode 
			//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
			 u =  userRepository.findById(Long.parseLong(id)).get(); 
			// TODO Log à ajouter à la fin de la méthode 
			
		}catch (Exception e){
			l.error("error" + e);
		}
		return u; 
	}
		
}
