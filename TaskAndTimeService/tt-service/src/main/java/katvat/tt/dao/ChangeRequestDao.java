package katvat.tt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import katvat.tt.model.*;


@Transactional
public interface ChangeRequestDao extends JpaRepository<ChangeRequest, Long> {

}
