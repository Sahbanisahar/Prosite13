package levels;

import models.Teacher;
import utils.Data;

import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */

        System.out.println("Liste des enseignants :");
        for (Teacher teacher : teachers) {
            System.out.println("Nom : " + teacher.getName() + ", Matière : " + teacher.getSubject());
            


        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */

    System.out.println("\nListe des enseignants dont le nom commence par la lettre N :");
    teachers.stream()
            .filter(teacher -> teacher.getName().startsWith("N"))
            .forEach(teacher ->
                    System.out.println("Nom : " + teacher.getName() + ", Matière : " + teacher.getSubject())
            );
}

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        System.out.println("\nListe des enseignants dont le nom commence par la lettre N et le salaire > 100000 :");
    teachers.stream()
            .filter(teacher -> teacher.getName().startsWith("N") && teacher.getSalary() > 100000)
            .forEach(teacher ->
                    System.out.println("Nom : " + teacher.getName() + ", Matière : " + teacher.getSubject() +
                            ", Salaire : " + teacher.getSalary())
            );

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
         System.out.println("\nListe des enseignants JAVA triés par salaire (éliminer les redondances) :");
        teachers.stream()
                .filter(teacher -> teacher.getSubject().equalsIgnoreCase("JAVA"))
                .distinct() // eliminate duplicates
                .sorted(Comparator.comparingDouble(Teacher::getSalary))
                .forEach(teacher ->
                        System.out.println("Nom : " + teacher.getName() + ", Matière : " + teacher.getSubject() +
                                ", Salaire : " + teacher.getSalary()))


        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        System.out.println("\nListe des noms des enseignants dont le salaire > 60000 (Way 1):");
        teachers.stream()
                .filter(teacher -> teacher.getSalary() > 60000)
                .forEach(teacher -> System.out.println(teacher.getName()));

        teachers.stream().filter(/* TO DO 5 */).forEach(/* TO DO 5 */);
        /* Second Way */
         System.out.println("\nListe des noms des enseignants dont le salaire > 60000 (Way 2):");
        List<String> highSalaryTeacherNames = teachers.stream()
                .filter(teacher -> teacher.getSalary() > 60000)
                .map(Teacher::getName)
                .toList(); // Requires Java 16 or later, or use .collect(Collectors.toList()) for earlier versions

        highSalaryTeacherNames.forEach(System.out::println);

        

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */

         System.out.println("\nListe des enseignants après l'ajout de 200 DT pour ceux dont le nom commence par M :");
        List<Teacher> updatedTeachers = teachers.stream()
                .filter(teacher -> teacher.getName().startsWith("M"))
                .peek(teacher -> teacher.setSalary(teacher.getSalary() + 200))
                .collect(Collectors.toList());

        updatedTeachers.forEach(teacher ->
                System.out.println("Nom : " + teacher.getName() + ", Matière : " + teacher.getSubject() +
                        ", Salaire : " + teacher.getSalary())
        );

        // Afficher le prof avec le salaire le plus élevé
        System.out.println("\nEnseignant avec le salaire le plus élevé :");
        Optional<Teacher> teacherWithHighestSalary = updatedTeachers.stream()
                .max(Comparator.comparingDouble(Teacher::getSalary));

        teacherWithHighestSalary.ifPresent(teacher ->
                System.out.println("Nom : " + teacher.getName() + ", Matière : " + teacher.getSubject() +
                        ", Salaire : " + teacher.getSalary())
        );
       

    }
}
