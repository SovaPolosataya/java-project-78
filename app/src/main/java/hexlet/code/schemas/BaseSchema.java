package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected static final String REQUIRED = "required";

    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected BaseSchema<T> required() {

        return this;
    }

    protected final void addCheck(String name, Predicate<T> check) {
        checks.put(name, check);
    }

    public final boolean isValid(T object) {

        return checks.values()
                .stream()
                .allMatch(check -> check.test(object));
    }
}
