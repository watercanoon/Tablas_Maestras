package pe.fact.gestor.authtablasmaestras.Gestion_Personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity.Personal;

import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

    // LISTAR
    @Procedure(procedureName = "sp_fact_personal_listar")
    List<Personal> listarPersonal();

    // AGREGAR
    @Procedure(procedureName = "sp_fact_personal_agregar")
    void agregarPersonal(
            String p_TipoDocu,
            String p_numeDocu,
            String p_appaPers,
            String p_apmaPers,
            String p_nombPers,
            Integer p_codiHora,
            Integer p_codiRol,
            Integer p_estaPers
    );

    // MODIFICAR
    @Procedure(procedureName = "sp_fact_personal_actualizar")
    void modificarPersonal(
            Integer p_codiPers,
            String p_TipoDocu,
            String p_numeDocu,
            String p_appaPers,
            String p_apmaPers,
            String p_nombPers,
            Integer p_codiHora,
            Integer p_codiRol,
            Integer p_estaPers
    );
}
