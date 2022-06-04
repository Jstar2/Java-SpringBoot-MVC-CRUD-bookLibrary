package com.bookLibrary.Library.Reposatory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookLibrary.Library.Model.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

}