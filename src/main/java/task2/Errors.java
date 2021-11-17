package task2;
interface Moveable {
    void move();
}

interface Stopable {
    void stop();
}

abstract class Car {
    public Engine engine;
    private String color;
    private String name;


    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car implements Moveable{

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}

class Lorry extends Car, Moveable, Stopable{

    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }
}

//***********************************************************************
//Ошибки

//1. Нет объявления класса Engine
class Engine{
    //...
}

//2. В классе Lorry не определен метод void open()
class Lorry extends Car, Moveable, Stopable{
    //...
    @Override
    void open() {
        System.out.println("Car is open");
    }
}

//3. Интерфейсы должны реализовываться через implements
class Lorry extends Car implements  Moveable, Stopable{
    //...
}

//4. Хорошо бы добавить @Override над реализацией методов в классе Lorry,
// хотя это не считается ошибкой, а больше правило хорошего тона.

//***********************************************************************
//Преложения по оптимизации
//1. Использовать интерфейс для двигателя, а от него создавать конкретные типы двигателей
interface IEngine{
    public void stopEngine();
    public void startEngine();
}

class ElectricEngine implements IEngine{
    //...
}

class CombustionEngine implements Engine{
    //...
}






