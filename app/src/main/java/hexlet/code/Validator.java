package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public final class Validator<R, T> {

    public StringSchema<?> string() {
        return new StringSchema<String>();
    }

    public NumberSchema<?> number() {
        return new NumberSchema<Number>();
    }

    public MapSchema<R, T> map() {
        return new MapSchema<R, T>();
    }
}
