// Дана json строка (можно сохранить в файл и читать из файла) 
// (Коллеги, если сложно будет распарсить .json -> можно работать как со строкой обычной)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package Seminar2;

import org.json.*;

public class Parsingstring {
    public static void main(String[] args){
        gradesString();
    }
    /**
     * функция обрабатывает json в строку и выводит её в консоль
     * @param
     * @return вывод заданной строки в консоль
     */
    private static void gradesString()
    {
        JSONArray studentsGrades = new JSONArray("[" +
                "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
        for (int i = 0; i < studentsGrades.length(); i++)
        {
            StringBuilder lastNameStudent = new StringBuilder((String) studentsGrades.getJSONObject(i).get("фамилия"));
            StringBuilder gradeStudent = new StringBuilder((String) studentsGrades.getJSONObject(i).get("оценка"));
            StringBuilder subjectStudent = new StringBuilder((String) studentsGrades.getJSONObject(i).get("предмет"));
            System.out.println("Студент(ка) " + lastNameStudent + " получил(а) " + gradeStudent + " по предмету " + subjectStudent);
        }
    }
}
