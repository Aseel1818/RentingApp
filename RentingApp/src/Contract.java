public class Contract {
    private String rentalPeriod;
    private float price;
    private PaymentWay paymentWay;
    private Customer customer;
    private Owner owner;
    ///////// Composition ////////////////
    private Building building;


    public Contract(String rentalPeriod, float price, Building building,Customer customer,Owner owner) {
        this.rentalPeriod = rentalPeriod;
        this.price = price;
        this.building = building;
        this.owner = owner;
        this.customer=customer;
    }

    public void printInformation() {
        System.out.println("Contract Information: ");
        building.showInformation(building.getName(), building.getAddress(), building.getSize());
        System.out.println("rental period" + " : " + getRentalPeriod());
        System.out.println("rental price" + " : " + getPrice());
        System.out.println("Payment method: " + paymentWay.getClass().getName());
        System.out.println("Customer: " + customer.getName());
        System.out.println("Owner: " + owner.getName());
        System.out.println("**************************************");
    }

    public void setPaymentMethod(PaymentWay paymentWay) {
        this.paymentWay = paymentWay;
    }

    public PaymentWay getPaymentMethod(){
        return paymentWay;
    }


    public void setPrice(float price) {
        this.price = price;
    }

    public String getRentalPeriod() {
        return rentalPeriod;
    }

    public float getPrice() {
        return price;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setPaymentWay(PaymentWay paymentWay) {
        this.paymentWay = paymentWay;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
