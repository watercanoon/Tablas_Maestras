package pe.fact.gestor.authtablasmaestras.Gestion_Producto.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal; // Importante para el precio

@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiProd")
    private Integer codiProd;

    @Column(name = "nombProd")
    private String nombProd;

    // --- NUEVOS CAMPOS ---
    @Column(name = "precProd")
    private BigDecimal precProd;

    @Column(name = "stocProd")
    private Integer stocProd;

    @Column(name = "estdProd")
    private String estdProd; // Para el borrado lógico 'A' o 'I'
}