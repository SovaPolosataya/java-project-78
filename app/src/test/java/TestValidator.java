import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidator {

    @Test
    public void testStringSchema() {
        String content1 = "How are you?";
        String content2 = "day";

        var v = new Validator();
        var schema = v.string();


        assertTrue(schema.isValid(content1));
        assertTrue(schema.isValid(null));

        schema = v.string().required();

        assertTrue(schema.isValid(content1));
        assertFalse(schema.isValid(null));

        schema = v.string().required().minLength(5);

        assertTrue(schema.isValid(content1));
        assertFalse(schema.isValid(content2));

        schema = v.string().required().contains("w ar");

        assertTrue(schema.isValid(content1));
        assertFalse(schema.isValid(content2));

        schema = v.string().required().minLength(5).contains("a");

        assertTrue(schema.isValid(content1));
        assertFalse(schema.isValid(content2));
    }

    @Test
    public void testNumberSchema() {

        var v = new Validator();
        var schema = v.number();


        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));


        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}
