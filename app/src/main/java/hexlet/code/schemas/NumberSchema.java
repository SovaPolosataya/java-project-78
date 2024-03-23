package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        super();
    }

    @Override
    public NumberSchema required() {
        addCheck(REQUIRED, object -> object instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addCheck(POSITIVE, value -> value == null || ((Integer) value) > 0);
        return this;
    }

    public NumberSchema range(Integer num1, Integer num2) {
        if (num2 > num1) {
            addCheck(RANGE, value -> ((Integer) value) >= num1 && ((Integer) value) <= num2);
        } else {
            throw new IllegalArgumentException(
                    "Invalid argument values, the first argument cannot be larger than the second.");
        }
        return this;
    }
}
