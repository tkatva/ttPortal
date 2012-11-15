package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QChangeRequest is a Querydsl query type for ChangeRequest
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QChangeRequest extends EntityPathBase<ChangeRequest> {

    private static final long serialVersionUID = 1041897199;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QChangeRequest changeRequest = new QChangeRequest("changeRequest");

    public final BooleanPath changeRequestClosed = createBoolean("changeRequestClosed");

    public final DateTimePath<java.util.Date> changeRequestCreationDate = createDateTime("changeRequestCreationDate", java.util.Date.class);

    public final StringPath changeRequestCreatorId = createString("changeRequestCreatorId");

    public final StringPath changeRequestDescription = createString("changeRequestDescription");

    public final NumberPath<Long> changeRequestId = createNumber("changeRequestId", Long.class);

    public final StringPath changeRequestName = createString("changeRequestName");

    public final NumberPath<Integer> changeRequestPriority = createNumber("changeRequestPriority", Integer.class);

    public final QProject changeRequestProject;

    public final DateTimePath<java.util.Date> changeRequestResolutionDate = createDateTime("changeRequestResolutionDate", java.util.Date.class);

    public QChangeRequest(String variable) {
        this(ChangeRequest.class, forVariable(variable), INITS);
    }

    public QChangeRequest(Path<? extends ChangeRequest> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QChangeRequest(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QChangeRequest(PathMetadata<?> metadata, PathInits inits) {
        this(ChangeRequest.class, metadata, inits);
    }

    public QChangeRequest(Class<? extends ChangeRequest> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.changeRequestProject = inits.isInitialized("changeRequestProject") ? new QProject(forProperty("changeRequestProject")) : null;
    }

}

