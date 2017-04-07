package ru.nevars.mcls.algorithms.guavaCollections;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DiffMap {

    private Map<Integer, Student> mathStudents;
    private Map<Integer, Student> philosophyStudents;


    public DiffMap() {}

    public DiffMap(List<Student> mathStd, List<Student> philosophyStd) {
        mathStudents = Maps.uniqueIndex(mathStd, Student::getId);
        philosophyStudents = Maps.uniqueIndex(philosophyStd, Student::getId);
    }
}
