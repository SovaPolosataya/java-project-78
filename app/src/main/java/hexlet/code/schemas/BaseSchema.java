package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    protected static final String REQUIRED = "required";
    protected static final String MIN_LENGTH = "minLength";
    protected static final String CONTAINS = "contains";

    protected Map<String, Predicate<Object>> checks = new LinkedHashMap<>();

    protected final void addCheck(String name, Predicate<Object> check) {
        checks.put(name, check);
    }

    public final boolean isValid(Object object) {
        return checks.values().stream().allMatch(check -> check.test(object));
    }

}
