package Options;

import java.util.NoSuchElementException;

public enum Options {
	 ADD_CONTACT(0, "Dodaj kontakt"),
	    SEARCH_BY_NAME(1, "Szukaj po nazwie"),
	    SEARCH_BY_TEL(2, "Szukaj po telefonie"),
	    DELETE(3, "Usuń"),
	    CLOSE(4, "Koniec");

	    private final int shortcut;
	    private final String description;

	    Options(int shortcut, String description) {
	        this.shortcut = shortcut;
	        this.description = description;
	    }

	    public int getShortcut() {
	        return shortcut;
	    }

	    static Options convertToOption(int option) { 
	        if(option >= values().length || option < 0)
	            throw new NoSuchElementException();
	        return values()[option];
	    }

	    @Override
	    public String toString() {
	        return shortcut + " - " + description;
	    }
}
