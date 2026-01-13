package pe.fact.gestor.authtablasmaestras.Gestion_Producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.entity.Producto;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Producto producto) {
        try {
            service.crear(producto);
            return ResponseEntity.ok("Producto registrado exitosamente en MySQL");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}