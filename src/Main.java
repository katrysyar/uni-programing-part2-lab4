import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас, що описує навчальний заклад.
 */
class EducationalInstitution {
    String name;
    String type;
    int studentsCount;
    double rating;
    int yearFounded;

    /**
     * Конструктор.
     */
    public EducationalInstitution(String name, String type, int studentsCount, double rating, int yearFounded) {
        this.name = name;
        this.type = type;
        this.studentsCount = studentsCount;
        this.rating = rating;
        this.yearFounded = yearFounded;
    }

    /**
     * Метод для порівняння об'єктів (пошуку ідентичного).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EducationalInstitution other = (EducationalInstitution) obj;

        return this.studentsCount == other.studentsCount &&
                this.rating == other.rating &&
                this.yearFounded == other.yearFounded &&
                this.name.equals(other.name) &&
                this.type.equals(other.type);
    }

    /**
     * Метод для виведення тексту в консоль.
     */
    @Override
    public String toString() {
        return name + " (" + type + ") | Студентів: " + studentsCount + " | Рейтинг: " + rating;
    }
}

public class Main {

    /**
     * Виконавчий метод програми.
     * @param args аргументи консолі
     */
    public static void main(String[] args) {

        EducationalInstitution[] institutions = {
                new EducationalInstitution("КПІ", "Університет", 25000, 4.8, 1898),
                new EducationalInstitution("КНУ", "Університет", 25000, 4.9, 1834),
                new EducationalInstitution("ЛНУ", "Університет", 20000, 4.7, 1661),
                new EducationalInstitution("Коледж зв'язку", "Коледж", 1500, 4.2, 1956),
                new EducationalInstitution("НАУ", "Університет", 18000, 4.5, 1933)
        };

        System.out.println("Початковий масив");
        for (int i = 0; i < institutions.length; i++) {
            System.out.println(institutions[i].toString());
        }

        Arrays.sort(institutions, Comparator
                .comparingInt((EducationalInstitution inst) -> inst.studentsCount)
                .thenComparing(Comparator.comparingDouble((EducationalInstitution inst) -> inst.rating).reversed())
        );

        System.out.println("\nВідсортований масив");
        for (int i = 0; i < institutions.length; i++) {
            System.out.println(institutions[i].toString());
        }

        EducationalInstitution target = new EducationalInstitution("КНУ", "Університет", 25000, 4.9, 1834);
        System.out.println("\nШукаємо: " + target.name);

        boolean found = false;
        for (int i = 0; i < institutions.length; i++) {
            if (institutions[i].equals(target)) {
                System.out.println("Об'єкт знайдено. Індекс: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Об'єкт не знайдено");
        }
    }
}