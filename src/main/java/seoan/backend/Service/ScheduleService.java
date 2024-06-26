package seoan.backend.Service;

import seoan.backend.Model.Schedule;
import seoan.backend.Repository.ScheduleRepository;
import seoan.backend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);

    }
    public List<Schedule> getSchedule(String no) {
        return scheduleRepository.getSchedulelist(no);

    }
    public Optional<Schedule> getScheduleNum(Integer no) {
        return scheduleRepository.findById(no);

    }
    public void deleteSchedule(Integer no) {
         scheduleRepository.deleteById(no);

    }

    public void updateSchedule(Integer no,Schedule schedule) {
        Schedule sch = scheduleRepository.findById(no)
                .orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : [" + no + "]"));
        sch.setTitle(schedule.getTitle());
        sch.setStartdate(schedule.getStartdate());
        sch.setEnddate(schedule.getEnddate());
        scheduleRepository.save(sch);

    }
}
