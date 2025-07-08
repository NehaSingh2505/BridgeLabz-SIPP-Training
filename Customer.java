public class Customer {
    private String customerName;
    private int licenseNumber;
    private int contactNumber;

    public Customer(String customerName, int licenseNumber, int contactNumber) {
        this.customerName = customerName;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }
}