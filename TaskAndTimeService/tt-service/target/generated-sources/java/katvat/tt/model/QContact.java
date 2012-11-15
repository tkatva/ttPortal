package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QContact is a Querydsl query type for Contact
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QContact extends EntityPathBase<Contact> {

    private static final long serialVersionUID = -1203655088;

    public static final QContact contact = new QContact("contact");

    public final StringPath contactFirstName = createString("contactFirstName");

    public final NumberPath<Long> contactId = createNumber("contactId", Long.class);

    public final StringPath contactLastName = createString("contactLastName");

    public final StringPath contactMiddleName = createString("contactMiddleName");

    public final StringPath contactRemarks = createString("contactRemarks");

    public final ListPath<ContactInformation, QContactInformation> contactsInformation = this.<ContactInformation, QContactInformation>createList("contactsInformation", ContactInformation.class, QContactInformation.class);

    public final StringPath contactTitle = createString("contactTitle");

    public final EnumPath<Contact.ContactType> contactType = createEnum("contactType", Contact.ContactType.class);

    public QContact(String variable) {
        super(Contact.class, forVariable(variable));
    }

    public QContact(Path<? extends Contact> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContact(PathMetadata<?> metadata) {
        super(Contact.class, metadata);
    }

}

