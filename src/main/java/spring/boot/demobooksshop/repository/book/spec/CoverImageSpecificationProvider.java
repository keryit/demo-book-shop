package spring.boot.demobooksshop.repository.book.spec;

import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import spring.boot.demobooksshop.model.Book;
import spring.boot.demobooksshop.repository.SpecificationProvider;

@Component
public class CoverImageSpecificationProvider implements SpecificationProvider<Book> {
    private static final String COVER_IMAGE_KEY = "coverImage";

    @Override
    public String getKey() {
        return COVER_IMAGE_KEY;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(COVER_IMAGE_KEY).in(Arrays.stream(params).toArray());
    }
}
