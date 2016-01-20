package com.example.yusuf.tddc73_project.PasswordForm;

//import com.example.yusuf.tddc73_project.PswForm;

/**
 * Created by Yusuf on 10/01/16.
 */

/**
 * Password must be at least 8 characters
 * Password must contain at least one uppercase letter
 * Password must contain at least one digit

 * Password is too short if < 8 characters
 * Password is weak if there are 8 characters but only one uppercase or only one digit
 * Password is strong if there are 8 characters and one uppercase and one digit


 * Strength is 0 if 0 characters
 * Strength is 1 if length is < 8
 * Strength is 2 or 3 if characters > 8 but only one digit or one uppercase
 * Strength is 4 if characters > 8 and contains one digit and one uppercase

 */

public class PswStrengthAlgorithm {

    private char c;

    public int calcPswStrength(String psw){

        int strengthDegree = 0;
        boolean boolArray[] = new boolean[3];

        int length = psw.length();
        if(length == 0){
            return strengthDegree;
        }

        if(length < 8){
            strengthDegree++;
            return strengthDegree;
        }
        else if(length >= 8){
            boolArray[0] = true; //first true because of length is larger than 8
            strengthDegree++;
            for(int i = 0; i < length; i++){
                c = psw.charAt(i);
                if(Character.isUpperCase(c)){
                    boolArray[1] = true; //Second true because uppercase
                }

                if(Character.isDigit(c)){
                    boolArray[2] = true; // third true because digit
                }
            }

            for(int j = 0; j < boolArray.length; j++ ){
                if(boolArray[j]) //if true degree increases
                    strengthDegree++;
            }

            return strengthDegree;
        }

        return 0;

    }


}
