package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QClient is a Querydsl query type for Client
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QClient extends EntityPathBase<Client> {

    private static final long serialVersionUID = -873045093;

    public static final QClient client = new QClient("client");

    public final StringPath clientAccessCode = createString("clientAccessCode");

    public final ListPath<Address, QAddress> clientAddresses = this.<Address, QAddress>createList("clientAddresses", Address.class, QAddress.class);

    public final ListPath<ContactInformation, QContactInformation> clientContactInformations = this.<ContactInformation, QContactInformation>createList("clientContactInformations", ContactInformation.class, QContactInformation.class);

    public final ListPath<Contact, QContact> clientContacts = this.<Contact, QContact>createList("clientContacts", Contact.class, QContact.class);

    public final NumberPath<Long> clientId = createNumber("clientId", Long.class);

    public final StringPath clientName = createString("clientName");

    public final NumberPath<Integer> clientPriority = createNumber("clientPriority", Integer.class);

    public final EnumPath<Client.ClientStatus> clientStatus = createEnum("clientStatus", Client.ClientStatus.class);

    public final ListPath<TaskType, QTaskType> clientTaskTypes = this.<TaskType, QTaskType>createList("clientTaskTypes", TaskType.class, QTaskType.class);

    public final StringPath clientType = createString("clientType");

    public final BooleanPath paymentsLate = createBoolean("paymentsLate");

    public QClient(String variable) {
        super(Client.class, forVariable(variable));
    }

    public QClient(Path<? extends Client> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClient(PathMetadata<?> metadata) {
        super(Client.class, metadata);
    }

}

