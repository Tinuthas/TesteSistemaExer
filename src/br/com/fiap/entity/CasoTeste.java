package br.com.fiap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_CASO_TESTE")
@SequenceGenerator(name="casoTeste",sequenceName="SQ_TAB_CASO_TESTE", allocationSize=1)
public class CasoTeste {
	
	@Id
	@Column(name = "cod_caso_teste")
	@GeneratedValue(generator="casoTeste", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name= "nom_caso_teste")
	private String nome;
	
	@Column(name = "des_caso_teste")
	private String descricao;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cod_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy="caso")
	private List<ItemTeste> itens;
	
	public CasoTeste(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;;
	}

	public CasoTeste(int codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;;
	}

	public CasoTeste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	

}
