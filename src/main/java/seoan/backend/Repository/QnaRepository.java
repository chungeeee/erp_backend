package seoan.backend.Repository;

import seoan.backend.Model.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QnaRepository extends JpaRepository<Qna, Integer > {


    public final static String SELECT_QNA_LIST_PAGED = ""
            + "SELECT *"
            + "FROM qna "
            + "WHERE (title LIKE %?1%)"
            + "ORDER BY qna.qna_date DESC LIMIT ?2, ?3 ";
    @Query(value = SELECT_QNA_LIST_PAGED, nativeQuery = true)
    List<Qna> findFromTo(final String keyword,
            final Integer objectStartNum,
            final Integer objectEndNum);

    public final static String SELECT_QNA_COUNT = ""
            + "SELECT COUNT(*)"
            + "FROM qna "
            + "WHERE (title LIKE %?1% )";
    @Query(value = SELECT_QNA_COUNT, nativeQuery = true)
    Integer findAllCount(final String keyword);


}
