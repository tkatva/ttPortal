
package katvat.tt.dao;
import java.io.Serializable;
import katvat.tt.model.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Tuomas Katva
 */
public interface SettingDao extends JpaRepository<Setting, Long> {

}
