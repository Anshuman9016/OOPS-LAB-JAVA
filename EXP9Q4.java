import java.util.HashSet;

public class EXP9Q4 {

    public static void main(String[] args) {
        String[] names = {"Aman", "Varchasv", "Sourabh", "Varchasv", "Aman"};

        HashSet<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            uniqueNames.add(name);
        }

        String nameToCheck = "Varchasv";
        if (uniqueNames.contains(nameToCheck)) {
            System.out.println(nameToCheck + " exists in the set.");
        } else {
            System.out.println(nameToCheck + " does not exist in the set.");
        }

        System.out.println("Unique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
