### Hexlet tests and linter status:
[![Actions Status](https://github.com/SovaPolosataya/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/SovaPolosataya/java-project-78/actions)   ![example workflow](https://github.com/SovaPolosataya/java-project-78/actions/workflows/gradle.yml/badge.svg)

[![Maintainability](https://api.codeclimate.com/v1/badges/a5144b77145583eca5c8/maintainability)](https://codeclimate.com/github/SovaPolosataya/java-project-78/maintainability)  [![Test Coverage](https://api.codeclimate.com/v1/badges/a5144b77145583eca5c8/test_coverage)](https://codeclimate.com/github/SovaPolosataya/java-project-78/test_coverage)

### Валидатор данных. 

Представляет из себя библиотеку, с помощью которой вы можете проверить корректность различных данных. 
Удобно использовать для работы с данными форм, заполняемых пользователями. 
В приложении реализована возможность проверки данных нескольких типов: String, Integer, Map (в том числе сложные 
вложенные данные на основе Map).

 **Проверки String:** является ли объект строкой, проверка на null, соответствие строки заданной минимальной длине 
и поиск подстроки в заданной строке.
 
 **Проверки Number:** является ли объект числом, проверка на null, проверка того, является ли число положительным, 
и входит ли это число в заданный диапазон.

 **Проверки Map:** проверка на null, проверка соответствия карты указанному размеру, проверка значений карты по схемам 
проверок, переданных пользователем.

### Примеры валидации:

```
//Валидация строк
Validator v = new Validator();
StringSchema schema = v.string();

schema.isValid(null); //true
schema.required().isValid(null); //false
schema.contains("are y").isValid("How are you?"); //true
schema.minLength(3).isValid("Good day"); //false

//Валидация чисел
Validator v = new Validator();
NumberSchema schema = v.number();

schema.isValid(null); //true
schema.positive().isValid(-17); //false
schema.required().isValid(null); //false
schema.range(13, 33);
schema.isValid(17); //true
schema.isValid(10); //false


//Валидация Map
Validator v = new Validator();
MapSchema schema = v.map();

schema.isValid(null); //true
schema.required().isValid(null); //false
schema.isValid(new HashMap<>()); //true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.sizeof(2).isValid(data); //false


//Валидация вложенных данных
Validator v = new Validator();
MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string()required().minLength(5));
schemas.put("age", v.number().required().positive().range(16, 200));

Map<String, Object> person1 = new HashMap<>();
person1.put("name", "Vasya");
person1.put("age", 18);
schema.isValid(person1)); //true

Map<String, Object> person2 = new HashMap<>();
person2.put("name", null);
person2.put("age", 22);
schema.isValid(person2)); //false
```