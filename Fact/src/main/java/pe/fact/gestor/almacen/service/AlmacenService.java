package pe.fact.gestor.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.fact.gestor.reportes.entity.Kardex;
import pe.fact.gestor.reportes.repository.KardexRepository;

import java.time.LocalDateTime;

@Service
public class AlmacenService {

    @Autowired
    private KardexRepository kardexRepo;

    @Transactional
    public void registrarMovimiento(Integer codiProd, Integer codiTipo, Integer codiTrab,
                                    Integer cantProd, String obseMovi, Integer codiUsu) {

        // 1. Obtener el último saldo
        Integer ultimoSaldo = kardexRepo.findLastSaldo(codiProd);
        if (ultimoSaldo == null) ultimoSaldo = 0;

        // 2. Crear el objeto Kardex
        Kardex k = new Kardex();
        k.setCodiProd(codiProd);
        k.setCodiTipo(codiTipo);
        k.setCodiTrab(codiTrab);
        k.setCantProd(cantProd);

        // Lógica de saldo: Saldo Anterior + (Cantidad * Tipo[1 o -1])
        k.setCantSald(ultimoSaldo + (cantProd * codiTipo));

        k.setFechMovi(LocalDateTime.now());
        k.setObseMovi(obseMovi);
        k.setCodiUsuaAlta(codiUsu);
        k.setFechRegiAlta(LocalDateTime.now());
        k.setCodiUsuaModi(codiUsu);
        k.setFechRegiModi(LocalDateTime.now());

        // 3. Guardar
        kardexRepo.save(k);
    }
}
