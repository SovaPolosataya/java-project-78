### Hexlet tests and linter status:
[![Actions Status](https://github.com/SovaPolosataya/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/SovaPolosataya/java-project-78/actions)   ![example workflow](https://github.com/SovaPolosataya/java-project-78/actions/workflows/gradle.yml/badge.svg)

[![Maintainability](https://api.codeclimate.com/v1/badges/a5144b77145583eca5c8/maintainability)](https://codeclimate.com/github/SovaPolosataya/java-project-78/maintainability)  [![Test Coverage](https://api.codeclimate.com/v1/badges/a5144b77145583eca5c8/test_coverage)](https://codeclimate.com/github/SovaPolosataya/java-project-78/test_coverage)

 Валидатор данных. 
Представляет из себя библиотеку, с помощью которой вы можете проверить корректность различных данных. 
Удобно использовать для работы с данными форм, заполняемых пользователями. 
В приложении реализована возможность проверки данных нескольких типов: String, Integer, Map (в том числе сложные 
вложенные данные на основе Map).

 Проверки String: является ли объект строкой, проверка на null, соответствие строки заданной минимальной длине 
и поиск подстроки в заданной строке.
 
 Проверки Number: является ли объект числом, проверка на null, проверка того, является ли число положительным, 
и входит ли это число в заданный диапазон.

 [Проверка Map:](..%2F%D0%98%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F%2F%D0%A1%D0%BD%D0%B8%D0%BC%D0%BA%D0%B8%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%2Fpr3_map.png) проверка на null, проверка соответствия карты указанному размеру, проверка значений карты по схемам 
проверок, переданных пользователем.