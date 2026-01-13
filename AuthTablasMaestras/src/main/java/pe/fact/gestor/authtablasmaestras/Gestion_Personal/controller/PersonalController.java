package pe.fact.gestor.authtablasmaestras.Gestion_Personal.controller;

import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity.Personal;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.service.PersonalService;

import java.util.List;

@RestController
@RequestMapping("/personal")
@CrossOrigin(origins = "*")
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    // GET → LISTAR
    @GetMapping("/listar")
    public List<Personal> listar() {
        return personalService.listar();
    }

    // POST → AGREGAR
    @PostMapping("/agregar")
    public void agregar(@RequestBody Personal personal) {
        personalService.agregar(personal);
    }

    // PUT → MODIFICAR
    @PutMapping("/modificar")
    public void modificar(@RequestBody Personal personal) {
        personalService.modificar(personal);
    }
}

