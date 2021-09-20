package observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yongjie.zhuang
 */
public class Subject<T> {

    private List<Observer<T>> observers = new LinkedList<>();
    private T t;

    public void setT(T t) {
        this.t = t;
        notifyAllObserver();
    }

    void attach(Observer<T> observer) {
        observers.add(observer);
    }

    void notifyAllObserver() {
        for (Observer obs : observers) {
            obs.notifyChange(t);
        }
    }
}
