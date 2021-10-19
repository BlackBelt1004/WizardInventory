package wizardGame;
import java.util.*;

public class WizardInventory {
	final static int inventory_size = 4;
	static Scanner input = new Scanner(System.in);
	public static void main(String[]args) {
		ArrayList<String>inventory = new ArrayList<>();
		inventory.add("wooden staff");
		inventory.add("wizard hat");
		inventory.add("leather shoes");
		
		System.out.println("Wizard inventory game");
		String command;
		printMenu();
		while(true) {
			System.out.print("\nCOMMAND: ");
			command = input.next();
			if(command.equalsIgnoreCase("show")) {
				showInventory(inventory);
			}
			else if (command.equalsIgnoreCase("grab")) {
				grabInventory(inventory);
			}
			else if (command.equalsIgnoreCase("drop")){
				dropInventory(inventory);
			}
			else if(command.equalsIgnoreCase("edit")) {
				editInventory(inventory);
			}
			else if(command.equalsIgnoreCase("exit"))
				break;
			else
				System.out.println("Invalid input! Retry. ");
		}
		System.out.println("\nBye");
	}
	//prints menu
	private static void printMenu() {
		 System.out.println("\nCOMMAND MENU");
	     System.out.println("show - Show all items");
	     System.out.println("grab - Grab an item");
	     System.out.println("edit - Edit an item");
	     System.out.println("drop - Drop an item");
	     System.out.println("exit - Exit program");
	}
	//shows inventory
	public static void showInventory(ArrayList<String>inventory) {
		for(int i=0;i<inventory.size();i++) {
			System.out.println((i+1)+". "+inventory.get(i));
		}
	}
	private static void grabInventory(ArrayList<String>inventory) {
		if (inventory.size()==inventory_size) {
			System.out.println("You cant carry anything else. Drop something.");
			return;
			}
			String item;
			System.out.print("Name: ");
			input.nextLine();
			item = input.nextLine();
			inventory.add(item);
			System.out.println(item+" was added.");
		}
	
	private static void dropInventory(ArrayList<String>inventory) {
		if(inventory.isEmpty()) {
			System.out.println("There are no items. Grab something first.");
			return;
		}
		int pos;
		System.out.print("Number: ");
		pos = input.nextInt();
		if (pos-1>=0 && pos-1<inventory.size()) {
			System.out.println(inventory.get(pos-1)+" was dropped.");
			inventory.remove(pos-1);
		}
		else {
			System.out.println("Invalid item number entered");
		}
	}
	private static void editInventory(ArrayList<String>inventory) {
		if(inventory.isEmpty()) {
			System.out.println("There are no items. Grab something first.");
			return;
		}
		int pos;
		String name;
		System.out.print("Number: ");
		pos = input.nextInt();
		System.out.print("Updated name: ");
		input.nextLine();
		name = input.nextLine();
		
		if (pos-1>=0 && pos-1<inventory.size()) {
			System.out.println("Item number "+pos+" was updated");
			inventory.set(pos-1,name);
		}
		else {
			System.out.println("Invalid item number entered");
		}
	}
		
}
