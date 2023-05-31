package Options;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import FileUtils.Contact;
import FileUtils.TeleBook;


public class TeleBookController {
	  private TeleBook teleBook = new TeleBook();
	    private Scanner input = new Scanner(System.in);

	    public void loop() {
	        Options option = null;
	        do {
	            showOptions();
	            try {
	                option = chooseOption();
	                executeOption(option);
	            } catch(NoSuchElementException e) {
	                System.out.println("Nieprawidłowa opcja");
	            }
	        } while(option != Options.CLOSE);
	    }
	    
	    private void showOptions() {
	        System.out.println(">>> Opcje:");
	        for (Options option : Options.values()) {
	            System.out.println(option);
	        }
	    }
	    
	    private Options chooseOption() {
	        int option = input.nextInt();
	        input.nextLine();
	        return Options.convertToOption(option);
	    }
	    
	    private void executeOption(Options options) {
	        switch(options) {
	            case ADD_CONTACT:
	                addContact();
	                break;
	            case SEARCH_BY_NAME:
	                searchByName();
	                break;
	            case SEARCH_BY_TEL:
	                searchByTelephone();
	                break;
	            case DELETE:
	                delete();
	                break;
	            case CLOSE:
	                close();
	                break;
	        }
	    }
	    
	    private void delete() {
	        System.out.println("Podaj nazwę rekordu do usunięcia:");
	        String name = input.nextLine();
	        boolean removed = teleBook.remove(name);
	        if(removed) {
	            System.out.println("Rekord usunięty");
	        } else {
	            System.out.println("Nie ma rekordu o takiej nazwie");
	        }
	    }
	    
	    private void searchByTelephone() {
	        System.out.println("Podaj numer telefonu lub jego fragment:");
	        String telFragment = input.nextLine();
	        List<Contact> contacts = teleBook.findByTelephone(telFragment);
	        if(contacts.isEmpty()) {
	            System.out.println("Brak wyników.");
	        } else {
	            System.out.println("Znalezione rekordy:");
	            contacts.forEach(System.out::println);
	        }
	    }
	    
	    private void searchByName() {
	        System.out.println("Podaj fragment nazwy:");
	        String nameFragment = input.nextLine();
	        List<Contact> contacts = teleBook.findByName(nameFragment);
	        if(contacts.isEmpty()) {
	            System.out.println("Brak wyników.");
	        } else {
	            System.out.println("Znalezione rekordy:");
	            contacts.forEach(System.out::println);
	        }
	    }
	    
	    private void addContact() {
	        System.out.println("Podaj nazwę kontaktu:");
	        String name = input.nextLine();
	        System.out.println("Podaj nr telefonu:");
	        String telephone = input.nextLine();
	        try {
	            boolean add = teleBook.add(name, telephone);
	            if (add) {
	                System.out.println("Rekord dodany.");
	            } else {
	                System.out.println("Nie można dodać rekordu. Wpis o takiej nazwie już istnieje.");
	            }
	        } catch(IllegalArgumentException e) {
	            System.err.println("Nazwa ani numer telefonu nie mogą być puste");
	        }
	    
	    }
	    
	    private void close() {
	        input.close();
	        System.out.println("Bye bye.");
	    }

	
}
