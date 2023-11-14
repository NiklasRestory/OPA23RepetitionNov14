package org.example;

public class Shop extends ObjectWithId {
    private String address;

    static int nextId = 1;
    public Shop(String address) {
        super(nextId);
        nextId++;
        this.address = address;
    }
    public Shop(int id, String address) {
        super(id);
        if (id >= nextId) {
            nextId = id + 1;
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
