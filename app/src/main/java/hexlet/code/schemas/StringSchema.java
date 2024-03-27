package hexlet.code.schemas;


public final class StringSchema extends BaseSchema<String> {

    static final String MIN_LENGTH = "minLength";
    static final String CONTAINS = "contains";

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        addCheck(REQUIRED,
                o -> (o != null && !o.isEmpty()));

        return this;
    }

    public StringSchema minLength(Integer length) {
        if (length >= 0) {
            addCheck(MIN_LENGTH,
                    value -> value.length() >= length);
        } else {
            throw new IllegalArgumentException("The argument cannot be less than 0");
        }

        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(CONTAINS,
                value -> value.contains(substring));

        return this;
    }
}
