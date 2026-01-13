package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.service;


import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.entity.Concepto;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.repository.ConceptoRepository;

import java.util.List;

@Service
public class ConceptoServiceImpl implements ConceptoService {

    private final ConceptoRepository conceptoRepository;

    public ConceptoServiceImpl(ConceptoRepository conceptoRepository) {
        this.conceptoRepository = conceptoRepository;
    }

    @Override
    public List<Concepto> listar() {
        return conceptoRepository.listarConceptos();
    }

    @Override
    public void agregar(Concepto concepto) {
        conceptoRepository.agregarConcepto(
                concepto.getNombConc(),
                concepto.getMontConc(),
                concepto.getCodiPlan(),
                concepto.getCodiMes(),
                concepto.getEstdConc()
        );
    }

    @Override
    public void modificar(Concepto concepto) {
        conceptoRepository.modificarConcepto(
                concepto.getCodiConc(),
                concepto.getNombConc(),
                concepto.getMontConc(),
                concepto.getCodiPlan(),
                concepto.getCodiMes(),
                concepto.getEstdConc()
        );
    }
}
