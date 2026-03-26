package com.github.LucasVendramini.ms.pedidos.repositories;

import com.github.LucasVendramini.ms.pedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
