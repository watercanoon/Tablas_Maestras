package pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.controller;

import pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.entity.Tecnico;
import pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.service.TecnicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnico")
@CrossOrigin(origins = "*")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    // GET
    @GetMapping("/listar")
    public List<Tecnico> listar() {
        return tecnicoService.listar();
    }

    // POST
    @PostMapping("/agregar")
    public void agregar(@RequestBody Tecnico tecnico) {
        tecnicoService.agregar(tecnico);
    }

    // PUT
    @PutMapping("/modificar")
    public void modificar(@RequestBody Tecnico tecnico) {
        tecnicoService.modificar(tecnico);
    }
}
