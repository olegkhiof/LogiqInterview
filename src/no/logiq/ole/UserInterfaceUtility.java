package no.logiq.ole;

import java.io.File;
import java.util.Scanner;

public class UserInterfaceUtility {
    //ignore ripped off https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_RED = "\u001B[31m";

    private Scanner scanner = new Scanner(System.in);
    private String userInputVerified;

    protected String[] folderReader(){
        //reads all files in folder into a string array
        File file = new File("src\\no\\logiq\\ole\\input");
        File[] files = file.listFiles();
        String[] tempFileNameArray = new String[files.length];
        for(int i = 0; i<files.length; i++){
            tempFileNameArray[i] = files[i].getName();
        }
        return tempFileNameArray;
    }

    protected void printFileNameArray(String[] fileNameArray){
        //checks if fileNameArray is empty.
        if(fileNameArray.length == 0 ){
            System.out.println( ANSI_RED + "\"input\" folder is empty! Please add the intended input files." + ANSI_RESET);
        }

        System.out.println("Please choose a file from the list below:");

        //prints all files in array to console.
        for(int i = 0; i < fileNameArray.length; i++){
            System.out.println(fileNameArray[i]);
        }
    }

    protected String inputReader(){
        //reads userinput
        String userInput = "userInput is empty.";
        try {
            userInput = scanner.nextLine();
        }
        catch(Exception e){
            System.out.println(ANSI_RED + "Exception: " + e + ANSI_RESET);
            System.exit(-1);
        }
        return userInput;
    }

    protected void closeScanner(){
        scanner.close();
    }

    protected void inputVerifier(String userInput, String[] fileNameArray){

        //verifies that userInput is in the filename array recursively
        for(int i = 0; i < fileNameArray.length; i++){
            if(fileNameArray[i].equals(userInput)){
                userInputVerified = userInput;
                break;
            }
            else if (i==fileNameArray.length-1){
                System.out.println(ANSI_RED+ "ERROR!\nFilename: \"" + userInput +
                        "\" does not exist in the Input folder. Did you misspell it? \n" + ANSI_RESET);
                inputVerifier(inputReader(), fileNameArray);;
            }
        }
    }

    protected File getVerifiedFile(){
        File file = new File("src\\no\\logiq\\ole\\input\\" + userInputVerified);
        return file;
    }
}
