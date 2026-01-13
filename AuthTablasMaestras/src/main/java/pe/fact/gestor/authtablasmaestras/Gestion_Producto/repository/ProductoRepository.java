package pe.fact.gestor.authtablasmaestras.Gestion_Producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.entity.Producto;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // LISTAR
    @Query(value = "CALL sp_fact_producto_listar()", nativeQuery = true)
    List<Producto> listarProductos();

    // INSERTAR (Actualizado con precio y stock)
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_producto_insertar(:nom, :prec, :stoc)", nativeQuery = true)
    void registrarProducto(
            @Param("nom") String nombre,
            @Param("prec") BigDecimal precio,
            @Param("stoc") Integer stock
    );

    // MODIFICAR
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_producto_modificar(:id, :nom, :prec, :stoc)", nativeQuery = true)
    void actualizarProducto(
            @Param("id") Integer id,
            @Param("nom") String nombre,
            @Param("prec") BigDecimal precio,
            @Param("stoc") Integer stock
    );

    // ELIMINAR
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_producto_eliminar(:id)", nativeQuery = true)
    void eliminarProducto(@Param("id") Integer id);
}