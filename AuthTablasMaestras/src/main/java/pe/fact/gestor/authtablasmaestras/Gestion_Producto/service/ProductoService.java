package pe.fact.gestor.authtablasmaestras.Gestion_Producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.entity.Producto;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.repository.ProductoRepository;


@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public void crear(Producto producto) {
        // Validación de Negocio (Ejemplo de Ingeniero)
        if(producto.getNombProd() == null || producto.getNombProd().isEmpty()) {
            throw new RuntimeException("El nombre del producto es obligatorio");
        }

        // Llamada al repo
        repository.registrarProducto(producto.getNombProd());
    }
}