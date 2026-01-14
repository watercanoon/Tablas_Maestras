package pe.fact.gestor.authtablasmaestras.Gestion_Personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity.Personal;

import java.util.List;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {

    @Procedure(procedureName = "sp_fact_personal_listar")
    List<Personal> listarPersonal();

    @Procedure(procedureName = "sp_fact_personal_insertar")
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

    @Procedure(procedureName = "sp_fact_personal_eliminar")
    void eliminarPersonal(Integer p_codiPers);

}
