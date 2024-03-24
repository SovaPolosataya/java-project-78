package hexlet.code.schemas;

import java.util.Map;

public class MapSchema<R, T> extends BaseSchema<T> {

    public MapSchema() {
        super();
    }

    @Override
    public MapSchema<R, T> required() {
        addCheck(REQUIRED,
                object -> object instanceof Map);

        return this;
    }

    public MapSchema<R, T> sizeof(Integer size) {
        if (size >= 0) {
            addCheck(SIZE_OF,
                    map -> ((Map) map).size() == size);
        } else {
            throw new IllegalArgumentException("The argument cannot be less than 0");
        }

        return this;
    }

    public  MapSchema<R, T> shape(Map<String, BaseSchema<T>> mapSchema) {
        addCheck(SHAPE,
                map -> mapSchema.entrySet()
                        .stream()
                        .allMatch(e ->
                e.getValue().isValid((T) ((Map) map).get(e.getKey())))
        );

        return this;
    }
}
