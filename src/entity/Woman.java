/**
 * 
 */
package entity;

/**
 * @author leal
 *
 */
public class Woman extends Person {

    public Woman(String personName, Integer timeUsingBath) {
        setPersonName(personName);
        setTimeUsingBath(timeUsingBath);
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
