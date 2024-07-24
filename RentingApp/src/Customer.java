public class Customer extends Person {

    public Customer(String name) {
        super(name);
    }

    public void printData(){
        System.out.println("\n\nCustomer Name: " + getName());
        System.out.println("**************************************");
        for (Contract contract : getContracts()) {
            contract.printInformation();
        }
    }


    public void pay() {
        for (Contract contract : getContracts()){
            contract.getPaymentMethod().pay(contract.getPrice());
        }
    }
}
