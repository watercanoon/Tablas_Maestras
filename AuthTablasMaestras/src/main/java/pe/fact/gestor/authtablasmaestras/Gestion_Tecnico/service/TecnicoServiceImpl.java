package pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.entity.Tecnico;
import pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.repository.TecnicoRepository;

import java.util.List;

@Service
public class TecnicoServiceImpl implements TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoServiceImpl(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    @Override
    @Transactional
    public List<Tecnico> listar() {
        return tecnicoRepository.listarTecnico();
    }

    @Override
    @Transactional
    public void agregar(Tecnico tecnico) {
        tecnicoRepository.insertarTecnico(
                tecnico.getNombTecn(),
                tecnico.getDniTecn()
        );
    }

    @Override
    @Transactional
    public void modificar(Tecnico tecnico) {
        tecnicoRepository.actualizarTecnico(
                tecnico.getCodiTecn(),
                tecnico.getNombTecn(),
                tecnico.getDniTecn()
        );
    }
}
