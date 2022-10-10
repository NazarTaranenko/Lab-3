package Battle;

import Droid.Base_droid;
import Droid.Team;
import PrintFile.Printer;

public class Battle {
    protected Team firstTeam;
    protected Team secondTeam;
    private int Round = 1;

    public Battle(Team firstTeam, Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    private void fight(Team first, Team second, int firstind, int secondind){
        Base_droid fistDroid= first.getDroids().get(firstind);

        Base_droid secondDroid = second.getDroids().get(secondind);
        boolean result= secondDroid.getHit(fistDroid.getDamage());
        if(result == false){
            second.getDroids().remove(secondind);
        }
    }
    public void battle()
    {
        int myDroidIndex=0;
        int enemyDroidIndex=0;
        while (!firstTeam.getDroids().isEmpty() && !secondTeam.getDroids().isEmpty()) {
            Printer.print("\nRound №" + Round++);

            Printer.print("\n Черга першої команди:");
            fight(firstTeam,secondTeam,myDroidIndex,enemyDroidIndex);
            if (!secondTeam.getDroids().isEmpty()){
                Printer.print("Черга другої команди:");
                fight(secondTeam, firstTeam, enemyDroidIndex, myDroidIndex);
                showInfo();
            }
            myDroidIndex++;
            enemyDroidIndex++;

            if(myDroidIndex>=firstTeam.getDroids().size()-1) myDroidIndex=0;

            if(enemyDroidIndex>=secondTeam.getDroids().size()-1) enemyDroidIndex=0;

        }
        if(firstTeam.getDroids().isEmpty()) Printer.print("\nДруга команда перемогла:");
        else Printer.print("\nПерша команда перемогла:");
    }
    private void showInfo()
    {
        System.out.println("\nПерша команда:");
        printList(firstTeam);

        System.out.println("\nДруга команда:");
        printList(secondTeam);
    }

    /**
     * Метод для виводу на екран команди,що передається як параметр
     * @param team команда,що передається у метод
     */

    private void printList(Team team)
    {
        if(team.getDroids().isEmpty()) Printer.print("\nПусто");

        for (int i = 0;i<team.getDroids().size();i++)
            Printer.print(team.getDroids().get(i).toString());
    }

}
