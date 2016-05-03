package com.example.niems.sumpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String FIRST_ERROR = "an error has occurred :/";
    public static String SECOND_ERROR = "the error persists D:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateSum(View view){

        TextView result_view = (TextView) findViewById( R.id.calculation_result ); //gets the result view to modify
        TextView display_view = (TextView) findViewById( R.id.calculation_display ); //gets the display view to modify
        EditText num1_text = (EditText) findViewById( R.id.num1 ); //gets the view for num1
        EditText num2_text = (EditText) findViewById( R.id.num2 ); //gets the view for num2

        String message = ""; //message outputted for the result view
        String display_message = ""; //full solution displayed
        String result_message = ""; //result message displayed

        try{
            float num1 = Float.parseFloat( num1_text.getText().toString() );
            float num2 = Float.parseFloat( num2_text.getText().toString() );
            float sum = num1 + num2;

            result_message = "Result: " + Float.toString( sum );
            display_message = "Solution: " + Float.toString( num1 ) + " + " + Float.toString( num2 ) + " = " + Float.toString( sum );

            result_view.setText( result_message );
            display_view.setText( display_message );

        }catch(Exception e){
            display_message = filterMessage( display_message );
            result_message = "Result: N/A";

            display_view.setText( display_message );
            result_view.setText( result_message );
        }
    }

    public String filterMessage(String message){

        switch( message ){
            case "an error occurred :/":
                message = "the error persists D:";
                break;

            default:
                message = "an error occurred :/";
        }

        return message;
    }
}
