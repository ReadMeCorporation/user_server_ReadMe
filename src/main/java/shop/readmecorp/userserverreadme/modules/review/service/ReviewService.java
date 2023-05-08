package shop.readmecorp.userserverreadme.modules.review.service;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.readmecorp.userserverreadme.modules.book.entity.Book;
import shop.readmecorp.userserverreadme.modules.book.repository.BookRepository;
import shop.readmecorp.userserverreadme.modules.review.dto.ReviewDTO;
import shop.readmecorp.userserverreadme.modules.review.entity.Review;
import shop.readmecorp.userserverreadme.modules.review.enums.ReviewStatus;
import shop.readmecorp.userserverreadme.modules.review.repository.ReviewRepository;
import shop.readmecorp.userserverreadme.modules.review.request.ReviewSaveRequest;
import shop.readmecorp.userserverreadme.modules.user.entity.User;
import shop.readmecorp.userserverreadme.modules.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<ReviewDTO> getReviews(Integer bookID, ReviewStatus status) {
        return reviewRepository.findByStatusAndBookId(status, bookID)
                .stream().map(Review::toDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsByUserId(Integer userId, ReviewStatus status) {
         return reviewRepository.findByStatusAndUserId(status, userId)
                 .stream()
                 .map(Review::toDTO)
                 .collect(Collectors.toList());
    }

    public PageImpl<?> getPage(Pageable pageable) {

        var page = reviewRepository.findAll(pageable);
        var content = page.getContent()
                .stream()
                .map(Review::toDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(content, pageable, page.getTotalElements());

    }

    @Transactional
    public Review save(ReviewSaveRequest request) {

        Optional<User> optionalUser = userRepository.findById(request.getUserId());
        Optional<Book> optionalBook = bookRepository.findById(request.getBookId());

        Review review = Review.builder()
                .user(optionalUser.get())
                .book(optionalBook.get())
                .stars(request.getStars())
                .content(request.getContent())
                .status(ReviewStatus.ACTIVE)
                .build();

        return reviewRepository.save(review);
    }


//    public PageImpl<?> getReviewsByBookId(Integer bookId, Pageable pageable) {
//
//        Optional<Book> optionalBook = bookRepository.findById(bookId);
//
//        if (optionalBook.isEmpty()){
//            throw new Exception400(BookConst.notFound);
//        }
//        Book book = optionalBook.get();
//
//        var page = reviewRepository.findByBookId(book.getId());
//    }
}
