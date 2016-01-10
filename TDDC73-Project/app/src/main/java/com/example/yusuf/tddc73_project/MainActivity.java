package com.example.yusuf.tddc73_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.example.yusuf.tddc73_project.AccountRegistration.AccountForm;
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

        PswForm pswForm = new PswForm(this, pswAlgorithm, checkStrength);

        /*RelativeLayout.LayoutParams myLayoutPswFormParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);*/


        myLayout.addView(pswForm);
        //myLayout.addView(accountForm);
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
