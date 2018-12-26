package base.xiangyuan;

public class Test {

    public static void main(String[] args) {
        Model model1 = (Model) ModelFactory.getShow("米兰达·可儿");
        model1.setStyle("迷幻Bono系列");
        model1.show();

        Model model2 = (Model) ModelFactory.getShow("刘雯");
        model2.setStyle("冰与火系列");
        model2.show();
        System.out.println("model1 == model2:"+(model1 == model2));

        Model model3 = (Model) ModelFactory.getShow("米兰达·可儿");
        model3.setStyle("天使肖像系列");
        model3.show();
        System.out.println("model1 == model3:"+(model1 == model3));
    }
}
