package com.example.yusuf.tddc73_project.AccountRegistration;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Yusuf on 16/12/15.
 *
 * Accountform can be created with parameters Context, String, textId, fieldId, requiredField.
 *
 * Or if the user wants to create a passwordfield parameters for createText follows
 * context, String text, int textId, int fieldId, boolean password, boolean requiredField
 *
 *
 * The textId and fieldId are defined by the user. And the Id's should be given in
 * ascending order from 1-100.
 *
 * The checkBoxId starts from 100
 *
 * and the buttonId starts from 200.
 *
 *
 */
public class AccountForm extends LinearLayout{

    public AccountForm(Context theContext){
        super(theContext);

    }

    public void addRow(Row row){
        
        setOrientation(VERTICAL);
        addView(row);

    }

    public void createBox(Context context, String text){

        CheckBox acceptBox = new CheckBox(context);
        acceptBox.setText(text);

        setOrientation(VERTICAL);
        addView(acceptBox);

    }
    public void createBtn(Context context, String text){

        Button btn = new Button(context);
        btn.setText(text);

        setOrientation(VERTICAL);
        addView(btn);

    }


}
