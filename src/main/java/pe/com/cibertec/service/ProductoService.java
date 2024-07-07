package pe.com.cibertec.service;

import java.util.List;
import java.util.Optional;

import pe.com.cibertec.model.Producto;

public interface ProductoService {
	
	public Producto save( Producto producto);
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	
	//mostrar todos los productos
	public List<Producto> findAll();

}
