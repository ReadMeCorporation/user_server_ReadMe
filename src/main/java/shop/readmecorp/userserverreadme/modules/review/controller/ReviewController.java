package shop.readmecorp.userserverreadme.modules.review.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.readmecorp.userserverreadme.common.dto.ResponseDTO;
import shop.readmecorp.userserverreadme.modules.review.enums.ReviewStatus;
import shop.readmecorp.userserverreadme.modules.review.request.ReviewSaveRequest;
import shop.readmecorp.userserverreadme.modules.review.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 전체 조회
    @GetMapping
    public ResponseEntity<?> getPage(Pageable pageable) {
        return ResponseEntity.ok(new ResponseDTO<>(1, "리뷰 전체 조회 성공", reviewService.getPage(pageable)));
    }

    // 리뷰 도서별 조회
    @GetMapping("/{bookId}/books")
    public ResponseEntity<?> getReviews(@PathVariable Integer bookId) {
        return ResponseEntity.ok(new ResponseDTO<>(1, "리뷰 도서별 조회 성공", reviewService.getReviews(bookId, ReviewStatus.ACTIVE)));
    }

    // 리뷰 유저별 조회
    @GetMapping("/{userId}/users")
    public ResponseEntity<?> getReviewsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(new ResponseDTO<>(1, "리뷰 유저별 조회 성공", reviewService.getReviewsByUserId(userId, ReviewStatus.ACTIVE)));
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody ReviewSaveRequest request){
        return new ResponseEntity<>(new ResponseDTO<>(1, "리뷰 등록 성공", reviewService.save(request)), HttpStatus.CREATED);
    }
}
