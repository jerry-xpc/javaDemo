package com.java.javaSE.thread;

/*
*
 * 第一种实现多线程的时候：
 *      1、需要集成Thread类;
 *      2、必须要重写run方法，指的是核心执行逻辑;
 *      3、线程在启动的时候，不要直接调用run方法，而是要通过start();
 *      4、每次运行相同代码，出来的结果可能不一样，原因在于多线程谁先抢占资源无法进行人为控制;
 * 第二种实现方式：
 *      1、实现Runnable接口;
 *      2、重写run方法;
 *      3、创建Thread对象，将刚刚创建好的runnable的子类实现作为thread的构造参数;
 *      4、通过thread.start()进行启动;
 * 两种实现方式那种好：
 *      1、推荐使用第二种，接口实现，java是单继承，将继承关系给最重要的类;
 *      2、使用runnable接口之后不需要给共享变量添加static关键字，每次创建一个对象，作为共享对象即可;
 * 线程的生命周期：
 *      1、新生状态：当创建好当前线程对象之后，没有启动之前（调用start方法之前）
 *          ThreadDemo threadDemo = new ThreadDemo();
 *          TicketRunnableDemo ticketRunnableDemo = new TicketRunnableDemo();
 *      2、就绪状态：准备开始执行，并没有执行，表示调用start()方法之后，当对应的线程创建完成，且调用start()方法后，所有的线程会添加到一个
 *      就绪队列中，所有的线程会同时去抢占CUP的资源;
 *      3、运行状态：当当前进程取到CPU资源后，就绪队列中的所有线程会去抢占CPU的资源，谁先抢到谁先执行，在执行的过程中叫做运行状态，
 *      抢占到CPU资源，执行代码逻辑开始;
 *      4、死亡状态：当运行中的线程正常执行完所有的代码逻辑或者因为异常情况导致程序结束叫做死亡状态;
 *          进入死亡状态方式：
 *              （1）正常运行完成且结束;
 *              （2）人为中断执行，比如使用stop()方法;
 *              （3）程序抛出未捕获的异常;
 *      5、阻塞状态：在程序运行过程中，发生某些异常情况，导致当前线程无法再顺利执行下去，此时进入阻塞状态，进入阻塞状态的原因消除之后，所有的
 *      阻塞队列会再次进入就绪状态中，随机抢占CPU的资源，等待执行;
 *          进入阻塞状态方式：
 *              （1）sleep()方法;
 *              （2）等待io资源;
 *              （3）join()方法，代码执行的逻辑;
 *              （4）yield()方法，当前正在执行的线程暂停一次，允许其他线程执行，不阻塞，线程进入就绪状态，如果没有其他等待的线程，
 *              这个时候就会立马恢复执行;
 * 需要掌握的常用方法：
 *      1、currentThread()，返回目前正在执行的线程;
 *      2、getName()，返回线程的名称;
 *      3、getPriority()，返回线程的优先级;
 *      4、setPriority(String name)，设定线程名称;
 *      5、isAlive()，判断线程是否在活动，如果是返回true，否则返回false;
 *      6、join()，调用该方法的线程强制执行，其他线程处于阻塞状态，该线程执行完毕后，其他线程再执行;
 *      7、sleep(long millis)，使当前正在执行的线程进入休眠millis秒，线程处于阻塞状态，不会释放锁，sleep时别的线程也不可以访问锁定对象;
 *      8、yield()，当前正在执行的线程暂停一次，允许其他线程执行，不阻塞，线程进入就绪状态，如果没有其他等待的线程，这个时候就会立马恢复执行,
 *      让出CPU使用权，从运行状态直接进入就绪状态，让CPU重新挑选哪一个线程进入运行状态;
 *      9、stop()，强迫线程停止执行，已过时，不推荐使用;
 *      10、notify()，唤醒线程，当线程使用wait()进入暂停延缓时需要通过此进行唤醒,在其他线程调用notify之前等等阻塞。
 *      11、wait()，暂停延缓线程，会将资源给其他线程使用，需要使用notify()唤醒
 *多线程并发的时候会出现数据安全问题：
 *  解决方式：
 *      1、同步代码块：
 *          synchronized(共享资源、共享对象，需要是object的子类)
 *          {
 *              具体执行代码块
 *          }
 *     2、同步方法：将核心的代码逻辑定义成一个方法，使用synchronized关键字定义修饰，此时不需要指定公共对象
 *线程池：
 *     在实际使用中，线程很占用系统的资源，如果对线程管理不善很容易导致系统问题。因此在大多数时候会使用线程池来管理线程，使用线程池有如下好处：
 *     1、使用线程池可以重复利用已有的线程继续执行任务，避免线程在创建和销毁时造成的消耗
 *     2、由于没有线程创建和销毁时的消耗，可以提高系统响应速度
 *     3、通过线程池可以对线程合理管理，根据系统的承受能力调整可运行线程数量的大小等
 *     线程池执行所提交的任务的过程：
 *     1、先判断线程池中核心线程池所有的线程是否都在执行任务。如果不是则新建一个线程执行刚提交的任务，否则核心线程池所有的线程都在执行任务则进入2步
 *     2、判断当前线程队列是否已满，如果未满，则将刚提交的任务放在阻塞队列中；否则进入第三步
 *     3、判断线程池中所有的线程是否都在执行任务，如果没有则创建一个新的线程来执行任务，否则就交给饱和策略进行处理
 *     四种普通线程池：ThreadPoolExecutor
 *     1、newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 *     2、newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 *     3、newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 *     4、newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 *     两种定时器线程池：ScheduleThreadPoolExecutor
 *     1、ScheduledThreadpool创建一个延时或者定时任务线程
 *     2、SingleThreadScheduledExecutor只会有一个线程，不管你提交多少任务，这些任务会顺序执行，如果发生异常会取消下面的任务，线程池也不会关闭，注意捕捉异常
 *     分而治之线程池：ForkJoinPool
 *     1、newWorkStealingPool适合使用在很耗时的操作，但是newWorkStealingPool不是ThreadPoolExecutor的扩展，
 *     它是新的线程池类ForkJoinPool的扩展，但是都是在统一的一个Executors类中实现，由于能够合理的使用CPU进行对任务操作（并行操作）,
 *     创建一个并行线程池、并行级别决定了同一时刻有多少线程在执行，如果不传入并行级别参数，将默认当前系统的CPU个数
 *线程池的生命周期：
 *     1、RUNNING：能接受新提交的任务，并且也能处理阻塞队列中的任务
 *     2、SHUTDOWN：关闭状态，不能接受新提交的任务，但却可以继续处理阻塞队列中已保存的任务
 *     3、STOP：不能接受新任务，也不处理队列中的任务，会中断正在处理任务的线程
 *     4、TIDYING：如果所有的任务都终止了，workerCount（有效线程数）为0，线程池进入该状态后会调用terminated()方法进入TERMINATED状态
 *     5、TERMINATED：在terminated()方法执行完成后进入该状态，默认terminated()方法中什么也没有做。
 *
 *ArrayBlockingQueue与LinkedBlockingQueue区别：
 *  1、队列中锁的实现不同
 *      ArrayBlockingQueue实现的队列中的锁是没有分离的，即生产和消费都是同一个锁；
 *      LinkedBlockingQueue实现的队列中的锁是分离的，即生产是用的putLock，消费用的是tackLock；
 *  2、队列的大小初始化不同
 *     ArrayBlockingQueue实现的队列中必须指定队列的大小；
 *     LinkedBlockingQueue实现的队列中可以不指定队列的大小，但默认值是Interger.MAX_VALUE；
 *
 * 拒绝策略：
 *   1、ThreadPoolExecutor.AbortPolicy：丢弃任务并抛出RejectedExecutionException异常
 *   2、ThreadPoolExecutor.DiscardPolicy:丢弃任务但不抛出异常
 *   3、ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
 *   4、ThreadPoolExecutor.CallerRunsPolicy:由调用线程处理该任务
 *
 * 线程execute执行逻辑：
 *  1、如果当前运行的线程，少于corePoolSize，则创建一个新的线程来执行任务。
 *  2、如果运行的线程等于或多于 corePoolSize，将任务加入 BlockingQueue。
 *  3、如果加入 BlockingQueue 成功，需要二次检查线程池的状态如果线程池没有处于 Running，则从 BlockingQueue 移除任务，启动拒绝策略。
 *  4、如果线程池处于 Running状态，则检查工作线程（worker）是否为0。如果为0，则创建新的线程来处理任务。如果启动线程数大于maximumPoolSize，任务将被拒绝策略拒绝。
 *  5、如果加入 BlockingQueue 。失败,则创建新的线程来处理任务。
 *  6、如果启动线程数大于maximumPoolSize，任务将被拒绝策略拒绝。
 *
 * 线程池的关闭：可以通过shutdown和shutdownNow两个方法
 *  原理：遍历线程池中的所有线程，然后依次中断
 *  1、shutdownNow首先将线程池的状态设置为STOP，然后尝试停止所有的正在执行和未执行任务的线程，并返回等待执行任务的列表
 *  2、shutdown只是将线程池的状态设置为SHUTDOW状态，然后中断所有没有正在执行任务的线程
 *
 * 注意：在多线程的时候，可以实现唤醒和等待过程，但是唤醒和等待操作不是对呀thread类，而是我们设置的共享对象或者共享变量
 *
 */
public class ThreadDemo extends Thread
{
    @Override
    public void run()
    {
        for (int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+"======================="+i);
        }
    }

    public static void main(String[] args)
    {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        for (int i=0;i<5;i++)
        {
            System.out.println(Thread.currentThread().getName()+"---------------------"+i);
        }
    }
}
