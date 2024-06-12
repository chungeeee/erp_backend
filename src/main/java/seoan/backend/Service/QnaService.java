package seoan.backend.Service;

import seoan.backend.Model.Qna;
import seoan.backend.Repository.QnaRepository;
import seoan.backend.exception.ResourceNotFoundException;
import seoan.backend.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QnaService {
    @Autowired
    private QnaRepository qnaRepository;

    public Qna createQna(Qna qna) {
        return qnaRepository.save(qna);
    }

    public ResponseEntity<Map> getPagingQna(Integer p_num,String keyword) {
        Map result = null;
if((keyword == null) || (keyword.equals("undefined"))){
    keyword="";
}
        PagingUtil pu = new PagingUtil(keyword, p_num, 10, 10); // ($1:표시할 현재 페이지, $2:한페이지에 표시할 글 수, $3:한 페이지에 표시할 페이지 버튼의 수 )
        List<Qna> list = qnaRepository.findFromTo(keyword,pu.getObjectStartNum(), pu.getObjectCountPerPage());

        pu.setObjectCountTotal(qnaRepository.findAllCount(keyword));//findAllCount()=전체 글 수


        pu.setCalcForPaging();

        if (list == null || list.size() == 0) {
            return null;
        }

        result = new HashMap<>();
        result.put("keyword", keyword);
        result.put("pagingData", pu);
        result.put("list", list);
        return ResponseEntity.ok(result);
    }

    public void updateQna(
            Integer no, Qna updatedQna) {
        Qna qna = qnaRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Qna Data by no : [" + no + "]"));
        qna.setTitle(updatedQna.getTitle());
        qna.setContent(updatedQna.getContent());

        qnaRepository.save(qna);
        //return ResponseEntity.ok(endUpdatedBoard);
    }

    public void deleteQna(Integer no) {
        Qna qna = qnaRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not exist Qna Data by no : [" + no + "]"));

        qnaRepository.delete(qna);
        // Map<String, Boolean> response = new HashMap<>();
        // response.put("Deleted Board Data by id : [" + no + "]", Boolean.TRUE);

    }
    public Optional<Qna> getQna(Integer num) {
        return qnaRepository.findById(num);
    }


}


