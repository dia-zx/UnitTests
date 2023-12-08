package lesson6.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    /**
     * Извлекает список чисел <Double> из строки (разделитель - "пробел")
     * @param str
     * @return
     * @throws NumberFormatException
     */
    public static List<Double> getDataListFromSring(String str) throws NumberFormatException{
        if(str.isEmpty()) throw new NumberFormatException();

        List<Double> list = new ArrayList<>();
        String[] strings = str.split(" ");
        for (String it : strings) {
            list.add(Double.parseDouble(it));
        }
        return list;
    }

    /**
     * Вычисление среднего арифметического из списка <Double>
     * @param list
     * @return среднее арифметическое
     */
    public static Double calculateMeanList(List<Double> list){
        if(list == null || list.isEmpty()) throw new IllegalArgumentException();
        Double result = 0.0;
        for (Double it : list) {
            result += it;
        }
        return result / list.size();
    }

    /**
     * Сранение 2х значений (средних арифметических 2х списков)
     * @param meanList1
     * @param meanList2
     * @return результат сравнения в текстовой форме
     */
    public static String compareLists(Double meanList1, Double meanList2){
        if (meanList1 < meanList2)
            return "Второй список имеет большее среднее значение";
        if (meanList1 > meanList2)
            return ("Первый список имеет большее среднее значение");
        return "Средние значения равны";        
    }

}
