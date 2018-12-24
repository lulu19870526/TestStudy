package base.zerenlian;

public class Zhuren extends Leader{

    public Zhuren(String name){
        super(name);
    }


    public void handleRequest(QingjiaRequest qingjiaRequest) {
        if(qingjiaRequest.getDays()<3){
            System.out.println("员工请假小于3天");
            System.out.println("主任审批通过");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(qingjiaRequest);
            }
        }


    }

}