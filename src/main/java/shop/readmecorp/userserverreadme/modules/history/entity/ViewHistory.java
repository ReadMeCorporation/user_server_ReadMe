package shop.readmecorp.userserverreadme.modules.history.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import shop.readmecorp.userserverreadme.common.jpa.BaseTime;
import shop.readmecorp.userserverreadme.modules.book.entity.Book;
import shop.readmecorp.userserverreadme.modules.history.enums.HistoryStatus;
import shop.readmecorp.userserverreadme.modules.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VIEW_HISTORY_TB")
public class ViewHistory extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("고유번호")
    private Integer id;

    @Comment("유저")
    @ManyToOne
    private User user;

    @Comment("책")
    @ManyToOne
    private Book book;

    @Comment("마지막으로 본 페이지")
    private Integer lastPageNum;

    @Comment("최근 본 책 활성화 상태")
    @Enumerated(EnumType.STRING)
    private HistoryStatus status;

}

