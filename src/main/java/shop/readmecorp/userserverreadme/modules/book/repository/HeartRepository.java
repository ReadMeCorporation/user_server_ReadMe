package shop.readmecorp.userserverreadme.modules.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.readmecorp.userserverreadme.modules.book.entity.Book;
import shop.readmecorp.userserverreadme.modules.book.entity.Heart;
import shop.readmecorp.userserverreadme.modules.book.enums.HeartStatus;
import shop.readmecorp.userserverreadme.modules.user.entity.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Integer> {

    @Query("SELECT h FROM Heart h WHERE h.book.id = :bookId and h.user.id = :userId")
    Optional<Heart> heartCount(Integer bookId, Integer userId);

    List<Heart> findByUserAndStatusNot(User user, HeartStatus status);
    Optional<Heart> findByUserAndStatusNotAndBook(User user, HeartStatus status, Book book);

}
