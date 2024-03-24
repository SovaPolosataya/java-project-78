package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
    }

    @Override
    public StringSchema required() {
        addCheck(REQUIRED,
                object -> object instanceof String string && !string.isEmpty());

        return this;
    }

    public StringSchema minLength(Integer length) {
        if (length >= 0) {
            addCheck(MIN_LENGTH,
                    value -> ((String) value).length() >= length);
        } else {
            throw new IllegalArgumentException("The argument cannot be less than 0");
        }

        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(CONTAINS,
                value -> ((String) value).contains(substring));

        return this;
    }
}
