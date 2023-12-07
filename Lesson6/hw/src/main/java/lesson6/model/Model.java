package lesson6.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Double> getDataListFromSring(String str) throws NumberFormatException{
        if(str.isEmpty()) throw new NumberFormatException();

        List<Double> list = new ArrayList<>();
        String[] strings = str.split(str);
        for (String it : strings) {
            list.add(Double.parseDouble(it));
        }
        return list;
    }

    public Double calculateMeanList(List<Double> list){
        if(list == null || list.isEmpty()) throw new IllegalArgumentException();
        Double result = 0.0;
        for (Double it : list) {
            result += it;
        }
        return result / list.size();
    }


}
