package com.example.bryan.runegemwall.models;

public class SkillsModel {

    String skillName;
    String skillType;
    Integer skillValue;
    boolean skillChecked;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public Integer getSkillValue() {
        return skillValue;
    }

    public void setSkillValue(Integer skillValue) {
        this.skillValue = skillValue;
    }

    public boolean getSkillChecked() { return skillChecked; }

    public void setSkillChecked(boolean skillChecked) { this.skillChecked = skillChecked; }

    public SkillsModel(String name, String type, Integer value, boolean checked) {
        this.skillName = name;
        this.skillType = type;
        this.skillValue = value;
        this.skillChecked = checked;
    }

}
