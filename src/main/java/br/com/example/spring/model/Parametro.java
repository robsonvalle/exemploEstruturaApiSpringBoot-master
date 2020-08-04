package br.com.example.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "PROW_PARAMETROS", indexes = { @Index(name = "IDX_CHAVE", columnList = "CHAVE") })
public class Parametro extends EntidadeVersionada {

		@Id
		@SequenceGenerator(name = "GENERATOR_PARAMETRO", sequenceName = "PARAMETRO_SEQ")
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "GENERATOR_PARAMETRO")
		@Column(name = "ID", nullable = false, unique = true)
		private Long id;
			
		@Column(name = "CHAVE", unique = true)
		private String chave;
		
		@Column(name = "VALOR", nullable = false)
		private String valor;
		
		@Column(name = "TIPO", nullable = false)
		private String tipo;
		

}
