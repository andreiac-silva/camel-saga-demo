package com.saga.payment.model.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saga.payment.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	@Modifying
	@Query("update Order o set o.status = 'CANCELLED' where o.code = :orderCode")
	void cancelOrder(@Param("orderCode") String orderCode);
}
