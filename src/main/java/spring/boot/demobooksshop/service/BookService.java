package spring.boot.demobooksshop.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import spring.boot.demobooksshop.dto.book.BookDto;
import spring.boot.demobooksshop.dto.book.BookSearchParameters;
import spring.boot.demobooksshop.dto.book.CreateBookRequestDto;
import spring.boot.demobooksshop.model.Book;

public interface BookService {
    BookDto save(CreateBookRequestDto bookRequestDto);

    List<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    void deleteById(Long id);

    BookDto update(Book book);

    List<BookDto> search(BookSearchParameters searchParameters);
}
