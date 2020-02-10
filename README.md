# Тестовое задание для компании Citeck


**Задание 1:**  
Имеется массив чисел, получить список вида {число, количество вхождений числа в массив}, список должен быть отсортирован по количеству вхождений, внутри по возрастания числа. Использовать можно любой алгоритмический язык.  
_Решение:_ IntListToSortedIntEntryListConverterImpl.java
___

**Задание 2:**  
Написать алгоритм проверки корректности регулярного выражения, которое включает [,],(,) т.е., например ([][[]()]) - правильно, ([][]()]) – неправильно  
_Решение:_ RegexpBracketsValidator.java
___

**Задание 3:**  
Написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя циклы и рекурсию.    
_Решение для десятичных чисел с помощью регулярных выражений:_ DecimalFarRightZeroRegexpReplacer.java  
_Решение для десятичных чисел с помощью внутренних функций класса String:_ DecimalFarRightZeroIndexReplacer.java  
_Решение для двоичных чисел:_ BinaryFarRightZeroReplacer.java  
___

**Задание 4:**  
Имеется таблица с 1 полем, заполненная числами по порядку: {1,2,4,7,8,11..}. Написать SQL Запрос который делает выборку следующего вида (2 столбца): {{3,1},{5,2},...}, Т.е. в первом поле идет число, с которого начинается пропуск, во втором количество пропущенных чисел. Для написания скрипта рекомендуется пользоваться сервисом http://sqlfiddle.com для упрощения проверки правильности скрипта. В решении ожидается увидеть:    
1. Название стандарта SQL, на котором выполнялось задание;  
2. Скрипт генерации таблиц и заполнения данных;  
3. Скрипт, решающий саму задачу.      

_Решение:_
1. СУБД Postgresql, соответствует стандарту SQL:2011
2. Скрипт генерации таблиц и заполнения данных, расположен по пути "src/main/resources/sql/Generation.sql"
2. Скрипт, решающий задачу, расположен по пути "src/main/resources/sql/Solution.sql"
___