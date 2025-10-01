package homework;

class Programmer {
    // TODO: Создать класс Programmer с полями:
    //       - String name - имя программиста
    //       - int age - возраст программиста
    //       - boolean isHasTask - наличие активной задачи
    //       - int tiredness - уровень усталости
    //       - boolean isKnowJava - знает ли программист Java

    // TODO: Реализовать конструктор Programmer(String name, int age, boolean isHasTask, int tiredness, boolean isKnowJava):
    //       - Инициализировать все поля переданными значениями

    // TODO: Реализовать метод goWork():
    //       - Если у программиста есть задача, вывести сообщение "[name] работает над задачей." и увеличить tiredness на 1
    //       - Если задачи нет, вывести сообщение "[name] не имеет активных задач, и пошел ее получать" и вызвать getTask()

    // TODO: Реализовать метод getTask():
    //       - Установить isHasTask в true

    // TODO: Реализовать метод finishTask():
    //       - Установить isHasTask в false

    // TODO: Реализовать метод goSleep():
    //       - Вывести сообщение "[name] идет спать."
    //       - Уменьшить tiredness на 1

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