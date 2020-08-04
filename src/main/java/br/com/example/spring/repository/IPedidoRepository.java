package br.com.example.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.example.spring.model.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long> {
	
	Pedido findByNumpedido(String numpedido);
	
	@Query(value =  "select max(id) as id, '' nomecliente , '' numpedido , date(p.data) as data, p.tipovenda, sum (p.valor) as valor from Pedido p group by p.tipovenda , date(p.data) order by date(p.data)" , nativeQuery = true)
     List<Pedido> ListaResultado();
	
	@Query(value =  "select max(id) as id, '' nomecliente , '' numpedido , '' tipovenda , case extract(month from p.data) when 1 then '01/01/2020 00:00:00' when 2 then '01/02/2020 00:00:00' when 3 then '01/03/2020 00:00:00' when 4 then 'Abril' when 5 then 'Maio' when 6 then 'Junho' when 7 then 'Julho' when 8 then 'Agosto' when 9 then 'Setembro' when 10 then 'Outubro' when 11 then 'Novembro' when 12 then 'Dezembro' else 'nao existe' end as data, sum (p.valor) as valor from Pedido p group by data" , nativeQuery = true)
    List<Pedido> ListaResumomes();
	
	@Modifying
	@Query("update Pedido p set p.valor = ?1 where p.numpedido = ?2")
	void atualizarValor(Double valor, String numpedido);
}
