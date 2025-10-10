import java.util.Scanner;

class Room {
    private int roomNo;
    private String roomType;
    private double roomArea;
    private boolean ACMachine;

    public void setData(int no, String type, double area, boolean ac) {
        roomNo = no;
        roomType = type;
        roomArea = area;
        ACMachine = ac;
    }

    public void displayData() {
        System.out.println("Room No : " + roomNo);
        System.out.println("Room Type : " + roomType);
        System.out.println("Room Area : " + roomArea);
        System.out.println("AC Machine : " + (ACMachine ? "Yes" : "No"));
    }
}

class AddressBookEntry {
    private String name;
    private String address;
    private String telephoneNumber;
    private String emailAddress;

    public AddressBookEntry() {}

    public AddressBookEntry(String n, String a, String t, String e) {
        name = n;
        address = a;
        telephoneNumber = t;
        emailAddress = e;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String a) {
        address = a;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String t) {
        telephoneNumber = t;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String e) {
        emailAddress = e;
    }

    public void displayEntry() {
        System.out.println("Name : " + name);
        System.out.println("Address : " + address);
        System.out.println("Telephone : " + telephoneNumber);
        System.out.println("Email : " + emailAddress);
        System.out.println("-------------------------");
    }
}

class AddressBook {
    private AddressBookEntry[] entries = new AddressBookEntry[100];
    private int count = 0;

    public void addEntry(AddressBookEntry entry) {
        if (count < 100) {
            entries[count] = entry;
            count++;
        } else {
            System.out.println("Address Book is full.");
        }
    }

    public void delEntry(String name) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getName().equalsIgnoreCase(name)) {
                for (int j = i; j < count - 1; j++) {
                    entries[j] = entries[j + 1];
                }
                entries[count - 1] = null;
                count--;
                System.out.println("Entry deleted.");
                return;
            }
        }
        System.out.println("Name not found.");
    }

    public void viewEntries() {
        if (count == 0) {
            System.out.println("No entries to display.");
        } else {
            for (int i = 0; i < count; i++) {
                entries[i].displayEntry();
            }
        }
    }

    public void updEntry(String name, Scanner watanabe) {
        for (int i = 0; i < count; i++) {
            if (entries[i].getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new Address : ");
                entries[i].setAddress(watanabe.nextLine());
                System.out.print("Enter new Telephone Number : ");
                entries[i].setTelephoneNumber(watanabe.nextLine());
                System.out.print("Enter new Email Address : ");
                entries[i].setEmailAddress(watanabe.nextLine());
                System.out.println("Entry updated.");
                return;
            }
        }
        System.out.println("Name not found.");
    }
}

public class WatanabeMidterms {
    public static void main(String[] args) {
        Scanner watanabe = new Scanner(System.in);
        
        Room room1 = new Room();
        room1.setData(18, "Suite", 48, true);
        room1.displayData();

        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\n------------------");
            System.out.println("1. Add Entry");
            System.out.println("2. Delete Entry");
            System.out.println("3. View All Entries");
            System.out.println("4. Update Entry");
            System.out.println("5. Exit");
            System.out.println("------------------");
            System.out.print("\nChoose option : ");
            int choice = watanabe.nextInt();
            watanabe.nextLine();

            if (choice == 1) {
                System.out.println("\nADD ENTRY");
                System.out.print("Enter Name : ");
                String name = watanabe.nextLine();
                System.out.print("Enter Address : ");
                String address = watanabe.nextLine();
                System.out.print("Enter Telephone Number : ");
                String tel = watanabe.nextLine();
                System.out.print("Enter Email Address : ");
                String email = watanabe.nextLine();
                AddressBookEntry entry = new AddressBookEntry(name, address, tel, email);
                addressBook.addEntry(entry);
            } else if (choice == 2) {
                System.out.println("\nDELETE ENTRY");
                System.out.print("Enter name to Delete: ");
                String name = watanabe.nextLine();
                addressBook.delEntry(name);
            } else if (choice == 3) {
                System.out.println("\nALL ENTRIES");
                addressBook.viewEntries();
            } else if (choice == 4) {
                System.out.println("\nUPDATE ENTRY");
                System.out.print("Enter name to Update: ");
                String name = watanabe.nextLine();
                addressBook.updEntry(name, watanabe);
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Try Again");
            }
        }
        watanabe.close();
    }
}
