package katvat.tt.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QValueAddedTax is a Querydsl query type for ValueAddedTax
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QValueAddedTax extends EntityPathBase<ValueAddedTax> {

    private static final long serialVersionUID = -1050353332;

    public static final QValueAddedTax valueAddedTax = new QValueAddedTax("valueAddedTax");

    public final StringPath vatCode = createString("vatCode");

    public final NumberPath<Long> vatId = createNumber("vatId", Long.class);

    public final StringPath vatName = createString("vatName");

    public final NumberPath<Integer> vatPercent = createNumber("vatPercent", Integer.class);

    public QValueAddedTax(String variable) {
        super(ValueAddedTax.class, forVariable(variable));
    }

    public QValueAddedTax(Path<? extends ValueAddedTax> path) {
        super(path.getType(), path.getMetadata());
    }

    public QValueAddedTax(PathMetadata<?> metadata) {
        super(ValueAddedTax.class, metadata);
    }

}

