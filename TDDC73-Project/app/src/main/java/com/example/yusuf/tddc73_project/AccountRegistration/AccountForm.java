package com.example.yusuf.tddc73_project.AccountRegistration;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Yusuf on 16/12/15.
 */
public class AccountForm extends RelativeLayout{

    TextView nameText, lastNameText, emailText, pswText;
    EditText nameInput, emailInput, lastNameInput, pswInput;
    CheckBox acceptBox;
    Button signUpBtn;

    public AccountForm(Context theContext){
        super(theContext);

        createForm(theContext);

    }

    public void createNameField(String nameText){
        
    }

    public void createForm(Context context){

        nameText = new TextView(context);
        nameText.setText("Name: ");

        lastNameText = new TextView(context);
        lastNameText.setText("Last name: ");

        pswText =  new TextView(context);
        pswText.setText("Password: ");

        emailText = new TextView(context);
        emailText.setText("E-mail: ");

        nameInput = new EditText(context);
        nameInput.setWidth(600);
        nameInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME);

        lastNameInput = new EditText(context);
        lastNameInput.setWidth(600);

        pswInput = new EditText(context);
        pswInput.setWidth(600);
        pswInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        emailInput = new EditText(context);
        emailInput.setWidth(600);
        emailInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        acceptBox = new CheckBox(context);
        acceptBox.setText("I accept the Terms of Use");

        signUpBtn = new Button(context);
        signUpBtn.setText("Sign Up");


        nameText.setId(1);
        emailText.setId(3);
        nameInput.setId(4);
        emailInput.setId(6);
        lastNameText.setId(7);
        lastNameInput.setId(8);
        acceptBox.setId(9);
        pswText.setId(10);
        pswInput.setId(11);
        signUpBtn.setId(12);


       RelativeLayout.LayoutParams nameTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        nameTextParams.addRule(RelativeLayout.ALIGN_LEFT);
        nameTextParams.setMargins(0, 70, 0, 80);

        RelativeLayout.LayoutParams lastNameTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        lastNameTextParams.addRule(RelativeLayout.BELOW, nameText.getId());
        lastNameTextParams.setMargins(0, 0, 0, 70);

        RelativeLayout.LayoutParams pswTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        pswTextParams.addRule(RelativeLayout.BELOW, lastNameText.getId());
        pswTextParams.setMargins(0, 0, 0, 70);

        RelativeLayout.LayoutParams emailTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailTextParams.addRule(RelativeLayout.BELOW, pswText.getId());
        //emailTextParams.setMargins(0, 0, 0, 40);


        RelativeLayout.LayoutParams nameInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        nameInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        nameInputTextParams.addRule(RelativeLayout.RIGHT_OF, nameText.getId());
        nameInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout.LayoutParams lastNameInputParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        lastNameInputParams.addRule(RelativeLayout.BELOW, nameInput.getId());
        lastNameInputParams.addRule(RelativeLayout.RIGHT_OF, lastNameText.getId());
        lastNameInputParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout.LayoutParams pswInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        pswInputTextParams.addRule(RelativeLayout.BELOW, lastNameInput.getId());
        pswInputTextParams.addRule(RelativeLayout.RIGHT_OF, pswText.getId());
        pswInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout.LayoutParams emailInputTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailInputTextParams.addRule(RelativeLayout.BELOW, pswInput.getId());
        emailInputTextParams.addRule(RelativeLayout.RIGHT_OF, emailText.getId());
        emailInputTextParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        RelativeLayout.LayoutParams acceptBoxParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        acceptBoxParams.addRule(RelativeLayout.BELOW, emailText.getId());


        RelativeLayout.LayoutParams signUpBtnParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        signUpBtnParams.addRule(RelativeLayout.BELOW, acceptBox.getId());
        signUpBtnParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        addView(nameText, nameTextParams);
        addView(lastNameText, lastNameTextParams);
        addView(pswText, pswTextParams);
        addView(emailText, emailTextParams);
        addView(nameInput, nameInputTextParams);
        addView(lastNameInput, lastNameInputParams);
        addView(pswInput, pswInputTextParams);
        addView(emailInput, emailInputTextParams);
        addView(acceptBox, acceptBoxParams);
        addView(signUpBtn, signUpBtnParams);

    }
}
