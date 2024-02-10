package com.narayan.mongodb.repository;

import com.narayan.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, Integer> {
}
