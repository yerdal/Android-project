package com.example.yusuf.tddc73_project;

/**
 * Created by Yusuf on 10/12/15.
 */

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Arrays;

public class FormGUI extends RelativeLayout {

    TextView nameText, pswText, emailText, ageText, pswStrengthText;
    EditText nameInput, pswInput, emailInput;
    pswStrengthCheck checkPsw;

    public FormGUI(Context theContext){
        super(theContext);

        createForm(theContext);



    }

    public void createForm(Context context){
        //CREATE THE PSW CHECK
        checkPsw = new pswStrengthCheck(context);


        nameText = new TextView(context);
        nameText.setText("Name: ");

        pswText = new TextView(context);
        pswText.setText("Password: ");

        emailText = new TextView(context);
        emailText.setText("E-mail: ");

        ageText = new TextView(context);
        ageText.setText("Age ");

        nameInput = new EditText(context);
        nameInput.setWidth(600);
        nameInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        pswInput = new EditText(context);
        pswInput.setWidth(600);
        pswInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        pswInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                checkPsw.invalidate();
                checkPsw.checkPswStrength(calcPswStrength(pswInput.getText().toString()));

            }

        });

        emailInput = new EditText(context);
        emailInput.setWidth(600);
        emailInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        pswStrengthText = new TextView(context);

        nameText.setId(1);
        pswText.setId(2);
        emailText.setId(3);
        nameInput.setId(4);
        pswInput.setId(5);
        emailInput.setId(6);
        pswStrengthText.setId(7);


        RelativeLayout.LayoutParams nameTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        nameTextParams.addRule(RelativeLayout.ALIGN_LEFT);
        nameTextParams.setMargins(0, 70, 0, 80);



        RelativeLayout.LayoutParams pswTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        pswTextParams.addRule(RelativeLayout.BELOW, emailText.getId());
        pswTextParams.setMargins(0, 60, 0, 0);

        RelativeLayout.LayoutParams emailTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailTextParams.addRule(RelativeLayout.BELOW, nameText.getId());
        //emailTextParams.setMargins(0, 0, 0, 40);


        RelativeLayout.LayoutParams nameInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        nameInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        nameInputTextParams.addRule(RelativeLayout.RIGHT_OF, nameText.getId());
        nameInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);


        RelativeLayout.LayoutParams pswInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        pswInputTextParams.addRule(RelativeLayout.BELOW, emailText.getId());
        pswInputTextParams.addRule(RelativeLayout.RIGHT_OF, pswText.getId());
        pswInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);


        RelativeLayout.LayoutParams emailInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailInputTextParams.addRule(RelativeLayout.BELOW, nameInput.getId());
        emailInputTextParams.addRule(RelativeLayout.RIGHT_OF, emailText.getId());
        emailInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout.LayoutParams pswStrengthTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        pswStrengthTextParams.addRule(RelativeLayout.BELOW, pswInput.getId());

        RelativeLayout.LayoutParams colorBar1Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        colorBar1Params.addRule(RelativeLayout.BELOW, pswStrengthText.getId());



        addView(nameText, nameTextParams);
        addView(pswText, pswTextParams);
        addView(emailText, emailTextParams);
        addView(nameInput,nameInputTextParams);
        addView(pswInput, pswInputTextParams);
        addView(emailInput, emailInputTextParams);
        addView(checkPsw, colorBar1Params);
        addView(pswStrengthText, pswStrengthTextParams);
    }

    //Password must be at least 8 characters
    //Password must contain at least two uppercase letter
    //Password must contain at least one digit

    //Password is too short if < 8 characters
    //Password is weak if only one uppercase or only one digit
    //Password is strong if both uppercase and one digit

    private char c;

    public int calcPswStrength(String psw){

        int strengthDegree = 0;
        boolean boolArray[] = new boolean[3];

        int length = psw.length();
        if(length == 0){
            pswStrengthText.setText("");
            return strengthDegree;
        }

        if(length < 8){
            //Log.d("TOO SHORT PASSWORD ", "LENGTH IS " + length);
            pswStrengthText.setText("TOO SHORT");
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
                //Log.d("ARRAY LENGTH", "LENGTH" + boolArray.length);
            for(int j = 0; j < boolArray.length; j++ ){
                if(boolArray[j])
                    strengthDegree++;

                if(strengthDegree == 2){
                    pswStrengthText.setText("WEAK PASSWORD");
                }

                if(strengthDegree == 4){
                    pswStrengthText.setText("STRONG PASSWORD");
                }
            }

            Log.d("STRENGTH DEGREE IS ", "STRENGTH" + strengthDegree);
            return strengthDegree;
        }

            return 0;

    }

}
