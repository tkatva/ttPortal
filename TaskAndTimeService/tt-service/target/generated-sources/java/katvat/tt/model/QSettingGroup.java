package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QSettingGroup is a Querydsl query type for SettingGroup
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSettingGroup extends EntityPathBase<SettingGroup> {

    private static final long serialVersionUID = -1830830625;

    public static final QSettingGroup settingGroup = new QSettingGroup("settingGroup");

    public final StringPath settingGroupDescription = createString("settingGroupDescription");

    public final NumberPath<Long> settingGroupId = createNumber("settingGroupId", Long.class);

    public final StringPath settingGroupName = createString("settingGroupName");

    public final ListPath<Setting, QSetting> settings = this.<Setting, QSetting>createList("settings", Setting.class, QSetting.class);

    public QSettingGroup(String variable) {
        super(SettingGroup.class, forVariable(variable));
    }

    public QSettingGroup(Path<? extends SettingGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSettingGroup(PathMetadata<?> metadata) {
        super(SettingGroup.class, metadata);
    }

}

