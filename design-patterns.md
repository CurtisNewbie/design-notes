# Design Patterns

- Creational Patterns 创建型模式

    - [Singleton 单例](#1-singleton)
        - 懒汉式单例 (lazy)
        - 饿汉式单例 (eager)
    - [Prototype 原型](#2-prototype)
    - [Factory Method 工厂方法](#3-factory-method)
    - [Abstract Factory 抽象工厂](#4-abstract-factory)
    - [Builder 建造者](#5-builder)

- Structural Patterns 结构型模式

    - [Proxy 代理](#6-proxy)
    - [Adapter 适配器](#7-adapter)
    - [Bridge 桥接](#8-bridge)
    - [Decorator 装饰](#9-decorator)
    - [Facade 外观](#10-facade)
    - [Flyweight 享元](#11-flyweight)
    - [Composite 组合](#12-composite)

- Behavioral Patterns 行为型模式

    - [Template 模板](#13-template-method)
    - [Strategy 策略](#14-strategy)
    - [Command 命令](#15-command)
    - [Chain of Responsibility 职责链](#16-chain-of-responsibility)
    - [State 状态](#17-state)
    - [Observer 观察者](#18-observer)
    - [Mediator 中介者](#19-mediator)
    - [Iterator 迭代器](#20-iterator)
    - [Visitor 访问者](#21-visitor)
    - [Memento 备忘录](#22-memento)
    - [Interpreter 解释器](#23-interpreter)

# Creational Design Patterns

## 1. Singleton

Lazy Instantiation. 

```
private static LazySingleton instance = null;

public static synchronized LazySingleton getInstance() {
    if (instance == null)
        instance = new LazySingleton();
    return instance;
}
```

Eager Instantiation. 

```
public enum EagerSingleton {

    INSTANCE; // this is the singleton instance

    EagerSingleton() {

    }
}
```

## 2. Prototype

Use an existing object as a 'prototype' and create new copy of it. E.g., using `Object.clone()`. Just don't use `Object.clone()`, for reasons below:

- It requires objects to implement marker interface `Cloneable` which is merely a maker that specifies no methods. Without this mark interface, `Object.clone()` throws `CloneNotSupportedException`.
- `Object.clone()` is implemented by the JVM, which doesn't invoke constructor, so we loss control over the object construction.
- If we mark or write a `clone` method for a child class, then all its superclasses must be `Cloneable` as well else the `super.clone()` chain will fail.
- `Object.clone()` is only shallow copying.

## 3. Factory Method

Define an interface or abstract class for creating an object, but the implementation is determined by subclasses.

E.g., we create an abstract class `TomFactory` that defines the method signature for getting a `Tom`. 

```
public abstract class TomFactory {

    private static final TomFactory tomFactory = new ConcreteTomFactory();

    public abstract Tom getTom(TomType type);

    public static TomFactory getSingleton() {
        return tomFactory;
    }

    private static class ConcreteTomFactory extends TomFactory {

        @Override
        public Tom getTom(TomType type) {
            return type.getProvider().provide();
        }
    }
}
```

The implementation details are hidden by the factory, the user of this class only need to know the `TomType`. For better extensibility, we can move the actual implementation to `TomType`, such that when we want to add a new `TomType` and its implementation, the factory is not modified as well (Open/Close Principle).

```
public enum TomType {

    TALLER_TOM(new TallerTomProvider()),
    SHORTER_TOM(new ShorterTomProvider());

}
```

With this pattern, the clients of this set of API will not notice much difference when the internal implementation changes:

```
TomFactory tomFactory = TomFactory.getSingleton();
Tom shorterTom = tomFactory.getTom(TomType.SHORTER_TOM);
Tom tallerTom = tomFactory.getTom(TomType.TALLER_TOM);
```

If we are to add a new type of Tom, we add a new enum value. If we want to change the implementation for, e.g., TALLER_TOM, we just change the object provider inside `TomType`. No code change is needed in the client's code base.

## 4. Abstract Factory 

Define an interface or abstract class for creating a category of objects, the implementation is grouped by categories and provided by different subclasses of the factory. 

E.g., having an interface that defines how to create various buttons, and then create two concrete classes (concrete factories) of this interface, that provides different implementation for Windows and Linux. Then, we can determine which concrete implementation of the abstract factory to use on startup.

Example:

Create an interface as the abstract factory: 

```
public interface ComponentFactory {

    Button getButton(ButtonType t);

    Icon getIcon(IconType t);

}
```

Then create concrete factory for this interface, e.g., one for linux and one for windows.

```
public class LinuxComponentFactory implements ComponentFactory {

    @Override
    public Button getButton(ButtonType t) {
        return new LinuxButton();
    }

    @Override
    public Icon getIcon(IconType t) {
        return new LinuxIcon();
    }
}
```

```
public class WindowsComponentFactory implements ComponentFactory {

    @Override
    public Button getButton(ButtonType t) {
        return new WinButton();
    }

    @Override
    public Icon getIcon(IconType t) {
        return new WinIcon();
    }
}
```

These 'components' or implementation are grouped together, we can easily change group of implementation by changing the concrete factory.

```
ComponentFactory factory;
String os = System.getProperty("os.name");
if (os.toLowerCase().contains("linux")) {
    factory = new LinuxComponentFactory();
} else {
    factory = new WindowsComponentFactory();
}

factory.getButton(ButtonType.BIG);
factory.getIcon(IconType.ROUNDED);
```

## 5. Builder

Builder pattern is used to construct a complex object using step-by-step approach, the builder may simplify the construction by providing some convenient methods. The major difference between builder and factory method, is that the factory method focuses on creating subclass objects in one single step, it's more like a wrapper of the constructor. While the builder provides finer granularity, the composition of objects or properties might differ within same subclass.

Notice that this pattern has nothing to do with the method chaining or the fluent API. It's all about building complex object that has lots of variants.

# Structural Design Patterns

## 6. Proxy

A proxy provides control for accessing the original object. It may be used to hide the fact that we are calling a remote service. The decorator pattern can be considered as a special kind of proxy, called **Smart Proxy**. A proxy normally doesn't add responsibilities to the target object, it may simply send a remote method invocation on behave of the caller, or it may intercept the method calls if necessary.

## 7. Adapter

Adapter is used to provide compatibility between two independent objects. It may also hide details to use target bean.

For example, `Car` class has no knowledge on how to use the `BrakeController`, these two classes are incompatible, but the adapter handles it. If we want to add a new implementation of `BrakeController`, we simply add a new `BrakeAdapter` for it. With adapter, code becomes quite open for extension.

```
public class Car {

    private BrakeController brakeController;
    private List<BrakeAdapter> brakeAdapters = Arrays.asList(
            new ElectricalBrakeControllerAdapter(),
            new MechanicalBrakeControllerAdapter()
    );

    public void brake() {
        for (BrakeAdapter adapter : brakeAdapters)
            if (adapter.support(brakeController.getClass()))
                adapter.brake(brakeController);
    }
}
```

## 8. Bridge 

Bridge pattern is used to decouple abstraction from implementation, allowing them to change independently. The abstraction layer is free to change as well as the implementation layer. Essentially, the *bridge* is the interface or the abstraction layer we added.

E.g., we have an interface `BrakeDevice`, and we have some concrete class that extends `AbstractVehicle`, we are free to provide different implementation for the `BrakeDevice`, and we can extends the `AbstractVehicle` by add extra functionalities before or after the use of `BrakeDevice`, we may also decide not to use the `BrakeDevice` as well. The `BrakeDevice` is the bridge interface. The `AbstractVehicle` is the abstraction and the concrete subclasses of `BrakeDevice` are the implementation.

```
public abstract class AbstractVehicle {

    protected final BrakeDevice brakeDevice;

    public AbstractVehicle(BrakeDevice brake) {
        this.brakeDevice = brake;
    }

    abstract void brake();
}
```
## 9. Decorator 

Decorator is similar to Proxy, it adds responsibilities to an object in runtime. For example, we create a decorator to make an object thread-safe.

```
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
```

## 10. Facade

Facade pattern defines a higher-level that makes sub-systems easier to use. This pattern demonstrates **Least Knowledge Principle**. 

## 11. Flyweight

Flyweight pattern caches existing objects to provide performance and reduce memory usage.

## 12. Composite

Composite pattern allows clients to operate in generic manner on objects that may or may not represent a hierarchy of objects. For example, an `ShoppingCart` object can be considered as a composite, and `Good` is merely an interface, the subclasses instances are the actual items bought, but we don't care whether they represent a hierarchy of objects, as long as we define methods like `getTotalPrice()` on `Good` interface.

# Behavioral Patterns

## 13. Template Method

Template method design pattern is used when we know the steps or procedures needed for an operation, and then the actual implementation details can be put in to the subclasses. Template method design pattern uses **inheritance**.

E.g., we define four abstract template methods for a video recording operation, which must be implemented by the subclasses. The subclasses may simply represent different devices or platform, e.g., `MobilePhoneVideoRecording` or `DesktopVideoRecording`. Then we define a `record()` method that calls these template methods as if we are already know the procedures beforehand.

```
public abstract class VideoRecordingTemplate {

    public final void record() throws IOException {
        byte[] bytes;
        while (hasNextChunk()) {
            bytes = recordChunk();
            if (hasEnoughSpace(bytes.length)) {
                saveChunk(bytes);
            } else {
                throw new IOException("Not enough space");
            }
        }
    }

    abstract boolean hasEnoughSpace(long chunkSize);

    abstract void saveChunk(byte[] bytes);

    abstract byte[] recordChunk();

    abstract boolean hasNextChunk();
}
```

## 14. Strategy

Strategy pattern identifies a group of functionalities and makes them interchangeable. The way it works is to define a generic **interface** for the group of functionalities, and applies one of the implementation based on requirements.

## 15. Command 

Command pattern encapsulates a request/action in an object as a **command** and passes it to the an object called **invoker**, which is then responsible for invoking the command. This decouples command publisher and command invoker. As the request is encapsulated in an object, we can add a new command by applying inheritance or composition on the **command** object, and we don't need to change the invoker.

e.g., 

```
ImageComponent component = new ImageComponent();
component.setOnClick(new EchoCommand("ImageComponent clicked"));
component.setOnFocus(new EchoCommand("ImageComponent focused"));
component.click();
component.focus();
```

## 16. Chain of Responsibility

Chain of responsibility pattern suggests that we should avoid coupling the sender and receiver by giving multiple handler a chance to handle the request, if a handler cannot handle the request, it simply passes the request to the next handler.

e.g., create a chain of loggers for messages, one may log INFO level message to a local file, and another may log ERROR level message on the console.

```
public class LoggerChain {

    private int next = 0;
    private List<Logger> logger = Arrays.asList(new InfoLogger(), new ErrorLogger(), new DebugLogger());

    void doNext(Message message) {
        if (next < logger.size())
            logger.get(next++).log(message, this);
    }
}

public class InfoLogger implements Logger {

    @Override
    public void log(Message message, LoggerChain chain) {
        if (Message.MessageLevel.INFO == message.getLevel())
            System.out.println("INFO - " + message.getMsg());
        chain.doNext(message);
    }
}
```

## 17. State

State pattern defines that the class behavior should change based on its states. We create a `Context` class that carries the state, and we create one or more `State` object representing various states, and the behavior for each state is also encapsulated in the `State` object. So, when we change state, the behavior is automatically changed without a redundant if, else-if statements.

e.g., 

```
public class PersonContext {

    private State state = new NormalState();

    void say() {
        state.say();
    }

    void setState(State state) {
        this.state = state;
    }
}
```

## 18. Observer

Observer pattern is used when one or more objects need to be notified when a subject changes.

e.g., 

```
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
```

## 19. Mediator

Mediator pattern provides a mediator class which handles all the communications between different classes. I.e., the mediator encapsulates how a set of objects interact. E.g., Controller in MVC is the mediator. 

e.g., we create a `Room` object as the mediator, then for each `User` object, it only maintains an one-to-one relation with the `Room` object, rather than one-to-many relation with other `User`s.

```
public class Room {

    private Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public void broadcast(String msg) {
        for (User u : userMap.values()) {
            u.getSession().sendMessage(msg);
        }
    }

    public void sendTo(String name, String msg) {
        User user = userMap.get(name);
        if (user != null) {
            user.getSession().sendMessage(msg);
        }
    }
}
```

## 20. Iterator

Iterator pattern defines a way to access the elements in a collection in a sequential manner without the need to understand its internal data structure. For example, JDK defines an interface `Iterable` that requires the implementation to provide a `Iterator`, and then we can use the `Iterator` to iterate the elements. 

## 21. Visitor

Visitor pattern helps define a new operation without modifying existing object structure. It's good for extension when the object structure doesn't change. However, when the object structure changes, all visitors will need to change.

E.g., we have a document that contains `Element`, which may be `TextElement` or `ImgElement`.

```
public class Document {

    private List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return elements;
    }

    public void addElement(Element ele) {
        this.elements.add(ele);
    }

    void accept(ElementVisitor visitor) {
        for (Element e : elements) {
            visitor.visit(e);
        }
    }
}
```

We define a method `accept(ElementVisitor)`, in which we expose the internal data structure to the visitor, such that visitor can perform some sort of operation of it. For example, we may write a visitor that logs all the elements found.

```
public class ConsoleLogElementVisitor implements ElementVisitor {

    @Override
    public void visit(Element element) {
        System.out.println(element.toString());
    }
}
```

If we want to add extra operation, such as, extracting all images, we can write a new visitor, and the `Document` and `Element` classes don't need to change.

## 22. Memento

Memento pattern is used to restore the previous state of an object. There are three types of objects, `Memento` objects that represent/contain the states of an object; `Originator` objects that create states and store them in `Memento` objects; and `CareTaker` objects that preserve the `Memento` objects.

## 23. Interpreter

Interpreter pattern provides a way to evaluate language grammar or expression, it aims for greater flexibility.
