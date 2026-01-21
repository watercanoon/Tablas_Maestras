package pe.fact.gestor.almacen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name = "view_almacen")
@Data // Genera getters y setters con Lombok
public class ViewAlmacen {

    @Id // Aunque sea una vista, JPA necesita un ID. Usamos el código del producto.
    @Column(name = "codiProd")
    private Integer codiProd;

    @Column(name = "nombProd")
    private String nombProd;

    @Column(name = "cantidad")
    private BigInteger cantidad;
}
