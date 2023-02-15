/*
package org.example;


public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Murzik", "black", 11);  // обьект кота
        System.out.println(cat.voice());
        System.out.println(cat);            //при вызове ишет toString
    }
}

class Cat {
    private String name; //поля. они хранят состояния класса
    private String color;  //абстракция состоит в том что у нас есть те поля
    private int age;        // которые нужны для конкретной задачи и метод который реализует
                            // эту задачу

    Cat(String name, String color, int age) {  //конструкторы, спец.метод
        this.name = name;                      //данный конструктор перегруженный
        this.color = color;
        this.age = age;
    }

    String voice() {                              //метод
        return "meow";                             //методы определяют поведение класса
    }

    @Override
    public String toString() {                    //переопределенный метод
        return name + ", " + color + ", " + age;
    }
}
*/

package org.example;

public class Main {
    public static void main(String[] args) {
        IAnimal[] animals = {
                new Cat("Murzik", "black", 11),
                new Dog("Zubastik", "black", 5)
        };
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.voice());   //это полиморфизм(через один и тот же интерфейс мы получаем доступ к разным реализациям (voice)
            // позднее связывание - в момент реализации соответствуюший интерфейс связывается с нужной реализайией в последний момент
        }
        //Cat cat = new Cat("Murzik", "black", 11);  // обьект кота
        //Dog dog = new Dog("Zubastik", "black", 5);  // обьект кота
//        System.out.println(cat);        //при вызове ишет toString
//        System.out.println(cat.voice());
//        System.out.println(dog);
//        System.out.println(dog.voice());

        //у Cat и Dog есть общий тип Animal, поэтому их можно поместить в массив

        /*Animal a = new Animal(null, null, 0);// на основе абстрактных классов обьект создавать нельзя*/
    }
}

class Cat extends Animal {          // extends и имя класса предка
    // наследование это такое взаимоотноение между двумя классами при котором один класс будет предком а второй потомком
    Cat(String name, String color, int age) {  // потомок получает от предка все что есть у него. и потомка можно расширять поля и методы
        super(name, color, age);                        //super вызывает конструктор предка
    }

    @Override
    public String voice() {
        return "meow";
    }
}

class Dog extends Animal {                  //множествееное наследование невозможно поэтому после extends только один класс
    Dog(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String voice() {
        return "gaf-gaf";
    }
}

interface IAnimal {                                     //можно наследовать несколько интерфейсов
    String voice();
}
                                                       // implements IAnimal для взаимосвязывания
abstract class Animal implements IAnimal {             //наследуются все поля и  методы кроме помеченных модификаторов private
    protected String name; //поля. они хранят состояния класса
    protected String color;  //абстракция состоит в том что у нас есть те поля
    protected int age;        // которые нужны для конкретной задачи и метод который реализует
    // эту задачу

    Animal(String name, String color, int age) {  //конструкторы, спец.метод
        this.name = name;                      //данный конструктор перегруженный
        this.color = color;
        this.age = age;
    }
/*
    String voice() {                              //метод
        return "unknown";                             //методы определяют поведение класса
    }

 */
    /* класс может быть абстрактным, но при этом он может не иметь абстрактные методы.
    Но если у класса есть хотя бы один абстрактный метод, этот класс вынужденный быть абстрактным
    поэтому у нас и класс метод войс абстарктный

    если предок абстрактный то потомок мб любым
    */

    //abstract String voice();            //такой вариант метода из за того что unknown не правильно писать. также сократили код
    // после реализации интерфейса abstract не нужен
    @Override
    public String toString() {                    //переопределенный метод
        return name + ", " + color + ", " + age;
    }
}

/*
полиморфизм это возможность получить доступ к разным реализациям через один и тот же интерфейс
*/

    /*
интерфейс это идеальный абстрактный класс. а абс.класс который содержит только абстрактные методы и больше ничего
     */