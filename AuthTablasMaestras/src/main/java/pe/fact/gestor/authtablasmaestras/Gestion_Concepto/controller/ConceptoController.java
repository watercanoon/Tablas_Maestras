package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.controller;

import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.entity.Concepto;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.service.ConceptoService;

import java.util.List;

@RestController
@RequestMapping("/concepto")
@CrossOrigin(origins = "*")
public class ConceptoController {

    private final ConceptoService conceptoService;

    public ConceptoController(ConceptoService conceptoService) {
        this.conceptoService = conceptoService;
    }

    @GetMapping("/listar")
    public List<Concepto> listar() {
        return conceptoService.listar();
    }

    @PostMapping("/agregar")
    public void agregar(@RequestBody Concepto concepto) {
        conceptoService.agregar(concepto);
    }

    @PutMapping("/modificar")
    public void modificar(@RequestBody Concepto concepto) {
        conceptoService.modificar(concepto);
    }

    @DeleteMapping("/eliminar")
    public String eliminar(@RequestParam int codiConc) {
        conceptoService.eliminar(codiConc);
        return "Concepto eliminado correctamente.";
    }

}
