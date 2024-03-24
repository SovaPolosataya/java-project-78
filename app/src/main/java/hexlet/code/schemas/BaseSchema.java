package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected static final String REQUIRED = "required";
    protected static final String MIN_LENGTH = "minLength";
    protected static final String CONTAINS = "contains";
    protected static final String POSITIVE = "positive";
    protected static final String RANGE = "range";
    protected static final String SIZE_OF = "sizeof";
    protected static final String SHAPE = "shape";

    protected Map<String, Predicate<Object>> checks = new LinkedHashMap<>();

//    public BaseSchema<T> required() {
//        return this;
//    }

    protected final void addCheck(String name, Predicate<Object> check) {
        checks.put(name, check);
    }

    public final boolean isValid(Object object) {

        return checks.values()
                .stream()
                .allMatch(check -> check.test(object));
    }
}
