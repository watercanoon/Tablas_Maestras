package pe.fact.gestor.authtablasmaestras.Gestion_Personal.service;


import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity.Personal;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.repository.PersonalRepository;

import java.util.List;

@Service
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;

    public PersonalServiceImpl(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public List<Personal> listar() {
        return personalRepository.listarPersonal();
    }

    @Override
    public void agregar(Personal personal) {
        personalRepository.agregarPersonal(
                personal.getTipoDocu(),
                personal.getNumeDocu(),
                personal.getAppaPers(),
                personal.getApmaPers(),
                personal.getNombPers(),
                personal.getCodiHora(),
                personal.getCodiRol(),
                personal.getEstaPers()
        );
    }

    @Override
    public void modificar(Personal personal) {
        personalRepository.modificarPersonal(
                personal.getCodiPers(),
                personal.getTipoDocu(),
                personal.getNumeDocu(),
                personal.getAppaPers(),
                personal.getApmaPers(),
                personal.getNombPers(),
                personal.getCodiHora(),
                personal.getCodiRol(),
                personal.getEstaPers()
        );
    }
}

