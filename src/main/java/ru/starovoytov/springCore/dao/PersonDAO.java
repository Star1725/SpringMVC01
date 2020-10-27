package ru.starovoytov.springCore.dao;

import org.springframework.stereotype.Component;
import ru.starovoytov.springCore.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int peopleCount;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount, "Tom"));
        people.add(new Person(++peopleCount, "Jack"));
        people.add(new Person(++peopleCount, "Garry"));
        people.add(new Person(++peopleCount, "Katy"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        //filter - отфильтруем person, где person.getId() == id
        //findAny().orElse(null) - найдём его, а если нет, вернём null
    }
}
