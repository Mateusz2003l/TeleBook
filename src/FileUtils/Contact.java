package FileUtils;



public class Contact implements Comparable<Contact> {
    private String name;
    private String telephone;
    
    public String toCSV() {
        return name + ";" + telephone;
    }


    public Contact(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int compareTo(Contact c) {
        return this.name.compareTo(c.name);
    }

    @Override
    public String toString() {
        return name + " - " + telephone;
    }

}
