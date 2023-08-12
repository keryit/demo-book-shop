package spring.boot.demobooksshop.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.boot.demobooksshop.dto.book.BookDto;
import spring.boot.demobooksshop.dto.book.BookSearchParameters;
import spring.boot.demobooksshop.dto.book.CreateBookRequestDto;
import spring.boot.demobooksshop.exception.EntityNotFoundException;
import spring.boot.demobooksshop.mapper.BookMapper;
import spring.boot.demobooksshop.model.Book;
import spring.boot.demobooksshop.repository.book.BookRepository;
import spring.boot.demobooksshop.repository.book.SpecificationBuilder;
import spring.boot.demobooksshop.service.BookService;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final SpecificationBuilder<Book> specificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto bookRequestDto) {
        Book book = bookMapper.toModel(bookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Could not find book with id " + id)));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto update(Book book) {
        Book bookFromDb = bookRepository.findById(book.getId()).orElseThrow(() ->
                new EntityNotFoundException("Can't find book with id " + book.getId()));
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        bookFromDb.setIsbn(bookFromDb.getIsbn());
        bookFromDb.setPrice(book.getPrice());
        bookFromDb.setDescription(book.getDescription());
        bookFromDb.setCoverImage(book.getCoverImage());
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> search(BookSearchParameters searchParameters) {
        Specification<Book> bookSpecification = specificationBuilder.build(searchParameters);
        return bookRepository.findAll(bookSpecification)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
