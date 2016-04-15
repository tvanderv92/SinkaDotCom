/**
 * Created by TRISTAN on 10-4-2016.
 */
import java.util.*;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        //instantiate three dotcom objects and give it a name
        DotCom one = new DotCom();
        one.setName("google.com");
        DotCom two = new DotCom();
        two.setName("fok.nl");
        DotCom three = new DotCom();
        three.setName("abc.nl");
        //add dotcoms to arraylist
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Sink three dotcom in a 7x7 grid (A-G)(0-7)");
        System.out.println("Google.com, fok.nl, abc.nl");
        System.out.println("Try sink'em in a few guesses");

        //loop through objects in arraylist
        for(DotCom dotComObject: dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComObject.setLocationCells(newLocation);
        }

    }

    public void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";
        //loop through each object inside the arraylist
        for(DotCom dotComObject : dotComsList) {
            result = dotComObject.checkYourSelf(userGuess);
            if ( result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotComObject);
                break;
            }

        }
        System.out.println(result);

    }

    public void finishGame() {
        System.out.println("The game is over, the stocks are NULL/VOID");
        if (numOfGuesses  <=  16) {
            System.out.println("You rock!");
        } else {
            System.out.println("OY CUNT YOU SUCK");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
