package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QTaskType is a Querydsl query type for TaskType
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaskType extends EntityPathBase<TaskType> {

    private static final long serialVersionUID = 1498720815;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QTaskType taskType = new QTaskType("taskType");

    public final StringPath taskTypeAbbr = createString("taskTypeAbbr");

    public final StringPath taskTypeDesc = createString("taskTypeDesc");

    public final NumberPath<Double> taskTypeHourPriceExVat = createNumber("taskTypeHourPriceExVat", Double.class);

    public final NumberPath<Long> taskTypeId = createNumber("taskTypeId", Long.class);

    public final StringPath taskTypeName = createString("taskTypeName");

    public final QValueAddedTax taskTypeVat;

    public QTaskType(String variable) {
        this(TaskType.class, forVariable(variable), INITS);
    }

    public QTaskType(Path<? extends TaskType> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaskType(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaskType(PathMetadata<?> metadata, PathInits inits) {
        this(TaskType.class, metadata, inits);
    }

    public QTaskType(Class<? extends TaskType> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.taskTypeVat = inits.isInitialized("taskTypeVat") ? new QValueAddedTax(forProperty("taskTypeVat")) : null;
    }

}

