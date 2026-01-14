package pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.service;

import pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.entity.Tecnico;

import java.util.List;

public interface TecnicoService {

    List<Tecnico> listar();

    void agregar(Tecnico tecnico);

    void modificar(Tecnico tecnico);

    boolean eliminar(int codiTecn);
}
