
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Owner> owners = new ArrayList<Owner>();

    public static void main(String[] args) {
        List<Owner> owners = new ArrayList<Owner>();
        Customer customer = createCustomer();
        creteOwners();
        boolean continueRenting = true;

        while (continueRenting) {
            Owner owner = selectOwner();
            Building building = selectBuilding(owner);
            Contract contract = createContract(building,customer,owner);
            PaymentWay paymentWay = selectPaymentWay();
            contract.setPaymentMethod(paymentWay);
            customer.addContract(contract);
            scanner.nextLine();

            System.out.println("Do you want to rent another building? (yes/No)");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                continueRenting = false;
            }
        }
        printDetails(customer);
        processPayments(customer);
    }

    private static Customer createCustomer() {
        System.out.println("Welcome to the renting application");
        System.out.println("Please enter your name :");
        String name = scanner.nextLine();
        return new Customer(name);
    }

    private static void creteOwners(){
        System.out.println("Please enter the number of owners:");
        int numberOfOwners = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfOwners; i++){
            System.out.println("Enter owner's name: ");
            String name = scanner.nextLine();
            owners.add(new Owner(name));
        }
    }

    private static Owner selectOwner() {
        System.out.println("Select owner:");
        for (int i = 0; i < owners.size(); i++) {
            System.out.println((i + 1) + ". " + owners.get(i).getName());
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return owners.get(choice - 1);

    }


    private static Building selectBuilding(Owner owner) {
        System.out.println("Select Building type to rent : ");
        System.out.println("1. Shop");
        System.out.println("2. Apartment");
        System.out.println("3. Separate House");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("**************************************");
        System.out.println("Enter building details:");
        System.out.println();
        System.out.println("Enter building name: ");
        String name = scanner.nextLine();
        System.out.println("Enter building address: ");
        String address = scanner.nextLine();
        System.out.println("Enter building size:");
        String size = scanner.nextLine();
        System.out.println("**************************************");

        Building building;
        switch (choice) {
            case 1:
                building= new Shop(name, address, size);
                break;
            case 2:
                building= new Apartment(name, address, size);
                break;
            case 3:
                building= new SeparateHouse(name, address, size);
                break;
            default:
                throw new IllegalArgumentException("Invalid building type.");
        }
        owner.setBuilding(building);
        return building;
    }

    private static Contract createContract(Building building, Customer customer , Owner owner) {
        System.out.println("Enter rental period:");
        String rentalPeriod = scanner.nextLine();
        System.out.println("Enter price:");
        float price = scanner.nextFloat();
        System.out.println("**************************************");
        return new Contract(rentalPeriod, price, building,customer,owner);
    }

    ////////// to create contract with a default values ,so I use overloading
    private static Contract createContract(Building building, String rentalPeriod, float price, Customer customer,Owner owner) {
        return new Contract(rentalPeriod, price, building,customer,owner);
    }

    private static PaymentWay selectPaymentWay() {
        System.out.println("Select payment method: ");
        System.out.println("1. PayPal");
        System.out.println("2. MasterCard");
        System.out.println("3. Visa");
        int choice = scanner.nextInt();
        System.out.println("**************************************");
        switch (choice) {
            case 1:
                return new PayPal();
            case 2:
                return new MasterCard();
            case 3:
                return new VisaCard();
            default:
                throw new IllegalArgumentException("Invalid payment method.");
        }
    }

    public static void printDetails(Customer customer) {
        customer.printData();
        System.out.println("**************************************");
    }

    public static void processPayments(Customer customer) {
        System.out.println("Processing Payments ..........");
        customer.pay();
        System.out.println("Payments processes successfully ..........");
    }
}