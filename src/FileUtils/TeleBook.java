package FileUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class TeleBook implements Iterable<Contact> {
	 private Map<String, Contact> contacts = new TreeMap<>();

	 public Iterator<Contact> iterator() {
	        return contacts.values().iterator();
	    }
	 
	    public TeleBook() {}

	    public TeleBook(Map<String, Contact> contacts) {
	        this.contacts = contacts;
	    }

	    public boolean add(String name, String telephone) {
	        if(name == null || telephone == null)
	            throw new NullPointerException("name and telephone cannot be null");
	        if(name.isEmpty() || telephone.isEmpty())
	            throw new IllegalArgumentException("name and telephone cannot be empty");
	        if(!contacts.containsKey(name)) {
	            contacts.put(name, new Contact(name, telephone));
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean remove(String name) {
	        return contacts.remove(name) != null;
	    }

	    public List<Contact> findByName(String name) {
	        List<Contact> result = new ArrayList<>();
	        for (var entry : contacts.entrySet()) {
	            if(entry.getKey().contains(name))
	                result.add(entry.getValue());
	        }
	        return result;
	    }

	    public List<Contact> findByTelephone(String telephone) {
	        List<Contact> result = new ArrayList<>();
	        for (Contact contact : contacts.values()) {
	            if(contact.getTelephone().contains(telephone))
	                result.add(contact);
	        }
	        return result;
	    }

}
