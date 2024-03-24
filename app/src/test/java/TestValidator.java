import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testMapSchema() {
        var data = new HashMap<String, String>();
        data.put("key1", "value1");

        var v = new Validator();
        var schema = v.map();

        assertTrue(schema.isValid(new HashMap<>()));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(data));

        schema.required();

        assertTrue(schema.isValid(new HashMap<>()));
        assertTrue(schema.isValid(data));
        assertFalse(schema.isValid(null));

        schema.sizeof(2);

        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void testMapSchemaShape() {
        var v = new Validator();
        var schema = v.map();

        Map<String, BaseSchema> schemas1 = new HashMap<>();
        schemas1.put("firstName", v.string().required().contains("a"));
        schemas1.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas1);

        Map<String, String> person1 = new HashMap<>();
        person1.put("firstName", "Vasya");
        person1.put("lastName", "Petrov");
        assertTrue(schema.isValid(person1));

        Map<String, String> person2 = new HashMap<>();
        person2.put("firstName", "Irina");
        person2.put("lastName", null);
        assertFalse(schema.isValid(person2));

        Map<String, String> person3 = new HashMap<>();
        person3.put("firstName", "Sharik");
        person3.put("lastName", "D");
        assertFalse(schema.isValid(person3));

        Map<String, BaseSchema> schemas2 = new HashMap<>();
        schemas2.put("name", v.string());
        schemas2.put("nickName", v.string().required().minLength(5).contains("gamer"));
        schemas2.put("age", v.number().required().positive().range(16, 200));

        schema.shape(schemas2);

        Map<String, Object> gamer1 = new HashMap<>();
        gamer1.put("name", "Vasya");
        gamer1.put("nickName", "gamer Puh");
        gamer1.put("age", 18);

        assertTrue(schema.isValid(gamer1));

        Map<String, Object> gamer2 = new HashMap<>();
        gamer2.put("name", null);
        gamer2.put("nickName", "gamer Rabbit");
        gamer2.put("age", 22);

        assertTrue(schema.isValid(gamer2));

        Map<String, Object> gamer3 = new HashMap<>();
        gamer3.put("name", "Olga");
        gamer3.put("nickName", "Nyusha");
        gamer3.put("age", 35);

        assertFalse(schema.isValid(gamer3));

        Map<String, Object> gamer4 = new HashMap<>();
        gamer4.put("name", null);
        gamer4.put("nickName", "gamer Tigr");
        gamer4.put("age", 12);

        assertFalse(schema.isValid(gamer4));
    }
}
