package pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.service;


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
    public List<Tecnico> listar() {
        return tecnicoRepository.listarTecnicos();
    }

    @Override
    public void agregar(Tecnico tecnico) {
        tecnicoRepository.agregarTecnico(
                tecnico.getNombTecn(),
                tecnico.getDniTecn()
        );
    }

    @Override
    public void modificar(Tecnico tecnico) {
        tecnicoRepository.actualizarTecnico(
                tecnico.getCodiTecn(),
                tecnico.getNombTecn(),
                tecnico.getDniTecn()
        );
    }
}