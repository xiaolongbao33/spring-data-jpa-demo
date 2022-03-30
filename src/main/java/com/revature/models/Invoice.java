package com.revature.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Invoice {

    @Id
    private int id;
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && Objects.equals(date, invoice.date) && Objects.equals(customer, invoice.customer) && Objects.equals(products, invoice.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customer, products);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
