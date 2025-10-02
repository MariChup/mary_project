package homework;

class Programmer {
    // TODO: Создать класс Programmer с полями:
    //       - String name - имя программиста
    //       - int age - возраст программиста
    //       - boolean isHasTask - наличие активной задачи
    //       - int tiredness - уровень усталости
    //       - boolean isKnowJava - знает ли программист Java
    String name;
    int age;
    boolean isHasTask;
    int tiredness;
    boolean isKnowJava;
    // TODO: Реализовать конструктор Programmer(String name, int age, boolean isHasTask, int tiredness, boolean isKnowJava):
    //       - Инициализировать все поля переданными значениями
    Programmer(String name, int age, boolean isHasTask, int tiredness, boolean isKnowJava){
        this.name = name;
        this.age = age;
        this.isHasTask = isHasTask;
        this.tiredness = tiredness;
        this.isKnowJava = isKnowJava;
    }
    // TODO: Реализовать метод goWork():
    //       - Если у программиста есть задача, вывести сообщение "[name] работает над задачей." и увеличить tiredness на 1
    //       - Если задачи нет, вывести сообщение "[name] не имеет активных задач, и пошел ее получать" и вызвать getTask()
public void goWork(){
        if(isHasTask){
            System.out.println(name + " работает над задачей.");
            tiredness++;
        } else {
            System.out.println(name + " не имеет активных задач, и пошел ее получать");
            getTask();
        }
    }
    // TODO: Реализовать метод getTask():
    //       - Установить isHasTask в true
    public void getTask(){
        isHasTask = true;
    }

    // TODO: Реализовать метод finishTask():
    //       - Установить isHasTask в false
    // TODO: Реализовать метод goSleep():
    //       - Вывести сообщение "[name] идет спать."
    //       - Уменьшить tiredness на 1
    public void finishTask(){
        isHasTask = false;
}

public void goSleep(){
    System.out.println(name + " идет спать");
    tiredness--;
}


    void teachJava(Programmer anotherProgrammer){
        if(isKnowJava && !anotherProgrammer.isKnowJava){
            anotherProgrammer.isKnowJava = true;
            System.out.println(name + " обучил" + anotherProgrammer.name + " языку Java.");

        }else if(!isKnowJava){
            System.out.println(name + " не знает Java и не может обучить" + anotherProgrammer.name);

        }else {
            System.out.println(anotherProgrammer.name + " уже знает Java.");

        }
    }

    public static void main(String[] args) {
        Programmer nina= new Programmer("Нина", 25, true, 6, true);
        Programmer mona= new Programmer("Мона", 37, false, 3, false);
        nina.goWork();
        nina.finishTask();
        nina.goSleep();
        nina.teachJava(mona);
        mona.goWork();
        mona.getTask();
        mona.goWork();
        mona.finishTask();
        mona.goSleep();
        mona.teachJava(nina);


    }


    // TODO: Реализовать метод teachJava(Programmer anotherProgrammer):
    //       - Если текущий программист знает Java, а другой нет:
    //         - Обучить другого программиста (установить isKnowJava в true)
    //         - Вывести сообщение "[name] обучил [anotherProgrammer.name] языку Java."
    //       - Если текущий программист не знает Java, вывести "[name] не знает Java и не может обучить [anotherProgrammer.name]."
    //       - Если второй программист уже знает Java, вывести "[anotherProgrammer.name] уже знает Java."

    // TODO: Проверить отработку методов в main
    //       - Создать двух программистов с разными характеристиками
    //       - Проверить работу всех методов класса

}