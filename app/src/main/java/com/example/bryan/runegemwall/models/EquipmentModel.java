package com.example.bryan.runegemwall.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EquipmentModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("stats")
    @Expose
    private String stats;
    @SerializedName("cost")
    @Expose
    private String cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


}
