package seoan.backend.Repository;

import seoan.backend.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    public final static String SELECT_COMMENTS_BY_QNA = ""
            + "SELECT DISTINCT * "
            + "FROM comments  "
            + "WHERE qna_no = ?1 "
            +"ORDER BY comments.comments_date DESC  ";
    @Query(value = SELECT_COMMENTS_BY_QNA, nativeQuery = true)
    List<Comments> findCommentsByQnaNo(final Integer num);

}