package br.com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.example.spring.model.Produto;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findByNomeIgnoreCaseContaining(String nome);
	
	@Modifying
	@Query("update Produto p set p.valor = ?1 where p.nome = ?2")
	void atualizarValor(String valor, String nome);
}
