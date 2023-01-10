package Theread;

public class ThreadExample3 {
    public static void main(String[] args) {

//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Get Thread Name");
//            }
//        });
//
//        thread3.start();
//
//        System.out.println("thread3.getName() = " + thread3.getName());


        Runnable threadTask3 = new ThreadTask3();
        Thread thread3_1 = new Thread(threadTask3);
        Thread thread3_2 = new Thread(threadTask3);

        thread3_1.setName("김코딩");
        thread3_2.setName("박자바");

        thread3_1.start();
        thread3_2.start();
    }
}

class Account {

    //잔액을 나타내는 변수

    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    //인출 성공시 true / false

//    public synchronized boolean withdraw(int money) {
//        //인출 여부 판단
//        if (balance >= money) {
//
//            try { Thread.sleep(1000); } catch (Exception error) {}
//
//            balance -= money;
//
//            return true;
//        }
//        return false;
//    }
//}

    public boolean withdraw(int money) {
        //인출 여부 판단
        synchronized (this) {
        if (balance >= money) {


                try {
                    Thread.sleep(1000);
                } catch (Exception error) {
                }

                balance -= money;

                return true;
            }
            return false;
        }
    }
}


class ThreadTask3 implements Runnable{
    Account account = new Account();

    public void run() {
        while (account.getBalance() >0 ) {

            int money = (int)(Math.random() *3 +1) * 100;

            boolean denied = !account.withdraw(money);

            System.out.println(String.format("Withdraw %d by %s. Balance : %d %s",
                    money, Thread.currentThread().getName(), account.getBalance(), denied ? "-> DENIED": "")
            );
        }
    }
}