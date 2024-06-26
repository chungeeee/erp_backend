package seoan.backend.Service;

import seoan.backend.Model.Board;
import seoan.backend.Repository.BoardRepository;
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
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<Map> getPagingBoard(Integer p_num,String keyword) {
        Map result = null;
if((keyword == null) || (keyword.equals("undefined"))){
    keyword="";
}
        PagingUtil pu = new PagingUtil(keyword, p_num, 10, 10); // ($1:표시할 현재 페이지, $2:한페이지에 표시할 글 수, $3:한 페이지에 표시할 페이지 버튼의 수 )
        List<Board> list = boardRepository.findFromTo(keyword,pu.getObjectStartNum(), pu.getObjectCountPerPage());

        pu.setObjectCountTotal(boardRepository.findAllCount(keyword));//findAllCount()=전체 글 수


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

    public void updateBoard(
            Integer no, Board updatedBoard) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));
        board.setTitle(updatedBoard.getTitle());
        board.setContent(updatedBoard.getContent());

        boardRepository.save(board);
        //return ResponseEntity.ok(endUpdatedBoard);
    }

    public void deleteBoard(Integer no) {
        Board board = boardRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));

        boardRepository.delete(board);
        // Map<String, Boolean> response = new HashMap<>();
        // response.put("Deleted Board Data by id : [" + no + "]", Boolean.TRUE);

    }
    public Optional<Board> getBoard(Integer num) {
        return boardRepository.findById(num);
    }


}


