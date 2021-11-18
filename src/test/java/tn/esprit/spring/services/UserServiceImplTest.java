package tn.esprit.spring.services;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	

		@Autowired
		IUserService us; 

		@Test
		@Order(1)
		public void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers(); 
			// if there are 7 users in DB : 
			Assertions.assertEquals(10,listUsers.size());
		
			
		}
		
		
		@Test
		@Order(2)
		public void testAddUser() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User("billll","sa1", d, Role.INGENIEUR); 
			User userAdded = us.addUser(u); 
			Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
		}
	 
		@Test
		@Order(3)
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(80L, "bilel","b", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u); 
			Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		
	
		@Test
		@Order(4)
		public void testRetrieveUser() {
			User userRetrieved = us.retrieveUser("86");
			Assertions.assertEquals(86L, userRetrieved.getId());
		}
		@Test 
		@Order(5)
		public void testdeleteUser() {
			
			us.deleteUser("86");
			Assertions.assertNull(us.retrieveUser("86"));
			
			
		}

		
		
		 
 
}