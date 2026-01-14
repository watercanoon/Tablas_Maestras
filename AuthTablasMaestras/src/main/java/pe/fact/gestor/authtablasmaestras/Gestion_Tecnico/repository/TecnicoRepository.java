package pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.entity.Tecnico;

import java.util.List;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

    // LISTAR
    @Procedure(procedureName = "sp_fact_tecnico_listar")
    List<Tecnico> listarTecnico();

    // INSERTAR
    @Procedure(procedureName = "sp_fact_tecnico_insertar")
    void insertarTecnico(
            String p_nombTecn,
            String p_dniTecn
    );

    // ACTUALIZAR
    @Procedure(procedureName = "sp_fact_tecnico_actualizar")
    void actualizarTecnico(
            Integer p_codiTecn,
            String p_nombTecn,
            String p_dniTecn
    );
}
