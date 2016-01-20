package com.example.yusuf.tddc73_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.yusuf.tddc73_project.AccountRegistration.AccountForm;
import com.example.yusuf.tddc73_project.AccountRegistration.Row;
import com.example.yusuf.tddc73_project.PasswordForm.PasswordInterface;
import com.example.yusuf.tddc73_project.PasswordForm.PswForm;
import com.example.yusuf.tddc73_project.PasswordForm.PswStrengthAlgorithm;
import com.example.yusuf.tddc73_project.PasswordForm.PswStrengthCheck;

public class MainActivity extends AppCompatActivity {

    //AccountForm (more specified??)
    //PswForm
    //PswAlgorithm
    //StrengthCheck
    PswStrengthAlgorithm pswAlgorithm;
    PswStrengthCheck checkStrength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        RelativeLayout myLayout = new RelativeLayout(this);

        //PswForm pswForm = new PswForm(this);
        AccountForm accountForm = new AccountForm(this);

        pswAlgorithm = new PswStrengthAlgorithm();
        checkStrength = new PswStrengthCheck(this);

        //PswForm pswForm = new PswForm(this, pswAlgorithm, checkStrength);

        Row name = new Row(this, "Name: ", true);
        accountForm.addRow(name);

        Row lastName = new Row(this, "Last name: ", false);
        accountForm.addRow(lastName);

        Row email = new Row(this, "Email: ", true);
        accountForm.addRow(email);

        Row psw = new Row(this, "Password: ", true, true);
        accountForm.addRow(psw);

        accountForm.createBox(this, "I Agree to terms of use");
        accountForm.createBtn(this, "Sign up");

        //Feedback for the user when the password is strong enough
        /*pswForm.setPasswordInterface(new PasswordInterface() {
            @Override
            public void passwordStrength(int strength) {
                if (strength == 0) {
                   System.out.println("Empty password");
                }
                else if (strength == 1) {
                    System.out.println("Password is too short!");
                }
                else if(strength == 2){
                    System.out.println("Password is too weak!");
                }
                else if(strength == 3){
                    System.out.println("Still a weak password!");
                }
                else if(strength == 4){
                    System.out.println("Password is strong!");
                }
            }
        });*/

        //myLayout.addView(pswForm);
        myLayout.addView(accountForm);
        setContentView(myLayout);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
