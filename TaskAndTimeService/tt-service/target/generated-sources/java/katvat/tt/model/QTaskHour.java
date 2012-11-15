package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QTaskHour is a Querydsl query type for TaskHour
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTaskHour extends EntityPathBase<TaskHour> {

    private static final long serialVersionUID = 1498353881;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QTaskHour taskHour = new QTaskHour("taskHour");

    public final DateTimePath<java.util.Date> dateSynced = createDateTime("dateSynced", java.util.Date.class);

    public final StringPath hourAccepter = createString("hourAccepter");

    public final StringPath hourComments = createString("hourComments");

    public final BooleanPath hoursAccepted = createBoolean("hoursAccepted");

    public final BooleanPath hoursInvoiced = createBoolean("hoursInvoiced");

    public final StringPath invoiceNumber = createString("invoiceNumber");

    public final NumberPath<Long> taskHourId = createNumber("taskHourId", Long.class);

    public final NumberPath<Double> taskHours = createNumber("taskHours", Double.class);

    public final QTask taskHoursTask;

    public final StringPath userId = createString("userId");

    public QTaskHour(String variable) {
        this(TaskHour.class, forVariable(variable), INITS);
    }

    public QTaskHour(Path<? extends TaskHour> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaskHour(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTaskHour(PathMetadata<?> metadata, PathInits inits) {
        this(TaskHour.class, metadata, inits);
    }

    public QTaskHour(Class<? extends TaskHour> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.taskHoursTask = inits.isInitialized("taskHoursTask") ? new QTask(forProperty("taskHoursTask"), inits.get("taskHoursTask")) : null;
    }

}

