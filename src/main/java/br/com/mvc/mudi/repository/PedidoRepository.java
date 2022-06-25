package br.com.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.enums.StatusPedidoEnum;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedidoEnum status);
}
