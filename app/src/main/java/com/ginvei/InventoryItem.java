package com.ginvei;

/**
 * Created by kushaal on 7/30/17.
 */

public class InventoryItem {
    String name;
    int picture_id;
    String description;

    public InventoryItem(String name, int picture_id, String description) {
        this.name = name;
        this.picture_id = picture_id;
        this.description = description;
    }
}
