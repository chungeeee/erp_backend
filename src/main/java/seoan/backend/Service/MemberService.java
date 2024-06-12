package seoan.backend.Service;

import seoan.backend.Model.User;
import seoan.backend.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public User createUser(User user) {
        return memberRepository.save(user);
    }
}