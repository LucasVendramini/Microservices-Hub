package com.github.LucasVendramini.ms.pedidos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column define as características da coluna no Banco de Dados
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    //@Column(unique = true (pode fazer ou não), nullable = false, lengh = 11
    @Column(nullable = false, length = 11)
    private String cpf;
    //A data ao definir um pedido vai ser a que estiver no sistema naquele momento
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Status status;
    //Valor calculado
    private BigDecimal valorTotal;

    //Relacionamento
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDoPedido> itens = new ArrayList<>();

    public void calcularValorTotalPedido() {
        this.valorTotal = this.itens.stream().map(i -> i.getPrecoUnitario()
                .multiply(BigDecimal.valueOf(i.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
