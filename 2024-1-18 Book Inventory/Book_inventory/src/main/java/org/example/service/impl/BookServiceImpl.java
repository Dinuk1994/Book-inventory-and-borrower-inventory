package org.example.service.impl;


import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addBook(Book book) {
        BookEntity entity = mapper.map(book, BookEntity.class);
        bookRepository.save(entity);
    }

    @Override
    public List<BookEntity> getBooks() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
       if (bookRepository.existsById(id)){
           bookRepository.deleteById(id);
           return true;
       }
       return false;

    }

    @Override
    public Book searchBook(Long id) {
        Optional<BookEntity> byId =bookRepository.findById(id);
        return mapper.map(byId,Book.class);

    }


}
