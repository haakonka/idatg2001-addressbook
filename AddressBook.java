import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
public class AddressBook {
    HashMap<String,ContactDetails> contactDetailsHashMap;

    public AddressBook() {
        contactDetailsHashMap = new HashMap<>();
    }

    public static void main(String[] args) {
        AddressBook ab = new AddressBook();

        try{
            ContactDetails cd1 = new ContactDetails("Kåre","12345678","kriseveien 4",22);
            System.out.printf(cd1.toString());
        ContactDetails cd2 = new ContactDetails("Ali","90010020","1",22);
        System.out.printf("\n" + cd2.toString());
        ab.contactDetailsHashMap.put(cd1.getPhoneNumber(),cd1);
        ab.contactDetailsHashMap.put(cd2.getPhoneNumber(),cd2);
        ab.writeToFile();

            System.out.println("\n" + ab.contactDetailsHashMap.toString());}

        catch (NullPointerException npe){
            System.out.println("\n Object was not created");
            System.out.println(npe.getMessage());
        }
        catch (IllegalArgumentException iae){
            System.out.println("\nObject was not created");
            System.out.println(iae.getMessage());
        }
        catch (Exception e){
            System.out.println("\n System was not happy");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Ta kontakt med julius for å fikse denne feilen");
            //close connection to database
        }
    }
    public void writeToFile() throws IOException{
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("SavedContactDetails.txt");
            //write to file
            for (ContactDetails contactDetails:contactDetailsHashMap.values()) {
                fileWriter.write(contactDetails.getName() + ", " + contactDetails.getAddress() + ", "
                        +contactDetails.getPhoneNumber() + "\n");
            }
        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        finally {
            fileWriter.close();
        }
    }
}
