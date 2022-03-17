import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class HashExercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();
        boolean finished = false;
        String yearLength = Integer.toString(year);
        while(!finished){
            for(int i = yearLength.length();i > 0;i--){
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add((int) (year % Math.pow(10, i)));
                year /= 10;
            }
        }


    }
}
