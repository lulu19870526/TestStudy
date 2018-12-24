package base.zerenlian;

public class Test {

    public static void main(String[] args) {

        //QingjiaRequest qingjiaRequest = new QingjiaRequest("张三", 2, "请假");
        QingjiaRequest qingjiaRequest = new QingjiaRequest("张三", 5, "请假");
        Leader a = new Zhuren("张主任");
        Leader b = new Manager("王经理");
        //可以用一个容器对象责任链对象进行一些封装
        a.setNextLeader(b);
        //开始请假
        a.handleRequest(qingjiaRequest);

    }
}
