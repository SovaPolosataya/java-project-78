package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<?, ?>> {

    static final String SIZE_OF = "sizeof";
    static final String SHAPE = "shape";

    public MapSchema() {
        super();
    }

    @Override
    public MapSchema<T> required() {
        addCheck(REQUIRED,
                Objects::nonNull);

        return this;
    }

    public MapSchema<T> sizeof(Integer size) {
        if (size >= 0) {
            addCheck(SIZE_OF,
                    map -> map.size() == size);
        } else {
            throw new IllegalArgumentException("The argument cannot be less than 0");
        }

        return this;
    }

    public  MapSchema<T> shape(Map<String, BaseSchema<T>> mapSchema) {
        addCheck(SHAPE,
                map -> mapSchema.entrySet()
                        .stream()
                        .allMatch(e ->
                e.getValue().isValid((T) (map.get(e.getKey())))
        ));

        return this;
    }
}
