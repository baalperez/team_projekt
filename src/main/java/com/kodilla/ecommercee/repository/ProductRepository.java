package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    List<Product> findAll();



}
