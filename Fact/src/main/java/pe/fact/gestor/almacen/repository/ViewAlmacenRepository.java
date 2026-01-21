package pe.fact.gestor.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.almacen.entity.ViewAlmacen;

@Repository
public interface ViewAlmacenRepository extends JpaRepository<ViewAlmacen, Integer> {
}
