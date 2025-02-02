package pe.com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}
