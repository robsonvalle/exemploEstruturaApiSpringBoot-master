package br.com.example.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.example.spring.model.Resumo;

@Repository
public interface IResumoRepository extends JpaRepository<Resumo, Long> {
	

	@Query(value =  "select max(id) as id, case extract(month from p.data) when 1 then 'Janeiro' when 2 then 'Fevereiro' when 3 then 'Março' when 4 then 'Abril' when 5 then 'Maio' when 6 then 'Junho' when 7 then 'Julho' when 8 then 'Agosto' when 9 then 'Setembro' when 10 then 'Outubro' when 11 then 'Novembro' when 12 then 'Dezembro' else 'nao existe' end as mes , sum (p.valor) as valor from Pedido p group by mes" , nativeQuery = true)
    List<Resumo> ListaResumomes();
	

}


