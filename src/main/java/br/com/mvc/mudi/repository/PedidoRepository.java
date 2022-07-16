package br.com.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.enums.StatusPedidoEnum;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedidoEnum status);

	@Query("Select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findByUserUsername(@Param("username") String username);
}
