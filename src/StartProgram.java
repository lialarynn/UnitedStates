import java.util.List;
import java.util.Scanner;

import controller.StateHelper;
import model.State;

/**
 * @author Lia Kruger - alkruger2
 * CIS175 - Spring 2023
 * Feb 4, 2023
 */

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static StateHelper sh = new StateHelper();

	private static void addAState() {
		// TODO Auto-generated method stub
		System.out.print("Enter a state: ");
		String state = in.nextLine();
		System.out.print("Enter its capital: ");
		String capital = in.nextLine();
		System.out.print("Enter its governor: ");
		String governor = in.nextLine();
		State toAdd = new State(state, capital, governor);
		sh.insertState(toAdd);

	}

	private static void deleteAState() {
		// TODO Auto-generated method stub
		System.out.print("Enter the state to delete: ");
		String state = in.nextLine();
		System.out.print("Enter the capital to delete: ");
		String capital = in.nextLine();
		System.out.print("Enter the governor to delete: ");
		String governor = in.nextLine(); 
		State toDelete = new State(state, capital, governor);
		sh.deleteState(toDelete);

	}

	private static void editAState() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by State");
		System.out.println("2 : Search by Capital");
		System.out.println("3 : Search by Governor");
		int searchBy = in.nextInt();
		in.nextLine();
		List<State> foundStates;
		if (searchBy == 1) {
			System.out.print("Enter the state name: ");
			String stateName = in.nextLine();
			foundStates = sh.searchForStateByState(stateName);
		} else if (searchBy == 2) {
			System.out.print("Enter the capital: ");
			String capitalName = in.nextLine();
			foundStates = sh.searchForStateByCapital(capitalName);
		} else {
			System.out.print("Enter the governor: ");
			String governorName = in.nextLine();
			foundStates = sh.searchForStateByGovernor(governorName);
		}

		if (!foundStates.isEmpty()) {
			System.out.println("Found Results.");
			for (State l : foundStates) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			State toEdit = sh.searchForStateById(idToEdit);
			System.out.println("Retrieved " + toEdit.getState() + " from " + toEdit.getState());
			System.out.println("1 : Update State");
			System.out.println("2 : Update Capital");
			System.out.println("3 : Update Governor");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New State: ");
				String newState = in.nextLine();
				toEdit.setState(newState);
			} else if (update == 2) {
				System.out.print("New Capital: ");
				String newCapital = in.nextLine();
				toEdit.setCapital(newCapital);
			} else if (update == 3) {
				System.out.print("New Governor: ");
				String newGovernor = in.nextLine();
				toEdit.setGovernor(newGovernor);
			}

			sh.updateState(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the States List ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a state");
			System.out.println("*  2 -- Edit a state");
			System.out.println("*  3 -- Delete a state");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAState();
			} else if (selection == 2) {
				editAState();
			} else if (selection == 3) {
				deleteAState();
			} else if (selection == 4) {
				viewTheList();
			} else {
				sh.cleanUp();
				System.out.println("   Bye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<State> allStates = sh.showAllStates();
		for(State singleState: allStates) {
			System.out.println(singleState.returnStateDetails());
		}

	}
}
