package pe.fact.gestor.authtablasmaestras.Gestion_Plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.fact.gestor.authtablasmaestras.Gestion_Plan.entity.Plan;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query(value = "CALL sp_fact_plan_listar()", nativeQuery = true)
    List<Plan> listarPlanes();

    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_plan_insertar(:nombre, :monto, :tipo, :usuario)", nativeQuery = true)
    void registrarPlan(
            @Param("nombre") String nombre,
            @Param("monto") BigDecimal monto,
            @Param("tipo") Integer tipo,
            @Param("usuario") Integer usuarioId
    );

    // --- NUEVO: MODIFICAR ---
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_plan_modificar(:id, :nombre, :monto, :tipo, :usuario)", nativeQuery = true)
    void actualizarPlan(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("monto") BigDecimal monto,
            @Param("tipo") Integer tipo,
            @Param("usuario") Integer usuarioId
    );

    // --- NUEVO: ELIMINAR/ANULAR ---
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_plan_eliminar(:id)", nativeQuery = true)
    void eliminarPlan(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_plan_activar(:id)", nativeQuery = true)
    void activarPlan(@Param("id") Integer id);
}