package base.zerenlian;

//经理
public class Manager extends Leader{

    public Manager(String name){
        super(name);
    }


    public void handleRequest(QingjiaRequest qingjiaRequest) {
        if(qingjiaRequest.getDays()<10&&qingjiaRequest.getDays()>3){
            System.out.println("经理审批通过");
        }else{
            //经理处理后的逻辑
        }


    }

}
