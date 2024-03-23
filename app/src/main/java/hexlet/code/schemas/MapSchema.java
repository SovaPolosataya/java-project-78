package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
    }

    @Override
    public MapSchema required() {
        addCheck(REQUIRED, object -> object instanceof Map);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        if (size >= 0) {
            addCheck(SIZE_OF, map -> ((Map) map).size() == size);
        } else {
            throw new IllegalArgumentException("The argument cannot be less than 0");
        }
        return this;
    }
}
