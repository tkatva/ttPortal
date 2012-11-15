package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QContactInformation is a Querydsl query type for ContactInformation
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContactInformation extends EntityPathBase<ContactInformation> {

    private static final long serialVersionUID = 1137269948;

    public static final QContactInformation contactInformation = new QContactInformation("contactInformation");

    public final StringPath contactInformationDescription = createString("contactInformationDescription");

    public final NumberPath<Long> contactInformationId = createNumber("contactInformationId", Long.class);

    public final StringPath contactInformationName = createString("contactInformationName");

    public final StringPath contactInformationValue = createString("contactInformationValue");

    public QContactInformation(String variable) {
        super(ContactInformation.class, forVariable(variable));
    }

    public QContactInformation(Path<? extends ContactInformation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContactInformation(PathMetadata<?> metadata) {
        super(ContactInformation.class, metadata);
    }

}

