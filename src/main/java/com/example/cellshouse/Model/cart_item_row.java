package com.example.cellshouse.Model;

public class cart_item_row {
    private int id_cart;
    private int id_item;
    private int id_user;
    private int quantity;

    public cart_item_row(int id_cart, int id_item, int id_user, int quantity) {
        this.id_cart = id_cart;
        this.id_item = id_item;
        this.id_user = id_user;
        this.quantity = quantity;
    }

    public cart_item_row(int id_item, int id_user, int quantity) {
        this.id_item = id_item;
        this.id_user = id_user;
        this.quantity = quantity;
    }

    public int getId_cart() {
        return id_cart;
    }

    public void setId_cart(int id_cart) {
        this.id_cart = id_cart;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
