package Lesson16;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lesson16 {
    public static void main(String[] args) {
//        Задача 1:
//        На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
//        строка является ключом, и ее значение равно true, если эта строка встречается в массиве
//        2 или более раз. Пример:
//        wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
//        wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
//        wordMultiple(["c", "c", "c", "c"]) → {"c": true}

        String[] test1 = {"a", "b", "a", "c", "b"};
        System.out.println("Результат 1: " + wordMultiple(test1));

//        Задача 2:
//        На вход поступает массив непустых строк, создайте и верните Map<String,
//        String> следующим образом: для каждой строки добавьте ее первый символ в
//        качестве ключа с последним символом в качестве значения. Пример:
//        pairs(["code", "bug"]) → {"b": "g", "c": "e"}
//        pairs(["man", "moon", "main"]) → {"m": "n"}
//        pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}

        String[] test2 = {"man", "moon", "main"};
        System.out.println("Результат 2: " + pairs(test2)); // {m=n}

//        Задача *
//        Задана строка, которая может иметь внутри себя скобки. Скобкой считается
//        любой из следующих символов — «(«, «)», «[«, «]», «{«, «}». Проверить
//        сбалансированность расстановки скобок в этой строке. Набор скобок считается
//        сбалансированной парой, если открывающая скобка "(", "[" и "{" стоит слева от
//        соответствующей закрывающей скобки ")", "]" и "} ", соответственно. Строка,
//        содержащая пары скобок, не сбалансирована, если набор заключенных в нее
//        скобок не совпадает .
//        Например, если ввод «{[(])}», пара квадратных скобок «[]» заключает в себя
//        одну несбалансированную открывающую круглую скобку «(». Аналогично, пара
//        круглых скобок «() ", заключает в себя одну несбалансированную
//        закрывающую квадратную скобку "]". Таким образом, входная строка "{[(])}"
//        несбалансированная.
//        Пример
//        () - сбалансирована
//        [()] - сбалансирована
//        {[()]} - сбалансирована
//        ([{{[(())]}}]) - сбалансирована
//        {{[]()}}}} - не сбалансирована
//        {[(])} - не сбалансирована

        String[] tests = {"()", "[()]", "{[()]}", "([{{[(())]}}])", "{{[]()}}}}", "{[(])}"};

        for (String s : tests) {
            System.out.println(s + " -> " + (isBalanced(s) ? "сбалансирована" : "не сбалансирована"));
        }
    }

//   Задача 1
    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> result = new HashMap<>();

        for (String s : strings) {
            if (result.containsKey(s)) {
                result.put(s, true);
            } else {
                result.put(s, false);
            }
        }
        return result;
    }

//  Задача 2
    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();

        for (String s : strings) {
            String first = String.valueOf(s.charAt(0));
            String last = String.valueOf(s.charAt(s.length() - 1));
            map.put(first, last);
        }
        return map;
    }

    //  Задача *
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (brackets.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
