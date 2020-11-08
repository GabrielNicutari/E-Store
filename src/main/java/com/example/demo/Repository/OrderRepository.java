package com.example.demo.Repository;

import com.example.demo.Model.Game;
import com.example.demo.Model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o.* FROM orders o, customers c WHERE ((c.first_name LIKE CONCAT('%',:key,'%') OR c.last_name LIKE CONCAT('%',:key,'%')" +
            "OR c.phone_number LIKE CONCAT('%',:key,'%')) AND o.customer_id = c.id) OR o.status_id LIKE CONCAT('%',:key,'%')", nativeQuery = true)
    Page<Order> findAllByKeyword(@Param("key") String key, Pageable pageable);

}
