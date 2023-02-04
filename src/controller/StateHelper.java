/**
 * @author Lia Kruger - alkruger2
 * CIS175 - Spring 2023
 * Feb 4, 2023
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.State;

public class StateHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UnitedStates");
	
	public void insertState(State s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<State> showAllStates(){
		EntityManager em = emfactory.createEntityManager();
		List<State> allStates = em.createQuery("SELECT i from State i").getResultList();
		return allStates;
		
	}

	public void deleteState(State toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<State> typedQuery = em.createQuery("select s from State s where s.state = :selectedState and s.capital = :selectedCapital and s.governor = :selectedGovernor", State.class);
		
		typedQuery.setParameter("selectedState", toDelete.getState());
		typedQuery.setParameter("selectedCapital", toDelete.getCapital());
		typedQuery.setParameter("selectedGovernor", toDelete.getGovernor());
		
		typedQuery.setMaxResults(1);
		
		State result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public State searchForStateById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		State found = em.find(State.class, idToEdit);
		em.close();
		return found;
	}

	public void updateState(State toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<State> searchForStateByState(String stateName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<State> typedQuery = em.createQuery("select s from State s where s.state = :selectedState", State.class);
		
		typedQuery.setParameter("selectedState", stateName);
		
		List<State> foundStates = typedQuery.getResultList();
		em.close();
		return foundStates;
	}

	public List<State> searchForStateByCapital(String capitalName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<State> typedQuery = em.createQuery("select s from State s where s.capital = :selectedCapital", State.class);
		
		typedQuery.setParameter("selectedCapital", capitalName);
		
		List<State> foundStates = typedQuery.getResultList();
		em.close();
		return foundStates;
	}
	
	public List<State> searchForStateByGovernor(String governorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<State> typedQuery = em.createQuery("select s from State s where s.governor = :selectedGovernor", State.class);
		
		typedQuery.setParameter("selectedCapital", governorName);
		
		List<State> foundStates = typedQuery.getResultList();
		em.close();
		return foundStates;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
