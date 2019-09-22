package _WorkingwithThreadsinTestNG;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.testng.annotations.Test;
public class ThreadExecutorServiceDemo {
    private static final String ERROR_MSG = "From thread you asked me throw an exception";
    @Test
    public void testUsingExecutorService() throws InterruptedException, ExecutionException {
        MyCallableService service = new MyCallableService(false);
        Future<String> returnValue = Executors.newSingleThreadScheduledExecutor().submit(service);
        System.out.println(returnValue.get());
    }
    @Test(expectedExceptions = ExecutionException.class, expectedExceptionsMessageRegExp = ".*" + ERROR_MSG + ".*")
    public void testUsingExecutorServiceWithException() throws InterruptedException, ExecutionException {
        MyCallableService anotherService = new MyCallableService(true);
        Future<String> anotherReturnValue = Executors.newSingleThreadScheduledExecutor().submit(anotherService);
        System.out.println(anotherReturnValue.get());
    }
    @Test
    public void testUsingThreads() throws InterruptedException {
        MyThreadService mt = new MyThreadService(false);
        mt.start();
        while (mt.isAlive() == true) {
            Thread.sleep(10000);
        }
        System.out.println(mt.getServiceName());
    }
    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = ERROR_MSG)
    public void testUsingThreadsWithExceptions() throws InterruptedException {
        MyThreadService mt = new MyThreadService(true);
        mt.start();
        while (mt.isAlive() == true) {
            Thread.sleep(10000);
        }
        System.out.println(mt.getServiceName());
    }
    public class MyThreadService extends Thread {
        private boolean throwException;
        private String serviceName;
        public String getServiceName() {
            return serviceName;
        }
       public MyThreadService(boolean throwException) {
            this.throwException = throwException;
        }
        public void run() {
            try {
                sleep(25000);
                this.serviceName = "TestNG threaded Service";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (throwException) {
                throw new RuntimeException(ERROR_MSG);
            }
        }
    }
    public class MyCallableService implements Callable<String> {
        private boolean throwException;
        public MyCallableService(boolean throwException) {
            this.throwException = throwException;
        }
        @Override
        public String call() throws Exception {
            Thread.sleep(25000);
            if (throwException) {
                throw new RuntimeException(ERROR_MSG);
            }
            return "Callable Service Invoked";
        }
    }
}