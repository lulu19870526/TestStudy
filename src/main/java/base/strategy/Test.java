package base.strategy;

public class Test {

    public static void main(String[] args){
        Environment e = new Environment(new AddStrategy());
        int result = e.calculate(2,3);
        System.out.println("result="+result);
    }
}
