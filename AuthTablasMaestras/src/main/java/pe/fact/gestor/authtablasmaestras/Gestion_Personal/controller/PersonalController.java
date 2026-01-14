package pe.fact.gestor.authtablasmaestras.Gestion_Personal.controller;

import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity.Personal;
import pe.fact.gestor.authtablasmaestras.Gestion_Personal.service.PersonalService;

import java.util.List;

@RestController
@RequestMapping("/personal")
@CrossOrigin("*")
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping("/listar")
    public List<Personal> listar() {
        return personalService.listar();
    }

    @PostMapping("/agregar")
    public void agregar(@RequestBody Personal personal) {
        personalService.agregar(personal);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody Personal personal) {
        personalService.modificar(personal);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestParam Integer codiPers) {
        personalService.eliminar(codiPers);
    }

}
