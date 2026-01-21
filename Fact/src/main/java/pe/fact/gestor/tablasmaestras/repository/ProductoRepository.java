package pe.fact.gestor.tablasmaestras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.tablasmaestras.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}