package net.falih.valuepersistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText dv, dbv;
    Button dvMinus, dvPlus, dbvMinus, dbvPlus;

    int directValue, dualBinaryValue1, dualBinaryValue2, inverseDualBinaryValue1, inverseDualBinaryValue2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dv          = (EditText) findViewById(R.id.editTextDirectValue);
        dbv         = (EditText) findViewById(R.id.editTextDualBinaryValue);
        dvMinus     = (Button) findViewById(R.id.buttonDirectValueMinus);
        dvPlus      = (Button) findViewById(R.id.buttonDirectValuePlus);
        dbvMinus    = (Button) findViewById(R.id.buttonDBVMinus);
        dbvPlus     = (Button) findViewById(R.id.buttonDBVPlus);

        dv.setText(String.valueOf(directValue));
        dbv.setText(String.valueOf(dualBinaryValue1+dualBinaryValue2));

        dvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directValue--;
                dv.setText(String.valueOf(directValue));
            }
        });

        dvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directValue++;
                dv.setText(String.valueOf(directValue));
            }
        });

        dbvMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if the inverse of both dual binary values are valid
                if((inverseDualBinaryValue1 == (dualBinaryValue1*-1)) && (inverseDualBinaryValue2 == (dualBinaryValue2*-1))){
                    // decrement the previous result value by 1
                    int tempValue = (dualBinaryValue1 + dualBinaryValue2) - 1;
                    Random randomGenerator = new Random();
                    int initialDualBinaryValue = randomGenerator.nextInt(1000) - randomGenerator.nextInt(500);
                    // assign new values
                    dualBinaryValue1 = initialDualBinaryValue;
                    dualBinaryValue2 = tempValue - initialDualBinaryValue;
                    // set the inverse of both values
                    inverseDualBinaryValue1 = dualBinaryValue1 * -1;
                    inverseDualBinaryValue2 = dualBinaryValue2 * -1;
                } else {
                    dualBinaryValue1 = 0;
                    dualBinaryValue2 = 0;
                    inverseDualBinaryValue1 = 0;
                    inverseDualBinaryValue2 = 0;
                }
                dbv.setText(String.valueOf(dualBinaryValue1+dualBinaryValue2));
            }
        });

        dbvPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("plus operation", "---- START ----");
                // check if the inverse of both dual binary values are valid
                if((inverseDualBinaryValue1 == (dualBinaryValue1*-1)) && (inverseDualBinaryValue2 == (dualBinaryValue2*-1))){
                    Log.d("plus operation", "validation success. Continue to generate new value..");
                    // increment the previous result value by 1
                    int tempValue = (dualBinaryValue1 + dualBinaryValue2) + 1;
                    Random randomGenerator = new Random();
                    int rand1 = randomGenerator.nextInt(1000);
                    int rand2 = randomGenerator.nextInt(500);
                    Log.d("plus operation", "rand1 = "+String.valueOf(rand1));
                    Log.d("plus operation", "rand2 = "+String.valueOf(rand2));
                    int initialDualBinaryValue =  rand1 - rand2;
                    // assign new values
                    dualBinaryValue1 = initialDualBinaryValue;
                    dualBinaryValue2 = tempValue - initialDualBinaryValue;
                    // set the inverse of both values
                    inverseDualBinaryValue1 = dualBinaryValue1 * -1;
                    inverseDualBinaryValue2 = dualBinaryValue2 * -1;
                    Log.d("plus operation", "dualBinaryValue1 = "+String.valueOf(dualBinaryValue1));
                    Log.d("plus operation", "dualBinaryValue2 = "+String.valueOf(dualBinaryValue2));
                } else {
                    Log.d("plus operation", "validation failed. Reset all values back to 0.");
                    dualBinaryValue1 = 0;
                    dualBinaryValue2 = 0;
                    inverseDualBinaryValue1 = 0;
                    inverseDualBinaryValue2 = 0;
                }
                Log.d("plus operation", "Result Value = "+String.valueOf(dualBinaryValue1+dualBinaryValue2));
                dbv.setText(String.valueOf(dualBinaryValue1+dualBinaryValue2));
            }
        });
    }
}
