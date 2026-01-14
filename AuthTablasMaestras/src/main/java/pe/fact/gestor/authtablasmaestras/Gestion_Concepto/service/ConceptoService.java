package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.service;

import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.entity.Concepto;
import java.util.List;

public interface ConceptoService {

    List<Concepto> listar();

    void agregar(Concepto concepto);

    void modificar(Concepto concepto);
}
