package com.github.LucasVendramini.ms.pagamentos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valor;
    //Nome do cartão
    @Column(nullable = false)
    private String nome;
    //Número do cartão(XXXX XXXX XXXX XXXX)
    @Column(nullable = false, length = 16)
    private String numCartao;
    //Validade do cartão (MM/AA)
    @Column(nullable = false, length = 5)
    private String validade;
    //Código de segurança do cartão (xxx)
    @Column(nullable = false, length = 3)
    private String codigoSeguranca;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private Long pedidoId;
}
