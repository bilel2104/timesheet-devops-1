package tn.esprit.spring.services.Departements;
import tn.esprit.spring.entities.Departement;

import java.util.List;

public interface IDepartementService {
	
	List<Departement> retrieveAllDepartements(); 
	Departement addDepartement(Departement d);
	void deleteDepartement(String id);
	Departement updateDepartement(Departement d);
	Departement retrieveDepartement(String id);

}






	


 