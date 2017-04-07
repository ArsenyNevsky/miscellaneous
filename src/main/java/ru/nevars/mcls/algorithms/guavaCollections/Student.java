package ru.nevars.mcls.algorithms.guavaCollections;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {

    public Student(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

   /* @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student that = (Student) obj;
        return this.getId() == that.getId();
    }*/

    private int id;
    private String firstname;

}
