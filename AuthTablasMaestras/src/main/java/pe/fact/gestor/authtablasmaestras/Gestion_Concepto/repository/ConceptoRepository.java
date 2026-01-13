package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.entity.Concepto;

import java.util.List;

@Repository
public interface ConceptoRepository extends JpaRepository<Concepto, Integer> {

    // LISTAR
    @Procedure(procedureName = "sp_fact_concepto_listar")
    List<Concepto> listarConceptos();

    // AGREGAR
    @Procedure(procedureName = "sp_fact_concepto_agregar")
    void agregarConcepto(
            String p_nombConc,
            Double p_montConc,
            Integer p_codiPlan,
            Integer p_codiMes,
            String p_estdConc
    );

    // MODIFICAR
    @Procedure(procedureName = "sp_fact_concepto_actualizar")
    void modificarConcepto(
            Integer p_codiConc,
            String p_nombConc,
            Double p_montConc,
            Integer p_codiPlan,
            Integer p_codiMes,
            String p_estdConc
    );
}

