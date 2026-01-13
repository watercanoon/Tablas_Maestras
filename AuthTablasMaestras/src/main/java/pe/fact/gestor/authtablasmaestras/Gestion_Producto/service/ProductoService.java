package pe.fact.gestor.authtablasmaestras.Gestion_Producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.entity.Producto;
import pe.fact.gestor.authtablasmaestras.Gestion_Producto.repository.ProductoRepository;
import java.util.List;
import java.math.BigDecimal;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listar() {
        return repository.listarProductos();
    }

    public void crear(Producto p) {
        // Validaciones
        if(p.getNombProd() == null || p.getNombProd().isEmpty()) {
            throw new RuntimeException("El nombre es obligatorio");
        }
        if(p.getPrecProd() == null) p.setPrecProd(BigDecimal.ZERO);
        if(p.getStocProd() == null) p.setStocProd(0);

        repository.registrarProducto(p.getNombProd(), p.getPrecProd(), p.getStocProd());
    }

    public void actualizar(Producto p) {
        if(p.getCodiProd() == null) throw new RuntimeException("ID requerido");
        repository.actualizarProducto(p.getCodiProd(), p.getNombProd(), p.getPrecProd(), p.getStocProd());
    }

    public void eliminar(Integer id) {
        repository.eliminarProducto(id);
    }
}