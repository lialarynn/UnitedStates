/**
 * @author Lia Kruger - alkruger2
 * CIS175 - Spring 2023
 * Feb 4, 2023
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="states")
public class State {
	@Id
	@GeneratedValue
	private int id;
	private String state;
	private String capital;
	private String governor;

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(int id, String state, String capital, String governor) {
		super();
		this.id = id;
		this.state = state;
		this.capital = capital;
		this.governor = governor;
	}

	public State(String state, String capital, String governor) {
		super();
		this.state = state;
		this.capital = capital;
		this.governor = governor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public String getGovernor() {
		return governor;
	}
	
	public void setGovernor(String governor) {
		this.governor = governor;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", state=" + state + ", capital=" + capital + ", governor=" + governor + "]";
	}

	public String returnStateDetails() {
		return this.state + ": " + this.capital + ": " + this.governor;
	}
}
