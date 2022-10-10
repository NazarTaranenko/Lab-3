package Droid;

import PrintFile.Printer;

import java.util.Scanner;

public class Range extends Base_droid {
    private int Distance;

    public Range(String name_droid, int health, int damage, int Distance) {
        super(name_droid, health, damage);
        this.Distance = Distance;
    }
    public Range(){

    }
    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }

    private int Distance(){
        if(this.Distance>0){
            this.Distance-=1;
        }
        return Distance;
    }

    private void SetDroid(String name_droid, int health, int damage, int Distance){
        this.setName_droid(name_droid);
        this.setDistance(Distance);
        this.setDamage(damage);
        this.setHealth(health);
    }

    public int setSpecial(){
        System.out.println("Вибери спеціалізацію свому дроїду-стрільцю(Дистанція- кількість ходів,під час яких твоєму дроїду не буде завдаватись урон");
        System.out.println("1. Лучник:50 сила 60 здоров'я Дистанція 3");
        System.out.println("2. Арбалетчик:60 сила 60 здоров'я Дистанція 2");
        System.out.println("3. Мушкетер:70 сила 60 здоров'я Дистанція 1");
        Scanner in = new Scanner(System.in);
        int weap = in.nextInt();
        return weap;
    }
    public void pickWeapon(int weap) {
        Scanner in = new Scanner(System.in);
        switch (weap) {
            case (1) -> this.SetDroid("Лучник", 50, 50, 3);
            case (2) -> this.SetDroid("Арбалетчик", 50, 60, 2);
            case (3) -> this.SetDroid("Мушкетер", 50, 70, 1);
        }
    }


    @Override
    public boolean getHit(int Damage) {
        if(this.Distance()==0){
        this.health-= Damage;
            Printer.print("Дроїд " +this.getName_droid()+ " був атакований. Кількість ХР " + this.getHealth() );
    }
        else{
            Printer.print("Дроїд противника не встиг наблизитися до дроїда");
        }

        if(this.health <=0) {
            System.out.println("Дроїд був вбитий");
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
