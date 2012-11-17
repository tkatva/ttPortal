

package katvat.tt.dao.service;


import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import katvat.tt.dao.SettingGroupDao;
import katvat.tt.dao.SettingDao;
import katvat.tt.model.Setting;
import katvat.tt.model.SettingGroup;
import katvat.tt.model.QSetting;
import katvat.tt.model.QSettingGroup;
/**
 *
 * @author Tuomas Katva
 */
@Repository
@Transactional
public class SettingServiceImpl implements SettingService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private SettingGroupDao settingGroupDao;
    
    @Autowired
    private SettingDao settingDao;

    @Override
    public void saveSettingGroup(SettingGroup settingGroup) {
        settingGroupDao.save(settingGroup);
    }

    @Override
    public void saveSetting(Setting setting) {
        settingDao.save(setting);
    }

    @Override
    public void removeSetting(Setting setting) {
        settingDao.delete(setting);
    }

    @Override
    public void removeSettingGroup(SettingGroup settingGroup) {
        settingGroupDao.delete(settingGroup);
    }

    @Override
    public List<SettingGroup> getSettingGroups() {
        return settingGroupDao.findAll();
    }

    @Override
    public List<Setting> findSettingGroupSetting(SettingGroup settingGroup) {
        QSetting qSetting = QSetting.setting;
        QSettingGroup qSettingGroup = QSettingGroup.settingGroup;
        JPQLQuery query = new JPAQuery(em);
        return query.from(qSetting,qSettingGroup)
                .join(qSettingGroup.settings,qSetting)
                .where(qSettingGroup.settingGroupId.eq(settingGroup.getSettingGroupId()))
                .list(qSetting);
    }

    @Override
    public List<Setting> findSettingsWithName(String settingName) {
        QSetting qSetting = QSetting.setting;
        JPQLQuery query = new JPAQuery(em);
        return query.from(qSetting)
                .where(qSetting.settingName.like(settingName))
                .list(qSetting);
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the settingGroupDao
     */
    public SettingGroupDao getSettingGroupDao() {
        return settingGroupDao;
    }

    /**
     * @param settingGroupDao the settingGroupDao to set
     */
    public void setSettingGroupDao(SettingGroupDao settingGroupDao) {
        this.settingGroupDao = settingGroupDao;
    }

    /**
     * @return the settingDao
     */
    public SettingDao getSettingDao() {
        return settingDao;
    }

    /**
     * @param settingDao the settingDao to set
     */
    public void setSettingDao(SettingDao settingDao) {
        this.settingDao = settingDao;
    }
    
    
    

}
