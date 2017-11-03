package entity;

public class Man extends Person {

    public Man(String personName, Integer timeUsingBath) {
        setPersonName(personName);
        setTimeUsingBath(timeUsingBath);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
