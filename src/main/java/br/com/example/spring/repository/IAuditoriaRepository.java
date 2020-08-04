package br.com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.spring.model.Auditoria;

@Repository
public interface IAuditoriaRepository extends JpaRepository<Auditoria, Long> {
	
	Auditoria findByCodigoIgnoreCaseContaining(String codigo);
	/*
	@Modifying
	@Query("update Auditoria p set p.valor = ?1 where p.codigo = ?2")
	void atualizarValor(String valor, String codigo);*/
}
