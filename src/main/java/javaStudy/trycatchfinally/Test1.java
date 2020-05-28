package javaStudy.trycatchfinally;

/**
 * 假设利用 return 语句从 try 语句块中退出。在方法返回前，finally子句的内容将被执行。
 * 如果 finally 子句中也有一个 return 语句，这个返回值将会覆盖原始的返回值。
 * 但是finally之外的则不会被执行
 */
public class Test1 {

    public static void main(String[] args){
        int sum = add(1,2);//sum为3
        System.out.println("sum:"+sum);

        int fTest = f_test();//值为2
        System.out.println("fTest:"+fTest);

        test2();

        test3();
    }

    /**
     * try catch是直接处理，处理完成之后程序继续往下执行.
     * throw则是将异常抛给它的上一级处理，程序便不往下执行了。
     * 本题的catch语句块里面，打印完1之后，又抛出了一个RuntimeException，程序并没有处理它，
     * 而是直接抛出，因此执行完finally语句块之后，程序终止了
     */
    public static void test3(){
        try {
            int i = 100 / 0;
            System.out.println(i);//后面的语句不会执行
        } catch (Exception e) {
            System.out.println("test3:"+1);
            throw new RuntimeException();//只会执行finally中的，其他的不会执行
        } finally {
            System.out.println("test3:"+2222);
        }
        //不会执行
        System.out.println(3);
    }

    public static void test2(){
        try {
            int i = 100 / 0;
            System.out.println(i);//try后面的语句不会执行
        } catch (Exception e) {
            System.out.println(1);
            //throw new RuntimeException();
        } finally {
            System.out.println(2222);
        }
        //前面没有return语句，所以会执行
        System.out.println(3);
    }

    /**
     * 1、finally块一定会执行，无论是否try…catch。
     *
     * 2、finally前有return，会先执行return语句，并保存下来，再执行finally块，最后return。
     *
     * 3、finally前有return、finally块中也有return，先执行前面的return，保存下来，
     * 再执行finally的return，覆盖之前的结果，并返回。
     */
    public static int f_test(){
        int a = 0;
        try{
            a = 1;
            return a;
        }
        finally{
            System.out.println("It is in final chunk.");
            a = 2;
            return a;
        }
    }

    public static int add(int a,int b)
    {
        try {
            return a+b;
        }
        catch (Exception e) {
            System.out.println("catch语句块");//不会执行
        }
        finally{
            System.out.println("finally语句块");
        }
        //因为try中有return，所以finally之后的都不会执行
        System.out.println("我不会出现的！");//不会执行
        return 0;//不会执行

    }
}
