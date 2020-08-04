package br.com.example.spring.model;

import javax.persistence.Version;

public class EntidadeVersionada extends Entidade {

	    private Long versao;

	    @Version
	    public Long getVersao() {
	        return versao;
	    }

	    public void setVersao(Long versao) {
	        this.versao = versao;
	    }

}
