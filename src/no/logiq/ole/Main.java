package no.logiq.ole;

import java.util.ArrayList;


public class Main {

    public static void main(String args[]){

        System.out.println("Reading files from input folder...");
        //makes an uI object so it's methods can be used.
        UserInterfaceUtility userInterfaceUtility = new UserInterfaceUtility();
        String[] fileNameArray = userInterfaceUtility.folderReader();

        //prints the fileNameArray to console.
        userInterfaceUtility.printFileNameArray(fileNameArray);
        userInterfaceUtility.inputVerifier(userInterfaceUtility.inputReader(), fileNameArray);
        //closes scanner to avoid resource leak
        userInterfaceUtility.closeScanner();

        ActionListReader actionListReader = new ActionListReader();
        //gets file with verified filename and sends this to the ActionlistReader
        ArrayList<Action> actions = actionListReader.actionListReader(userInterfaceUtility.getVerifiedFile());

        //loops through actions, execute said actions and prints result.
        for(int i = 0; i < actions.size(); i++){
            Action a = actions.get(i);
            a.executeAction();
            System.out.println("Text: " + "[" + a.getText() + "]" +
                               " ran Action: " + a.getAction() +
                               " with Result: " + a.getResultString() );
        }
    }



}
