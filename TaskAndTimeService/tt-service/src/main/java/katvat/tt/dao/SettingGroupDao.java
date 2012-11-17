
package katvat.tt.dao.service;

import java.io.Serializable;
import katvat.tt.model.SettingGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Tuomas Katva
 */
@Transactional
public interface SettingGroupDao extends JpaRepository<SettingGroup, Long> {

}
