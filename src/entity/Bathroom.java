package entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Bathroom {
    private Semaphore semaphore = new Semaphore(1);
    private Integer limitOfPersons;
    private Queue<Person> persons = new LinkedList<>();
    private Queue<Person> waitingPersons = new LinkedList<>();

    private static Bathroom bathroom;

    private Bathroom() {
    }

    public static Bathroom getInstance() {
        if (bathroom == null) {
            bathroom = new Bathroom();
        }
        return bathroom;
    }

    public Integer getLimitOfPersons() {
        return limitOfPersons;
    }

    public void setLimitOfPersons(Integer limitOfPersons) {
        this.limitOfPersons = limitOfPersons;
    }

    public Queue<Person> getPersons() {
        return persons;
    }

    public void setPersons(Queue<Person> persons) {
        this.persons = persons;
    }

    public Boolean addPersonInBathroom(Person p) {
        if ( (persons.size() == 0 || persons.element().getClass() == p.getClass()) && persons.size() < limitOfPersons) {
            persons.add(p);
            System.out.println(p.getClass().getName().replace("entity.", "") + " " + p.getPersonName() + " enter in bathroom. Time of use: " + p.getTimeUsingBath() + "ms");
            System.out.println("There are " + persons.size() + " persons in bathroom");
            return true;
        }
        return false;
    }

    public void removePersonOfBathroom(Person p){
        persons.remove(p);
        System.out.println(p.getClass().getName().replace("entity.", "") + " " + p.getPersonName() + " exit of bathroom.");
        System.out.println("There are " + persons.size() + " persons in bathroom");
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Queue<Person> getWaitingPersons() {
        return waitingPersons;
    }

    public void setWaitingPersons(Queue<Person> waitingPersons) {
        this.waitingPersons = waitingPersons;
    }

    public void addWaitingPersonInBathroom(){
        if (waitingPersons.size() > 0 && addPersonInBathroom(waitingPersons.element())) {
            waitingPersons.remove();
            addWaitingPersonInBathroom();
        }
    }

    public Boolean isPersonInBathroom(Person person){
        try {
            semaphore.acquire();
            return persons.contains(person);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return null;
    }
}
