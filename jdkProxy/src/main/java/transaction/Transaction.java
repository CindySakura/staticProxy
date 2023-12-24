package transaction;

public class Transaction {
    public void before(){
        System.out.println("start transaction");
    }

    public void after(){
        System.out.println("end transaction");
    }
}
