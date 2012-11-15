
package katvat.tt.dao;

import java.io.Serializable;
import katvat.tt.model.Client;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tuomas Katva
 */
@Transactional
public interface ClientDao extends JpaRepository<Client, Long> {
 
}
