package br.com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.spring.model.Parametro;

@Repository
public interface IParametroRepository extends JpaRepository<Parametro, String> {
	
	Parametro findByChaveIgnoreCaseContaining(String chave);

}
