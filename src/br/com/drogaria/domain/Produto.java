package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private Long codigo;

	@Column(name = "pro_descricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;

	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER) //MODIFICAR ESSE TRECHO
	@JoinColumn(name = "tbl_fabricantes_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
	private Fabricante fabricante;

}
