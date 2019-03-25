package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_SISTEMA")
@SequenceGenerator(name="sistema", sequenceName="SQ_TAB_SISTEMA",allocationSize=1)
public class Sistema {
	
	@Id
	@Column(name="cod_sistema")
	@GeneratedValue(generator="sistema",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nom_usuario")
	private String nome;
	
	@OneToMany(mappedBy="sistema")
	private CasoTeste casoTeste;

	public Sistema(String nome) {
		super();
		this.nome = nome;
	}

	public Sistema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sistema(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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
	
	

}
