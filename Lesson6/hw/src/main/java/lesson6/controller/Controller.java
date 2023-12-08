package lesson6.controller;

import lesson6.model.Model;
import lesson6.visual.Visual;

public class Controller {

    public static void Start() {
        Double res1 = 0.0, res2 = 0.0;
        Visual visual = new Visual();

        do {
            Visual.print("Ввод первого списка чисел (double)");
            try {                
                res1 = Model.calculateMeanList(
                        Model.getDataListFromSring(
                                visual.userInputDataList()));

            } catch (Exception e) {
                Visual.print("Неверный формат ввода. Повторите ввод");
                continue;
            }
            break;
        } while (true);

        Visual.print("*****************************************");

        do {
            Visual.print("Ввод второго списка чисел (double)");
            try {
                res2 = Model.calculateMeanList(
                        Model.getDataListFromSring(
                                visual.userInputDataList()));

            } catch (Exception e) {
                Visual.print("Неверный формат ввода. Повторите ввод");
                continue;
            }
            break;
        } while (true);

        Visual.print(Model.compareLists(res1, res2));
    }
}
