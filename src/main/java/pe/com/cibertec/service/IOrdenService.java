package pe.com.cibertec.service;

import java.util.List;
import java.util.Optional;

import pe.com.cibertec.model.Orden;
import pe.com.cibertec.model.Usuario;

public interface IOrdenService {
	
	List<Orden> findAll();
	Orden save (Orden orden);
}