package spring.boot.demobooksshop.repository.book.spec;

import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import spring.boot.demobooksshop.model.Book;
import spring.boot.demobooksshop.repository.SpecificationProvider;

@Component
public class DescriptionSpecificationProvider implements SpecificationProvider<Book> {
    private static final String DESCRIPTION_KEY = "description";

    @Override
    public String getKey() {
        return DESCRIPTION_KEY;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) ->
                root.get(DESCRIPTION_KEY).in(Arrays.stream(params).toArray());
    }
}
