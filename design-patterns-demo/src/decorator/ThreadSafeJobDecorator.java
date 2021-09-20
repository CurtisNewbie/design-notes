package decorator;

/**
 * @author yongjie.zhuang
 */
public class ThreadSafeJobDecorator implements Job {

    private final Job job;

    public ThreadSafeJobDecorator(Job job) {
        this.job = job;
    }

    @Override
    public void run(){
        synchronized (job) {
            job.run();
        }
    }

    public static Job decorate(Job job) {
        return new ThreadSafeJobDecorator(job);
    }
}
