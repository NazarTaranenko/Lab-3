package Droid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    private final List<Base_droid> droids = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);



    public Team(int Size){
        fillTeam(Size);

    }

    public List<Base_droid> getDroids() {
        return droids;
    }

    private void fillTeam(int size) {
        for(int i=0; i<size;i++){
                droids.add(chooseDroid());
        }
    }

    private Base_droid chooseDroid() {
        System.out.println("Вибери клас дроїда:\n 1.Дроїд-лицар \n 2.Дроїд-стрілець");
        int values=scanner.nextInt();
        Base_droid Droid = null;
        switch(values){
            case (1) -> {
                Droid = new Melee();
                Droid.pickWeapon(Droid.setSpecial());

            }
            case (2) -> {
                Droid = new Range();
                Droid.pickWeapon(Droid.setSpecial());

            }
        }
        return Droid;
    }
}
