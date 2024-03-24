package hexlet.code.schemas;

public class StringSchema<T> extends BaseSchema<T> {

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema<T> required() {
        addCheck(REQUIRED,
                object -> object instanceof String string && !string.isEmpty());

        return this;
    }

    public StringSchema<T> minLength(Integer length) {
        if (length >= 0) {
            addCheck(MIN_LENGTH,
                    value -> ((String) value).length() >= length);
        } else {
            throw new IllegalArgumentException("The argument cannot be less than 0");
        }

        return this;
    }

    public StringSchema<T> contains(String substring) {
        addCheck(CONTAINS,
                value -> ((String) value).contains(substring));

        return this;
    }
}
