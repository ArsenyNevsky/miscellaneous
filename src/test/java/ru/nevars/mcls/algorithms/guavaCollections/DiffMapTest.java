package ru.nevars.mcls.algorithms.guavaCollections;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiffMapTest {

    private DiffMap dm = new DiffMap();
    private List<Student> listMathStudents;
    private List<Student> listPhylosophyStudents;

    @Before
    public void setUp() throws Exception {
        listMathStudents = getMathStudents();
        listPhylosophyStudents = getPhylosophyStudents();
        dm = new DiffMap(listMathStudents, listPhylosophyStudents);

    }

    private List<Student> getPhylosophyStudents() {
        List<Student> listMathStudents = new ArrayList<>();
        listMathStudents.add(new Student(1, "Arseny"));
        listMathStudents.add(new Student(2, "Timur"));
        listMathStudents.add(new Student(3, "Katya"));
        listMathStudents.add(new Student(4, "Sergey"));
        listMathStudents.add(new Student(5, "Irina"));

        return listMathStudents;
    }

    private List<Student> getMathStudents() {
        List<Student> listPhylosophyStudents = new ArrayList<>();
        listPhylosophyStudents.add(new Student(3, "Katya"));
        listPhylosophyStudents.add(new Student(4, "Radik"));
        listPhylosophyStudents.add(new Student(5, "Valya"));
        listPhylosophyStudents.add(new Student(6, "Aleksandr"));
        listPhylosophyStudents.add(new Student(7, "Ariana"));
        listPhylosophyStudents.add(new Student(8, "Anna"));

        return listPhylosophyStudents;
    }

    @Test
    public void testIntersection() throws Exception {
        MapDifference<Integer, Student> intersectionMap = Maps.difference(dm.getMathStudents(), dm.getPhilosophyStudents());
        Map<Integer, Student> intersection = intersectionMap.entriesInCommon();
        assertTrue(intersectionMap != null);
        assertFalse(intersection == null);
        System.out.println(intersection);
    }

    @Test
    public void testDifferStudents() throws Exception {
        MapDifference<Integer, Student> differMap = Maps.difference(dm.getMathStudents(), dm.getPhilosophyStudents());
        Map<Integer, MapDifference.ValueDifference<Student>> integerValueDifferenceMap = differMap.entriesDiffering();

        System.out.println(integerValueDifferenceMap);
    }

    @Test
    public void testLeftSubset() throws Exception {
        MapDifference<Integer, Student> differMap = Maps.difference(dm.getMathStudents(), dm.getPhilosophyStudents());
        Map<Integer, Student> leftSubset = differMap.entriesOnlyOnLeft();

        System.out.println(leftSubset);
    }
}