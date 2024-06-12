package seoan.backend.Service;

import seoan.backend.Model.Comments;
import seoan.backend.Repository.CommentsRepository;
import seoan.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;


    public Optional<Comments> getComments(Integer num) {
        return commentsRepository.findById(num);
    }

    public Comments createComments(Comments comments) {
        return commentsRepository.save(comments);
    }

    public void deleteComments(Integer no) {
        Comments comments = commentsRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not exist Qna Data by no : [" + no + "]"));
        commentsRepository.delete(comments);
    }


    public List<Comments> findCommentsByQnaNo(Integer num){
        return commentsRepository.findCommentsByQnaNo(num);
    }


}