package com.example.myshoppingmall.repository;

import com.example.myshoppingmall.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
