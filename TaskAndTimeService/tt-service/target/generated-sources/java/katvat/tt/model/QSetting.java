package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QSetting is a Querydsl query type for Setting
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSetting extends EntityPathBase<Setting> {

    private static final long serialVersionUID = -169240448;

    public static final QSetting setting = new QSetting("setting");

    public final StringPath settingDescription = createString("settingDescription");

    public final NumberPath<Long> settingId = createNumber("settingId", Long.class);

    public final StringPath settingName = createString("settingName");

    public final StringPath settingValue = createString("settingValue");

    public QSetting(String variable) {
        super(Setting.class, forVariable(variable));
    }

    public QSetting(Path<? extends Setting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSetting(PathMetadata<?> metadata) {
        super(Setting.class, metadata);
    }

}

