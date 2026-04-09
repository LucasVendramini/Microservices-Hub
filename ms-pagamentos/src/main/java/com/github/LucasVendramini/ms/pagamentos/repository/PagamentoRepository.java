package com.github.LucasVendramini.ms.pagamentos.repository;

import com.github.LucasVendramini.ms.pagamentos.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
