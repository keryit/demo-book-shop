package spring.boot.demobooksshop.dto.book;

public record BookSearchParameters(String[] title, String[] author,
                                   String[] isbn, String[] price,
                                   String[] description, String[] coverImage) {
}
