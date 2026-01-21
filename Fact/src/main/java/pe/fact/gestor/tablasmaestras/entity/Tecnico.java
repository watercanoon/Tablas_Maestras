package pe.fact.gestor.tablasmaestras.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codiTecn;

    private String nombTecn;
    private String dniTecn;

    public Tecnico() {
    }

    public Tecnico(String nombTecn, String dniTecn) {
        this.nombTecn = nombTecn;
        this.dniTecn = dniTecn;
    }

    public Tecnico(Integer codiTecn, String nombTecn, String dniTecn) {
        this.codiTecn = codiTecn;
        this.nombTecn = nombTecn;
        this.dniTecn = dniTecn;
    }

    // getters y setters
    public Integer getCodiTecn() {
        return codiTecn;
    }

    public void setCodiTecn(Integer codiTecn) {
        this.codiTecn = codiTecn;
    }

    public String getNombTecn() {
        return nombTecn;
    }

    public void setNombTecn(String nombTecn) {
        this.nombTecn = nombTecn;
    }

    public String getDniTecn() {
        return dniTecn;
    }

    public void setDniTecn(String dniTecn) {
        this.dniTecn = dniTecn;
    }
}
