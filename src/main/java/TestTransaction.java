import com.alibaba.fastjson.JSON;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2017/11/8.
 */
public class TestTransaction {


    public static void main(String args[]){
        ExecutorService pool = Executors.newCachedThreadPool();

        TestThread thread1 = new TestThread();
        thread1.setName("张三");
        thread1.setSalary(1000l);
        pool.execute(thread1);

        TestThread thread2 = new TestThread();
        thread2.setName("张三");
        thread2.setSalary(1000l);
        pool.execute(thread2);

        TestThread thread3 = new TestThread();
        thread3.setName("李四");
        thread3.setSalary(2000l);
        pool.execute(thread3);

        TestThread thread5 = new TestThread();
        thread5.setName("李四");
        thread5.setSalary(2000l);
        pool.execute(thread5);

        TestThread thread4 = new TestThread();
        thread4.setName("王五");
        thread4.setSalary(3000l);
        pool.execute(thread4);
    }

    public static void insertEmployee(String nameParam,long salaryParam){
        Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://localhost:3306/employee?"
                + "user=root&password=love&useUnicode=true&characterEncoding=UTF8";
        for (int i = 0; i < 3; i++) {//重试三次
            try {
                // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
                // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
                Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
                // or:
                // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
                // or：
                // new com.mysql.jdbc.Driver();

                // 一个Connection代表一个数据库连接
                conn = DriverManager.getConnection(url);

                conn.setAutoCommit(false);//设置自动提交为false
                conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);//设置串行化隔离级别
                // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
                Statement stmt = conn.createStatement();

                sql = "select * from employee where name = '"+nameParam+"'";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
                System.out.println("查询是否有name="+nameParam+"员工;结果是rs.next()="+ JSON.toJSONString(rs.next()+";rs.first="+rs.first()));
                if(rs != null && rs.first()){
                    System.out.println("已经有name="+nameParam+"员工");
                }else{
                    sql = "insert into employee(name,salary)  values('"+nameParam+"',"+salaryParam+")";
                    int  result = stmt.executeUpdate(sql);
                    System.out.println("新增员工结果result="+result+";nameParam="+nameParam);
                }
                rs.close();

                conn.commit();//提交事务
                conn.setAutoCommit(true);//设置自动提交为true
                conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);//设置隔离级别为读提交
                break;
            } catch (Exception e) {
                if(i == 2){
                    System.out.println("MySQL操作错误,e=" + e.getMessage());
                }
                try {
                    conn.rollback(); //回滚事务
                    conn.setAutoCommit(true);//设置自动提交为true
                    conn.setTransactionIsolation(conn.TRANSACTION_READ_COMMITTED);//设置隔离级别为读提交
                    System.out.println("回滚结束");
                } catch (Exception e1) {
                    System.out.println("MySQL回滚操作出现异常,e1="+e1.getMessage());
                }
            } finally {
                try {
                    conn.close();
                } catch (Exception e2) {
                    System.out.println("MySQL关闭数据库连接出现异常,e2="+e2.getMessage());
                }
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
            }
        }
    }

}

class TestThread implements Runnable{
    public String name;
    public long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void run() {
        TestTransaction.insertEmployee(getName(),getSalary());
    }
}
