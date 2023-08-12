package spring.boot.demobooksshop.repository.book;

import org.springframework.data.jpa.domain.Specification;
import spring.boot.demobooksshop.dto.book.BookSearchParameters;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookSearchParameters searchParameters);
}
