package com.example.yusuf.tddc73_project.AccountRegistration;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Yusuf on 14/01/16.
 */
public class Row extends LinearLayout{

    public Row(Context context){
        super(context);

    }

    public Row(Context context, String text, boolean required){

        super(context);

        TextView textLabel= new TextView(context);
        textLabel.setText(text);

        EditText textField = new EditText(context);
        textField.setWidth(400);

        setOrientation(HORIZONTAL);

        if(required){
            TextView requiredLabel = new TextView(context);
            requiredLabel.setText("*Required Field");
            requiredLabel.setTextColor(Color.RED);

            addView(textLabel);
            addView(textField);
            addView(requiredLabel);

        }else {

            addView(textLabel);
            addView(textField);
        }

    }

    public Row(Context context, String text, boolean required, boolean psw){
        super(context);

        TextView textLabel = new TextView(context);
        textLabel.setText(text);
        //textLabel.setId(txtId);

        EditText textField = new EditText(context);
        textField.setWidth(400);
        textField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        setOrientation(HORIZONTAL);

        if(psw){


            if(required){
                TextView requiredLabel = new TextView(context);
                requiredLabel.setText("*Required Field");
                requiredLabel.setTextColor(Color.RED);

                //addComponentsToView(textLabel, textField, requiredLabel);
                addView(textLabel);
                addView(textField);
                addView(requiredLabel);
            }
        }
        else{
            addView(textLabel);
            addView(textField);
        }
    }

}
