package pe.fact.gestor.authtablasmaestras.Gestion_Tecnico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codiTecn;

    private String nombTecn;
    private String dniTecn;

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
