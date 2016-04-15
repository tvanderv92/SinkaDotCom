import java.util.ArrayList;

/**
 * Created by TRISTAN on 10-4-2016.
 */
public class DotCom {
       private ArrayList<String> locationCells;
       private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }


    public void setName(String dotComName) {
        name = dotComName;
    }

    public String checkYourSelf(String userInput) {

        String result = "miss";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! you sunk" + name + " ");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
