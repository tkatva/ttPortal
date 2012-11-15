package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = 992093732;

    public static final QAddress address = new QAddress("address");

    public final StringPath addressAddlStreet = createString("addressAddlStreet");

    public final StringPath addressCity = createString("addressCity");

    public final StringPath addressCountry = createString("addressCountry");

    public final NumberPath<Long> addressId = createNumber("addressId", Long.class);

    public final StringPath addressName = createString("addressName");

    public final StringPath addressPostNumber = createString("addressPostNumber");

    public final StringPath addressStreet = createString("addressStreet");

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata<?> metadata) {
        super(Address.class, metadata);
    }

}

