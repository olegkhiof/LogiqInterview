package no.logiq.ole;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class ActionListReader {

    protected ArrayList<Action> actionListReader(File actionListFile){
        //initialize ArrayLists
        ArrayList<String> actionStringArrayList = new ArrayList<>();
        ArrayList<Action> actions = new ArrayList<>();
        int i = 0;

        try {
            Scanner scanner = new Scanner(actionListFile);
            do {
                actionStringArrayList.add(scanner.nextLine());
                i++;
            }
            while(scanner.hasNextLine());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //splits each element by delimiter ":" and creates action objects out of the substrings.
        for(i = 0; i<actionStringArrayList.size(); i++){
            String[] singularAction = actionStringArrayList.get(i).split(":");
            Action action = new Action(singularAction[0], singularAction[1]);
            actions.add(action);
        }
        return actions;
    }

}
