package spring.boot.demobooksshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring.boot.demobooksshop.config.MapperConfig;
import spring.boot.demobooksshop.dto.book.BookDto;
import spring.boot.demobooksshop.dto.book.CreateBookRequestDto;
import spring.boot.demobooksshop.model.Book;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto requestDto);
}
