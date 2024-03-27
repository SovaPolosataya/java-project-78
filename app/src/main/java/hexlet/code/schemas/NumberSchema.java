package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    static final String POSITIVE = "positive";
    static final String RANGE = "range";

    public NumberSchema() {
        super();
    }

    @Override
    public NumberSchema required() {
        addCheck(REQUIRED,
                Objects::nonNull);

        return this;
    }

    public NumberSchema positive() {
        addCheck(POSITIVE,
                value -> (value == null || value > 0));

        return this;
    }

    public NumberSchema range(Integer num1, Integer num2) {
        if (num2 > num1) {
            addCheck(RANGE,
                    value -> (value >= num1 && value <= num2));
        } else {
            throw new IllegalArgumentException(
                    "Invalid argument values, the first argument cannot be larger than the second.");
        }

        return this;
    }
}
