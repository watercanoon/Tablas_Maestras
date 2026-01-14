package pe.fact.gestor.authtablasmaestras.Gestion_Producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.entity.Producto;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.service.ProductoService;
import java.util.List;

@RestController
@RequestMapping("/api/productos") // OJO: Verifica si usas /producto o /api/productos
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Producto producto) {
        try {
            service.crear(producto);
            return ResponseEntity.ok("Producto registrado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody Producto producto) {
        try {
            service.actualizar(producto);
            return ResponseEntity.ok("Producto actualizado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam("id") Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok("Producto eliminado");
    }
}