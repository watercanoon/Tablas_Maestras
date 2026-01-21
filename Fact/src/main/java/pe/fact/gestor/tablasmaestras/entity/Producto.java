package pe.fact.gestor.tablasmaestras.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    public Producto() {
    }

    public Producto(Integer codiProd) {
        this.codiProd = codiProd;
    }

    public Producto(Integer codiProd, String nombProd) {
        this.codiProd = codiProd;
        this.nombProd = nombProd;
    }

    // --- CAMPOS ELIMINADOS PARA COINCIDIR CON LA BD ---
    // Como la tabla no tiene precio, stock ni estado, los quitamos de aquí.
    // Si en el futuro los agregas a la BD, descomenta esto.

    /*
    @Column(name = "precProd")
    private BigDecimal precProd;

    @Column(name = "stocProd")
    private Integer stocProd;

    @Column(name = "estdProd")
    private String estdProd;
    */
}