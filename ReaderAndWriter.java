import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by RJYWORK on 2019/12/16
 * Description:
 */
class Resource{
    AtomicInteger rMutex = new AtomicInteger(1);
    int count = 0;
    AtomicInteger wMutex = new AtomicInteger(1);
}

class Reader implements Runnable{
    ReaderAndWriter readerAndWriter;

    public Reader(ReaderAndWriter readerAndWriter){
        this.readerAndWriter = readerAndWriter;
    }

    public void read() throws InterruptedException {
        while (true){
            while (this.readerAndWriter.resource.rMutex.compareAndSet(1, 0)){
                System.out.println("读线程对读信号量加锁中。。。");
            }
            if (this.readerAndWriter.resource.count == 0)
                while (this.readerAndWriter.resource.wMutex.compareAndSet(1, 0)){
                    System.out.println("读线程对写信号量加锁中。。。");
                }
            System.out.println("开始读操作");
            this.readerAndWriter.resource.count++;
            this.readerAndWriter.resource.rMutex.set(1);
            System.out.println("读操作" + this.readerAndWriter.resource.count);
            //Thread.sleep(10000);
            while (this.readerAndWriter.resource.rMutex.compareAndSet(1, 0)){}
            this.readerAndWriter.resource.count--;
            if (this.readerAndWriter.resource.count == 0){
                System.out.println("读操作释放写锁成功");
                this.readerAndWriter.resource.wMutex.set(1);
            }
            this.readerAndWriter.resource.rMutex.set(1);
        }
    }

    @Override
    public void run() {
        try {
            this.read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable{
    ReaderAndWriter readerAndWriter;

    public Writer(ReaderAndWriter readerAndWriter){
        this.readerAndWriter = readerAndWriter;
    }

    public void write(){
        while (true){
            while (this.readerAndWriter.resource.wMutex.compareAndSet(1, 0)){
                System.out.println("写线程对写信号量加锁中。。。。。。。。。。。。");
            }
            System.out.println("写操作" + this.readerAndWriter.resource.count);
            System.out.println("写操作释放写锁成功");
            this.readerAndWriter.resource.wMutex.set(1);
        }
    }

    @Override
    public void run() {
        this.write();
    }


}

public class ReaderAndWriter {
    Resource resource = new Resource();
    ExecutorService exec = Executors.newCachedThreadPool();
    Reader reader = new Reader(this);
    Writer writer = new Writer(this);

    public ReaderAndWriter(){
        exec.execute(reader);
        exec.execute(reader);
        exec.execute(writer);
    }

    public static void main(String[] args){
        ReaderAndWriter readerAndWriter = new  ReaderAndWriter();

    }
}
