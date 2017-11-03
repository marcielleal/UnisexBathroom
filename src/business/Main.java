package business;

import entity.Bathroom;
import entity.Man;
import entity.Person;
import entity.Woman;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer limitBathroom;
        Integer numberPersons;
        Random random = new Random();

        Scanner sc = new Scanner(System.in);
        System.out.println("Limite de pessoas que podem utilizar o banheiro ao mesmo tempo: ");
        limitBathroom = sc.nextInt();

        System.out.println("Número de pessoas que utilizarão o banheiro: ");
        numberPersons = sc.nextInt();
        sc.close();

        Bathroom bathroom = Bathroom.getInstance();
        bathroom.setLimitOfPersons(limitBathroom);

        for (int i = 0, man = 1, woman = 1; i < numberPersons; i++) {
            Person person;
            if (random.nextBoolean()) {
                person = new Man(Integer.toString(man), random.nextInt(5000));
                man++;
            }
            else {
                person = new Woman(Integer.toString(woman), random.nextInt(5000));
                woman++;
            }
            person.start();
        }
    }
}
