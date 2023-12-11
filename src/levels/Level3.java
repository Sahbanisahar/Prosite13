package levels;

import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule séparés par # */
        String names = teachers.stream()
                .map(Teacher::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining("#"));
        System.out.println("Noms des enseignants en majuscule séparés par # : " + names);

        /* TO DO 2: Retourner un set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> javaTeachers = teachers.stream()
                .filter(teacher -> teacher.getSubject().equalsIgnoreCase("Java") && teacher.getSalary() > 80000)
                .collect(Collectors.toSet());
        System.out.println("Enseignants Java dont le salaire > 80000 : " + javaTeachers);

        /* TO DO 3: Retourner un TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> sortedTeachers = teachers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Teacher::getName)
                        .thenComparing(Teacher::getSalary))));
        System.out.println("TreeSet d'enseignants trié par nom et salaire : " + sortedTeachers);

        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<String, List<Teacher>> teachersByModule = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSubject));
        System.out.println("Map regroupant les enseignants par module : " + teachersByModule);

        /* TO DO 5: Retourner une Map qui regroupe les noms des enseignants par salaire */
        Map<Integer, String> namesBySalary = teachers.stream()
                .collect(Collectors.groupingBy(Teacher::getSalary,
                        Collectors.mapping(Teacher::getName, Collectors.joining(", "))));
        System.out.println("Map regroupant les noms des enseignants par salaire : " + namesBySalary);

        /* TO DO 6: Afficher les noms des enseignants de chaque module */
        System.out.println("\nNoms des enseignants de chaque module :");
        teachersByModule.forEach((module, teacherList) ->
                System.out.println("Module : " + module + ", Noms : " + teacherList.stream()
                        .map(Teacher::getName)
                        .collect(Collectors.joining(", "))));
    }
}

