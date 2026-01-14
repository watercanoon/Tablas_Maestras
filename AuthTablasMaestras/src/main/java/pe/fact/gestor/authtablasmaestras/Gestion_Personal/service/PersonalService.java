package pe.fact.gestor.authtablasmaestras.Gestion_Personal.service;

import pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity.Personal;
import java.util.List;

public interface PersonalService {

    List<Personal> listar();
    void agregar(Personal personal);
    void modificar(Personal personal);
    void eliminar(Integer codiPers);
}
