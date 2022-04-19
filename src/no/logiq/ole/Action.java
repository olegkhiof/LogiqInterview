package no.logiq.ole;

import java.util.HashSet;

public class Action {
    private String action;
    private String text;
    private String resultString;

    protected Action(String action, String text) {
        this.action = action;
        this.text = text;
        formatString();
    }
    //formats the string
    private void formatString() {
    text =text.replace("<","");
    text =text.replace(">","");
    action =action.replace("<","");
    action =action.replace(">","");
    }
    //executes action method based on keyword
    protected void executeAction(){
        switch (action){
            case "PALINDROME":
                palindrome(text);
                break;

            case "WHITESPACE":
                whitespace(text);
                break;

            case "REVERSE":
                reverse(text);
                break;

            case "UNIQUE_COUNT":
                unique_count(text);
                break;

            case"CAPITALIZE":
                capitalize(text);
                break;

            default:
                resultString = "No implementation found for Action: " + action;

        }

    }


    private void palindrome(String text){
        boolean resultBoolean;
        resultBoolean = text.equals(reverse(text));
        resultString = Boolean.toString(resultBoolean);
    }

    private void whitespace(String text){
        resultString = text.replaceAll(" ", "");
    }

    private String reverse(String text){
        //reverses the text using StringBuilder
        resultString = new StringBuilder(text).reverse().toString();
        return resultString;
    }

    private void unique_count(String text){
        //uses a character hashset to reduce to only unique char's
        HashSet<Character> hashSet = new HashSet<>();
        for(int i = 0; i < text.length(); i++){
            hashSet.add(text.charAt(i));
        }
        int temp = hashSet.size();
        resultString  = Integer.toString(temp);

    }

    private void capitalize(String text){
        //Capitalizes first letter and de-capitalizes rest of letters to be lowercase.
        resultString = text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    //overrides default toString, for debugging.
    @Override
    public String toString(){
        return action + ":" + text;
    }

    public String getAction() {
        return action;
    }

    public String getResultString() {
        return resultString;
    }

    public String getText() {
        return text;
    }

}
