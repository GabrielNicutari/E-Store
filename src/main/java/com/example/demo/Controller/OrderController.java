package com.example.demo.Controller;

import com.example.demo.Model.Game;
import com.example.demo.Model.GameHasFields;
import com.example.demo.Model.Order;

import com.example.demo.Model.OrderHasGames;
import com.example.demo.Repository.OrderHasGamesRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {
        "http://localhost:8081",
        "http://localhost:3000",
        "https://next-level-web-client.herokuapp.com",
        "http://nextlevelclient-env.eba-3tw249tp.us-east-1.elasticbeanstalk.com:8081"
})
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderHasGamesRepository orderHasGamesRepository;

    private Sort.Direction getSortDirection(String direction) {
        if(direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if(direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.DESC;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Map<String,Object>> getPageOfOrders(
            @RequestParam(required = false) String key,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {

        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            //sort=[field,direction]
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }

        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

        Page<Order> pageTuts;

        if(key == null) {
            pageTuts = orderRepository.findAll(pagingSort);
        } else {
            pageTuts = orderRepository.findAllByKeyword(key, pagingSort);
        }

        List<Order> myOrders = pageTuts.getContent();

        if (myOrders.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Map<String, Object> response = new HashMap<>();
        response.put("orders", myOrders);
        response.put("size", size);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
            Order _order = orderRepository.save(order);

            Collection<OrderHasGames> orderHasGamesCollection = _order.getOrderHasGamesById();
            for(OrderHasGames orderHasGames : orderHasGamesCollection) {

                orderHasGames.setOrdersByOrderId(new Order(order.getId()));
                orderHasGames.setOrderId(order.getId());

                orderHasGamesRepository.save(orderHasGames);
            }

            return new ResponseEntity<>(_order, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") int id, @RequestBody Order order) {
        Order _order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found order with id" + id));

            _order.setCustomerByCustomerId(order.getCustomerByCustomerId());
            _order.setOrderDate(order.getOrderDate());
            _order.setComments(order.getComments());
            _order.setStatusesByStatusId(order.getStatusesByStatusId());

            return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id) {
        orderRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
