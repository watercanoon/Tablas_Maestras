package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.service;

import jakarta.transaction.Transactional;
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
    @Transactional
    public List<Concepto> listar() {
        return conceptoRepository.listarConcepto();
    }

    @Override
    @Transactional
    public void agregar(Concepto concepto) {
        conceptoRepository.insertarConcepto(
                concepto.getNombConc(),
                concepto.getMontConc(),
                concepto.getCodiPlan(),
                concepto.getCodiMes(),
                concepto.getEstdConc()
        );
    }

    @Override
    @Transactional
    public void modificar(Concepto concepto) {
        conceptoRepository.actualizarConcepto(
                concepto.getCodiConc(),
                concepto.getNombConc(),
                concepto.getMontConc(),
                concepto.getCodiPlan(),
                concepto.getCodiMes(),
                concepto.getEstdConc()
        );
    }
}
