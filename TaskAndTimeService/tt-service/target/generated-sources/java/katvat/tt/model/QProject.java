package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = 1830475081;

    public static final QProject project = new QProject("project");

    public final NumberPath<Integer> budjetedHours = createNumber("budjetedHours", Integer.class);

    public final StringPath lastUpdatedBy = createString("lastUpdatedBy");

    public final NumberPath<Double> projectBudget = createNumber("projectBudget", Double.class);

    public final ListPath<ChangeRequest, QChangeRequest> projectChangeRequests = this.<ChangeRequest, QChangeRequest>createList("projectChangeRequests", ChangeRequest.class, QChangeRequest.class);

    public final BooleanPath projectClosed = createBoolean("projectClosed");

    public final StringPath projectDescription = createString("projectDescription");

    public final DateTimePath<java.util.Date> projectEndDate = createDateTime("projectEndDate", java.util.Date.class);

    public final NumberPath<Long> projectId = createNumber("projectId", Long.class);

    public final StringPath projectManagerId = createString("projectManagerId");

    public final StringPath projectManagerUserId = createString("projectManagerUserId");

    public final StringPath projectName = createString("projectName");

    public final NumberPath<Integer> projectPriority = createNumber("projectPriority", Integer.class);

    public final DateTimePath<java.util.Date> projectStartDate = createDateTime("projectStartDate", java.util.Date.class);

    public final ListPath<Task, QTask> projectTasks = this.<Task, QTask>createList("projectTasks", Task.class, QTask.class);

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QProject(String variable) {
        super(Project.class, forVariable(variable));
    }

    public QProject(Path<? extends Project> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProject(PathMetadata<?> metadata) {
        super(Project.class, metadata);
    }

}

