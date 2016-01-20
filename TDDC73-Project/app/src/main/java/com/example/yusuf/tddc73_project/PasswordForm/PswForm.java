package com.example.yusuf.tddc73_project.PasswordForm;

/**
 * Created by Yusuf on 10/12/15.
 */

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * To use the component the user has to create the method in the main and
 * use the constructors, either the user provides their own algorithm for the password strength
 * or use the defualt one.
 *
 */

public class PswForm extends RelativeLayout {

    TextView  pswText, pswStrengthText;
    EditText pswInput;
    PswStrengthCheck checkPsw;
    PasswordInterface passwordInterface;

    PswStrengthAlgorithm pswStrength;

    public PswForm(Context theContext){
        super(theContext);
        pswStrength = new PswStrengthAlgorithm();
        checkPsw = new PswStrengthCheck(theContext);

        createForm(theContext);

    }

    public PswForm(Context theContext, PswStrengthAlgorithm pswAlgorithm){
        super(theContext);
        pswStrength = pswAlgorithm;

        createForm(theContext);

    }

    public PswForm(Context theContext, PswStrengthAlgorithm pswAlgorithm, PswStrengthCheck checkPswStrength){
        super(theContext);

        pswStrength = pswAlgorithm;
        checkPsw = checkPswStrength;

        createForm(theContext);
    }

    public void createForm(Context context){

        pswText = new TextView(context);
        pswText.setText("Password: ");

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
                checkPsw.checkPswStrength(pswStrength.calcPswStrength(pswInput.getText().toString()));
                changePswStrengthText(pswStrength.calcPswStrength(pswInput.getText().toString()));
                passwordInterface.passwordStrength(pswStrength.calcPswStrength(pswInput.getText().toString()));

            }

        });

        pswStrengthText = new TextView(context);
        pswStrengthText.setText("ENTER PASSWORD");

        pswText.setId(2);
        pswInput.setId(5);
        pswStrengthText.setId(7);

        RelativeLayout.LayoutParams pswTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        pswTextParams.addRule(RelativeLayout.ALIGN_START);
        pswTextParams.setMargins(0, 60, 0, 0);

        RelativeLayout.LayoutParams pswInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        pswInputTextParams.addRule(RelativeLayout.RIGHT_OF, pswText.getId());
        pswInputTextParams.addRule(RelativeLayout.ALIGN_END);


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

        addView(pswText, pswTextParams);
        addView(pswInput, pswInputTextParams);
        addView(checkPsw, colorBar1Params);
        addView(pswStrengthText, pswStrengthTextParams);
    }

    public void changePswStrengthText(int strength){

        if(strength == 0){
            pswStrengthText.setText("ENTER PASSWORD");
        }
        else if(strength == 1){
            pswStrengthText.setText("TOO SHORT");
        }
        else if(strength == 2){
            pswStrengthText.setText("WEAK PASSWORD");
        }
        else if(strength == 3){
            pswStrengthText.setText("STILL WEAK PASSWORD");
        }
        else if(strength == 4){
            pswStrengthText.setText("STRONG PASSWORD");
        }
    }

    public void setPasswordInterface(PasswordInterface passInt){

        passwordInterface = passInt;

    }
}
