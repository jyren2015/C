import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by RJYWORK on 2019/12/9
 * Description:生产者消费者问题，一个线程代表一个生产者或消费者
 */

class Resources{
    int in = 0;
    int out = 0;
    int[] item = new int[17];
    AtomicInteger mutex = new AtomicInteger(1);
    AtomicInteger empty = new AtomicInteger(17);
    AtomicInteger full = new AtomicInteger(0);
}

class Producer implements Runnable{
    ProducerAndConsumer producerAndConsumer;
    public Producer(ProducerAndConsumer producerAndConsumer){
        this.producerAndConsumer = producerAndConsumer;
    }

    public void Produce(){
        int i = 0;
//        int count = 0;
//        while (count < 51){
//            count ++;
//            i++;
//            while (this.producerAndConsumer.resources.empty.get() <= 0 ||
//                    this.producerAndConsumer.resources.mutex.compareAndSet(1, 0)){}
//            this.producerAndConsumer.resources.empty.getAndDecrement();
//            this.producerAndConsumer.resources.item[this.producerAndConsumer.resources.in] = i;
//            System.out.println("产品已生产" + i);
//            this.producerAndConsumer.resources.in = (this.producerAndConsumer.resources.in + 1) % 17;
//            if (this.producerAndConsumer.resources.mutex.getAndSet(1) == 0){
//                System.out.println("生产者释放锁成功");
//            }
//            this.producerAndConsumer.resources.full.getAndIncrement();
//        }
        while (true){

            i++;
            while (this.producerAndConsumer.resources.empty.get() <= 0 ||
                    this.producerAndConsumer.resources.mutex.compareAndSet(1, 0)){}
            this.producerAndConsumer.resources.empty.getAndDecrement();
            this.producerAndConsumer.resources.item[this.producerAndConsumer.resources.in] = i;
            System.out.println("产品已生产" + i);
            this.producerAndConsumer.resources.in = (this.producerAndConsumer.resources.in + 1) % 17;
            if (this.producerAndConsumer.resources.mutex.getAndSet(1) == 0){
                System.out.println("生产者释放锁成功");
            }
            this.producerAndConsumer.resources.full.getAndIncrement();
        }
    }

    @Override
    public void run() {
        this.Produce();
    }
}

class Consumer implements Runnable{
    ProducerAndConsumer producerAndConsumer;
    public Consumer(ProducerAndConsumer producerAndConsumer){
        this.producerAndConsumer = producerAndConsumer;
    }

    public void Consume(){
        while (true){
            while (this.producerAndConsumer.resources.full.get() <=0 ||
                    this.producerAndConsumer.resources.mutex.compareAndSet(1, 0)){}
            this.producerAndConsumer.resources.full.getAndDecrement();
            int production = this.producerAndConsumer.resources.item[this.producerAndConsumer.resources.out];
            System.out.println("产品已消费" + production);
            this.producerAndConsumer.resources.out = (this.producerAndConsumer.resources.out + 1) % 17;
            if (this.producerAndConsumer.resources.mutex.getAndSet(1) == 0){
                System.out.println("消费者释放锁成功");
            }
            this.producerAndConsumer.resources.empty.getAndIncrement();
        }
    }

    @Override
    public void run() {
        this.Consume();
    }
}

public class ProducerAndConsumer {
    Resources resources = new Resources();
    ExecutorService exec = Executors.newCachedThreadPool();
    Producer producer = new Producer(this);
    Consumer consumer = new Consumer(this);

    public ProducerAndConsumer(){
        exec.execute(producer);
        //exec.execute(producer);
        exec.execute(consumer);
        //exec.execute(consumer);
    }

    public static void main(String[] args){
        new ProducerAndConsumer();
    }
}
