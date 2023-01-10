package Theread;

public class        ThreadExample1 {
    public static void main(String[] args) {
//
//        Runnable task1 = new ThreadTask1();
//
//        Thread thread1 = new Thread(task1);

        // 익명 Runnable 구현 객체를 활용

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i =0; i <100; i++){
//                    System.out.print("#");
//                }
                System.out.println(Thread.currentThread().getName());
            }
        });

        // 위에 코드 축약!
//        Thread thread1 = new Thread(new Theread.ThreadTask1());

        thread1.start();
        System.out.println(Thread.currentThread().getName());


//        for (int i =0; i < 100; i++){
//            System.out.print("@");
//        }




    }
}

//class ThreadTask1 implements Runnable {
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.print("#");
//        }
//    }
//}