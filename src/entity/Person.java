/**
 * 
 */
package entity;

/**
 * @author leal
 *
 */
public abstract class Person extends Thread {
	private String personName;
	private Integer timeUsingBath;
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Integer getTimeUsingBath() {
		return timeUsingBath;
	}
	public void setTimeUsingBath(Integer timeUsingBath) {
		this.timeUsingBath = timeUsingBath;
	}

}
