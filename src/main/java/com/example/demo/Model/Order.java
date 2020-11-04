package com.example.demo.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "orders", schema = "nextlevel", catalog = "")
public class Order {
    private int id;
    private String comments;
    private Date orderDate;
    private Collection<OrderHasGames> orderHasGamesById;
    private Customer customerByCustomerId;
    private Status statusesByStatusId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 1000)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "order_date", nullable = false)
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (comments != null ? !comments.equals(order.comments) : order.comments != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderHasGames> getOrderHasGamesById() {
        return orderHasGamesById;
    }

    public void setOrderHasGamesById(Collection<OrderHasGames> orderHasGamesById) {
        this.orderHasGamesById = orderHasGamesById;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public Status getStatusesByStatusId() {
        return statusesByStatusId;
    }

    public void setStatusesByStatusId(Status statusesByStatusId) {
        this.statusesByStatusId = statusesByStatusId;
    }
}
