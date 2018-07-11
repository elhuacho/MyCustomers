package pe.edu.upc.mycustomers.models;

import android.os.Bundle;

import java.util.List;

public class Customer {
    private String name;
    private String contact;
    private String address;
    private int pictureId;

    public Customer() {
    }

    public Customer(String name, String contact, String address, int pictureId) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.pictureId = pictureId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("name", this.getName());
        bundle.putString("contact", this.getContact());
        bundle.putString("address", this.getAddress());
        bundle.putInt("pictureId", this.getPictureId());
        return bundle;
    }

    public static class Builder {
        private Customer customer;
        private List<Customer> customers;

        public Builder(Customer customer) {
            this.customer = customer;
        }

        public Builder(List<Customer> customers) {
            this.customers = customers;
        }

        public static Builder from(Bundle bundle){
            Customer customer = new Customer();
            customer.setName(bundle.getString("name"));
            customer.setContact(bundle.getString("contact"));
            customer.setAddress(bundle.getString("address"));
            customer.setPictureId(bundle.getInt("pictureId"));
            return new Builder(customer);
        }

        public Customer build() {
            return this.customer;
        }
    }
}
