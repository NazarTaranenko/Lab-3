package Droid;

import PrintFile.Printer;

public class Base_droid {
    private String Name_droid;
    int health;
    private int damage;

    public Base_droid(String name_droid, int health, int damage) {
        Name_droid = name_droid;
        this.health = health;
        this.damage = damage;
    }

    public Base_droid() {

    }

    public String getName_droid() {
        return Name_droid;
    }

    public void setName_droid(String name_droid) {
        Name_droid = name_droid;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean getHit(int Damage){
        this.health -= Damage;
        Printer.print("Дроїд " +getName_droid()+ " був атакований. Кількість ХР " + getHealth() );
        if(this.health <=0) {
            Printer.print("Дроїд був вбитий");
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Base_droid{" +
                "Назва Дроїда='" + Name_droid + '\'' +
                ", здоров'я=" + health +
                ", Сила=" + damage +
                '}';
    }

    public int setSpecial(){return 0;}
    public void pickWeapon(int weap){}


}
