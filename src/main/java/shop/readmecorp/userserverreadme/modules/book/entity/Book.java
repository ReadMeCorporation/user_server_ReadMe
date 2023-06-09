package shop.readmecorp.userserverreadme.modules.book.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import shop.readmecorp.userserverreadme.modules.common.jpa.BaseTime;
import shop.readmecorp.userserverreadme.modules.book.dto.BookDTO;
import shop.readmecorp.userserverreadme.modules.book.dto.BookToPaymentDTO;
import shop.readmecorp.userserverreadme.modules.book.dto.BookToReviewDTO;
import shop.readmecorp.userserverreadme.modules.book.enums.BookStatus;
import shop.readmecorp.userserverreadme.modules.book.response.BookResponse;
import shop.readmecorp.userserverreadme.modules.category.entity.SmallCategory;
import shop.readmecorp.userserverreadme.modules.file.entity.FileInfo;
import shop.readmecorp.userserverreadme.modules.publisher.entity.Publisher;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "BOOK_TB")
public class Book extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("고유번호")
    private Integer id;

    @Comment("출판사")
    @ManyToOne
    private Publisher publisher;

    @Comment("책 제목")
    private String title;

    @Comment("책 저자")
    private String author;

    @Comment("책 가격")
    private Integer price;

    @Comment("책 소개")
    private String introduction;

    @Comment("소분류 카테고리")
    @OneToOne
    private SmallCategory smallCategory;

    @Comment("저자 정보")
    private String authorInfo;

    @Comment("epub 파일 출처")
    @ManyToOne
    private FileInfo epub;

    @Comment("cover 파일 출처")
    @ManyToOne
    private FileInfo cover;

    @Comment("책 활성화 상태")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Builder
    public Book(Integer id, Publisher publisher, String title, String author, Integer price, String introduction, SmallCategory smallCategory, String authorInfo, FileInfo epub, FileInfo cover, BookStatus status) {
        this.id = id;
        this.publisher = publisher;
        this.title = title;
        this.author = author;
        this.price = price;
        this.introduction = introduction;
        this.smallCategory = smallCategory;
        this.authorInfo = authorInfo;
        this.epub = epub;
        this.cover = cover;
        this.status = status;
    }

    public BookDTO toDTO() {
        return BookDTO.builder()
                .id(id)
                .publisher(publisher.toDTO())
                .title(title)
                .author(author)
                .price(price)
                .introduction(introduction)
                .smallCategory(smallCategory.toDTO())
                .authorInfo(authorInfo)
                .build();
    }

    public BookToReviewDTO toBookToReviewDTO() {
        return new BookToReviewDTO(id, title, null, author);
    }

    public BookToPaymentDTO toBookToPaymentDTO() {
        return new BookToPaymentDTO(id, title, publisher.getBusinessName(), price, null);
    }

    public BookResponse toResponse() {
        return new BookResponse(id, publisher.toDTO(), title, author,price, introduction, null, smallCategory.toDTO(), authorInfo, epub.toDTO(), cover.toDTO());
    }

}
