package shop.readmecorp.userserverreadme.modules.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.readmecorp.userserverreadme.modules.book.entity.Book;
import shop.readmecorp.userserverreadme.modules.book.enums.BookStatus;


public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b INNER JOIN Heart h ON b.id = h.book.id where b.status = :bookStatus GROUP BY h.book.id ORDER BY COUNT(h) DESC")
    Page<Book> findByBookHeartCount(Pageable pageable, BookStatus bookStatus);

    @Query("SELECT b FROM Book b INNER JOIN BookPayment bp ON b.id = bp.book.id where b.status = :bookStatus GROUP BY bp.book.id ORDER BY COUNT(bp) DESC")
    Page<Book> findByBookPaymentDESC(Pageable pageable, BookStatus bookStatus);

    Page<Book> findByStatusOrderByIdDesc(Pageable pageable, BookStatus bookStatus);
    Page<Book> findByStatus(Pageable pageable, BookStatus bookStatus);

    Page<Book> findByBigCategoryIdAndStatus(Integer bigCategoryId, Pageable pageable, BookStatus bookStatus);

    Page<Book> findByBigCategoryIdAndSmallCategoryIdAndStatus(Integer bigCategoryId, Integer smallCategoryId, Pageable pageable, BookStatus bookStatus);
}
