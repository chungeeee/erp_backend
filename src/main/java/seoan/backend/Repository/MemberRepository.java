package seoan.backend.Repository;

import seoan.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<User, Integer> {
}