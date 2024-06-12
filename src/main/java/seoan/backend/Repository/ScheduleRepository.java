package seoan.backend.Repository;

import seoan.backend.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    public final static String SELECT_SCHEDULE_BY_ID = ""
            + "SELECT * "
            + "FROM schedules  "
            + "WHERE userid = ?1 "
            +"ORDER BY startdate DESC  ";
    @Query(value = SELECT_SCHEDULE_BY_ID, nativeQuery = true)
    List<Schedule> getSchedulelist(final String no);
}
