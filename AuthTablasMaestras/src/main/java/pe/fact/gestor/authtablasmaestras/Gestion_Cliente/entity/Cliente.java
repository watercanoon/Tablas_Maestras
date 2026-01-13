package pe.fact.gestor.authtablasmaestras.Gestion_Cliente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiClie")
    private Integer codiClie;

    @Column(name = "codiTipoDocu")
    private String codiTipoDocu;

    @Column(name = "numeDocu")
    private String numeDocu;

    @Column(name = "appaClie")
    private String appaClie;

    @Column(name = "apmaClie")
    private String apmaClie;

    @Column(name = "nombClie")
    private String nombClie;

    @Column(name = "raznSociClie")
    private String raznSociClie;

    @Column(name = "mailClie")
    private String mailClie;

    @Column(name = "direClie") // Campo agregado
    private String direClie;

    @Column(name = "sexoClie")
    private String sexoClie;

    @Column(name = "celuClie")
    private String celuClie;

    @Column(name = "passClie")
    private String passClie;

    // Campos de Auditoria (Solo para recepcion, no mapeados a tabla directamente en insert simple)
    @Transient
    private Integer usuarioRegistroId;
}