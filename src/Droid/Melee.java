package Droid;

import PrintFile.Printer;

import java.util.Scanner;

public class Melee extends Base_droid  {

    private int Armor;

    public Melee(String name_droid, int health, int damage, int Armor) {
        super(name_droid, health, damage);
        this.Armor = Armor;
    }

    public Melee() {

    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }

    private int HitArmor(int Damage){
        if(Damage>=this.Armor){
            System.out.println("Броня дроїда пробита");
            Damage -=this.Armor;
            this.Armor=0;
            return Damage;
        }
        else{
            System.out.println("Броня дроїда не пробита");
            this.Armor-=Damage;
            Damage=0;
            System.out.println("Залишкова кількість броні " + getArmor());
            return Damage;
        }
    }

    private void SetDroid(String name_droid, int health, int damage, int Armor){
        this.setName_droid(name_droid);
        this.setArmor(Armor);
        this.setDamage(damage);
        this.setHealth(health);
    }

    public int setSpecial(){
        System.out.println("Вибери спеціалізацію свому дроїду-лицару");
        System.out.println("1. Мечник:50 сили 50 броні 70 здоров'я");
        System.out.println("2. Копійщик:30 сили 70 броні 70 здоров'я");
        System.out.println("3. Кавалерист:60 сили 20 броні 80 здоров'я");
        System.out.println("4. Берсерк:80 сили 0 броні 90 здоров'я");
        Scanner in = new Scanner(System.in);
        int weap = in.nextInt();
        return weap;
    }
    public void pickWeapon(int weap) {
        Scanner in = new Scanner(System.in);
        switch (weap) {
            case (1) -> this.SetDroid("Мечник", 70, 50, 50);
            case (2) -> this.SetDroid("Копійщик", 70, 30, 70);
            case (3) -> this.SetDroid("Кавалерист", 80, 60, 30);
            case (4) -> this.SetDroid("Берсерк", 90 ,80, 0);

        }
    }


    @Override
    public boolean getHit(int Damage) {
        Damage= this.HitArmor(Damage);
        this.health-= Damage;
        Printer.print("Дроїд " +this.getName_droid()+ " був атакований. Кількість ХР " + this.getHealth() );
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
        return super.toString();
    }
}
