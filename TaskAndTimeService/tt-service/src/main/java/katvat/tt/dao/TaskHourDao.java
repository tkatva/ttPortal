package katvat.tt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import katvat.tt.model.*;
import java.util.List;

public interface TaskHourDao extends JpaRepository<TaskHour, Long> {

	List<TaskHour> findByUserId(String userId);
}