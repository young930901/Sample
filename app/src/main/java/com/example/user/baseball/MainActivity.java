package com.example.user.baseball;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private EditText eText;
    private TextView result;

    private EditText comText;
    private TextView comresult;

    private int userNumber;
    private int selectedNumber;

    private Button userBtn1;
    private Button userBtn2;
    private Button userBtn3;


    baseballAI ba = new baseballAI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askNumberDialog();

        userBtn1 = (Button)findViewById(R.id.button4);
        userBtn2 = (Button)findViewById(R.id.button5);
        userBtn3 = (Button)findViewById(R.id.button6);


        btn = (Button)findViewById(R.id.button7);
        eText = (EditText)findViewById(R.id.editText);
        result = (TextView)findViewById(R.id.textView);

        comText = (EditText)findViewById(R.id.editText2);
        comresult = (TextView)findViewById(R.id.textView2);


        btn.setOnClickListener(this);

    }
    public void gameOver(String name)
    {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        if(name == "user")
            myAlert.setMessage("User Won");
        else
            myAlert.setMessage("Computer Won");
        myAlert.setPositiveButton("Replay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                startActivity(getIntent());
            }
        })
                .setTitle("Alert")
                .create();
        myAlert.show();

    }
    public void alertDialog()
    {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("Please Pick a Number")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                })
                .setTitle("Alert")
                .create();
        myAlert.show();

    }
    public void validatePickNumber()
    {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("Please Pick a Number")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                        askNumberDialog();
                    }
                })
                .setTitle("Alert")
                .create();
        myAlert.show();

    }

    public void askNumberDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Number");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                if (input.getText().toString().length() == 3) {
                    userNumber = Integer.parseInt(input.getText().toString());
                    userBtn1.setText(input.getText().toString().substring(0, 1));
                    userBtn2.setText(input.getText().toString().substring(1, 2));
                    userBtn3.setText(input.getText().toString().substring(2, 3));
                    dialog.dismiss();
                } else {
                    validatePickNumber();
                }

            }
        });

        builder.show();
    }
    public void throwBall()
    {
        if(eText.getText().length() != 3)
        {
            alertDialog();
        }
        else
        {
            String r = "";
            for(int i=0; i<ba.match(eText.getText().toString()).size(); i++)
            {
                if(ba.match(eText.getText().toString()).get(i)=="S")
                {
                    r += "Strike! ";
                }
                else if(ba.match(eText.getText().toString()).get(i)=="B")
                {
                    r += "Ball! ";
                }
                else
                {
                    r += "Out! ";
                }
            }
            result.setText(r);
            vaidateGame(ba.match(eText.getText().toString()),"user");
        }
    }
    public void vaidateGame(ArrayList<String> arr, String name)
    {
        int count = 0;
        for(int i=0; i<arr.size(); i++)
        {
            if(arr.get(i).equals("S"))
            {
                count++;
            }
        }
        if(count == 3)
        {
            gameOver(name);
        }
        else
        {
            ba.createRandomNumber(Integer.toString(userNumber));
            if(ba.baseballAlgorithm(Integer.toString(userNumber)).equals("SSS")) {
                gameOver("Computer");
            }
            else
                comText.setText(ba.baseballAlgorithm(Integer.toString(userNumber)));
        }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button7:
                throwBall();
                break;
        }
    }
}
