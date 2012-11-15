package katvat.tt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import katvat.tt.model.*;
import java.util.List;

@Transactional
public interface VatDao extends JpaRepository<ValueAddedTax, Long> {

}
