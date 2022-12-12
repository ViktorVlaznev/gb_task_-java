// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package Seminar2;

import java.util.LinkedHashMap;
import java.util.Map;

public class SQLREQUEST {
    public static void main(String[] args) {
        String sqlRequest = "select * from students where ";
        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String resultStr = jsonString.replace("{", "").replace("}", "")
        .replace("\"", "");
        // тут выводит неправильно с null
        System.out.println(getMapwithJson(resultStr));
        System.out.println(sqlRequest + getQuerywithMap(getMapwithJson(resultStr)));
        // напрямую работает правильно
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name","Ivanov");
        map.put("country","Russia");
        map.put("city","Moscow");
        map.put("age",null);
        System.out.println(map);
        System.out.println(sqlRequest + getQuerywithMap(map));
    }
    /**
     * функция переводит строку в объект Map
     * @param строка в формате JSON
     * @return Map
     */
    private static Map getMapwithJson(String str){
        Map<String, String> myMap = new LinkedHashMap<>();
        String[] pairs = str.split(",");
        for (int i=0;i<pairs.length;i++) {
            String pair = pairs[i];
            String[] keyValue = pair.split(":");
            // вот это условие не срабатывает!!!
            if (keyValue[1] == "null") {
                myMap.put(keyValue[0], null);
            } else myMap.put(keyValue[0], String.valueOf(keyValue[1]));
        }
        return myMap;
    }
    /**
     * функция переводит обект MAP в строку для запроса
     * @param Map
     * @return строка
     */
    private static String getQuerywithMap(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null || params.isEmpty())
            return result.toString();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            // вот это условие не срабатывает!!! 
            if (pair.getKey() == null || pair.getValue() == "null" || pair.getValue() == null)
                continue;
            result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }
        if (result.length() > 5)
            result.delete(result.length() - 5, result.length());
        return result.toString();
    }
}
