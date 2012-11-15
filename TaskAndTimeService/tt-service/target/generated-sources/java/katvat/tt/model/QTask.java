package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QTask is a Querydsl query type for Task
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTask extends EntityPathBase<Task> {

    private static final long serialVersionUID = -1881974443;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QTask task = new QTask("task");

    public final StringPath assignedUserId = createString("assignedUserId");

    public final NumberPath<Integer> budjetedTaskHours = createNumber("budjetedTaskHours", Integer.class);

    public final DateTimePath<java.util.Date> completedDate = createDateTime("completedDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateSynced = createDateTime("dateSynced", java.util.Date.class);

    public final DateTimePath<java.util.Date> lastUpdated = createDateTime("lastUpdated", java.util.Date.class);

    public final StringPath lastUpdatedBy = createString("lastUpdatedBy");

    public final BooleanPath privateTask = createBoolean("privateTask");

    public final ListPath<Task, QTask> subTasks = this.<Task, QTask>createList("subTasks", Task.class, QTask.class);

    public final BooleanPath taskClosed = createBoolean("taskClosed");

    public final BooleanPath taskClosedFlag = createBoolean("taskClosedFlag");

    public final ListPath<Comment, QComment> taskComments = this.<Comment, QComment>createList("taskComments", Comment.class, QComment.class);

    public final StringPath taskDescription = createString("taskDescription");

    public final DateTimePath<java.util.Date> taskEndDate = createDateTime("taskEndDate", java.util.Date.class);

    public final ListPath<TaskHour, QTaskHour> taskHours = this.<TaskHour, QTaskHour>createList("taskHours", TaskHour.class, QTaskHour.class);

    public final NumberPath<Long> taskId = createNumber("taskId", Long.class);

    public final StringPath taskName = createString("taskName");

    public final NumberPath<Integer> taskPercentComplete = createNumber("taskPercentComplete", Integer.class);

    public final NumberPath<Integer> taskPriority = createNumber("taskPriority", Integer.class);

    public final QProject taskProject;

    public final DateTimePath<java.util.Date> taskStartDate = createDateTime("taskStartDate", java.util.Date.class);

    public final EnumPath<Task.TaskStatus> taskStatus = createEnum("taskStatus", Task.TaskStatus.class);

    public final NumberPath<Integer> taskVersion = createNumber("taskVersion", Integer.class);

    public final BooleanPath teamTask = createBoolean("teamTask");

    public final StringPath userId = createString("userId");

    public final BooleanPath userTask = createBoolean("userTask");

    public QTask(String variable) {
        this(Task.class, forVariable(variable), INITS);
    }

    public QTask(Path<? extends Task> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTask(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTask(PathMetadata<?> metadata, PathInits inits) {
        this(Task.class, metadata, inits);
    }

    public QTask(Class<? extends Task> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.taskProject = inits.isInitialized("taskProject") ? new QProject(forProperty("taskProject")) : null;
    }

}

