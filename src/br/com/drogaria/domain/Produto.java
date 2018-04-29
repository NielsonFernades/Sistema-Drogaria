package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "tbl_produtos")
//@SequenceGenerator(name = "produtos_seq", sequenceName = "produtos_seq", initialValue = 1, allocationSize = 1)
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

	@ManyToAny(fetch = FetchType.EAGER, metaColumn = @Column) //MODIFICAR ESSE TRECHO
	@JoinColumn(name = "tbl_fabricantes_fab_codigo", referencedColumnName = "fab_codigo", nullable = false)
	private Fabricante fabricante;

}
