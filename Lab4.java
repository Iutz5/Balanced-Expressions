/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.util.Stack;

/**
 *
 * @author ianutz
 */
public class Lab4 {

    /**
     * @param c the character in the String
     * @return whether or not the character is an open bracket, brace, or parenthesis (,{,[
     */
    public static boolean isOpenChar(char c){
        boolean toReturn; // standard local boolean, will change within the code depending on the conditional
        toReturn = c=='['||c=='{'||c=='('; // if it is any other character besides these 3, then it is not an open character
        return toReturn;
    }
    /**
     * 
     * @param c the character in the String
     * @return whether or not the character is a closed bracket, brace, or parenthesis ),},]
     */
    public static boolean isClosedChar(char c){
        boolean toReturn;
        if (c==']'||c=='}'||c==')'){  // standard local boolean, will change within the code depending on the conditional
            toReturn = true;
        } else { // if it is any other character besides these 3, then it is not a closed character
            toReturn = false;
        }
        return toReturn;
    }
    /**
     * 
     * @param c the previous open character in the stack
     * @param holder the current closed character
     * @return whether or not the two characters match (),{},[]
     */
    public static boolean isPair(char c, char holder){
        boolean toReturn;
        if(c=='('&&holder==')'){
            toReturn = true;
        } else if (c=='{'&&holder=='}'){
            toReturn = true;
        } else if (c=='['&& holder == ']'){
            toReturn = true;
        } else {
            toReturn = false;
        }
        return toReturn;
    }
    /**
     * 
     * @param expString the expression that the user inputs
     * @return whether or not the expression is balanced (has the same amount of paired brackets, braces, and/or parenthesis
     */
    public static boolean isBalanced(String expString){
        boolean toReturn = true;
        Stack <Character> expStack = new Stack <Character>();
        int i = 0;
        while (toReturn && i < expString.length()){
                char c = expString.charAt(i);
                System.out.println(c);
                if (isOpenChar(c)){
                    expStack.push(c);
                } else if (isClosedChar(c)){
                    if (expStack.isEmpty()){
                        System.out.println("There are more closed brackets than open brackets");
                        toReturn = false;
                    }else if (!isPair(expStack.pop(),c)){
                        System.out.println("The open character " + expStack.pop() + " and the closed character " + c + " do not match.");
                        toReturn = false;
                    }
                }
                i++;
            }
        return toReturn;
    }
    public static void main(String[] args) {
        Stack <Integer> trays = new Stack<Integer>();
        trays.push(1);
        trays.push(42);
        
        System.out.println("Trays: "+trays);
        Integer holder = trays.pop();
        System.out.println("Holder: "+holder);
        System.out.println("Trays: "+trays);
        String expression = "(4+6)((9+(10*2)) ";
        System.out.println(isBalanced(expression));
    }
    
}
