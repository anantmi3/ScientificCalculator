package com.example.anant.scientificcalculator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import static java.lang.Math.*;
import java.text.DecimalFormat;
import com.example.anant.scientificcalculator.databinding.MainActivityBinding;
//import android.content.DialogInterface;
//import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    private static final char FACT = '!';
    private static final char POWER = '^';
    private static final String SQRT = "SQRT";

    private static final String SIN = "SIN";
    private static final String COS = "COS";
    private static final String TAN = "TAN";
    private static final String LOG = "LOG";

    private static final char LEFTC = '(';
    private static final char RIGHTC = ')';
    private static final String EXP = "EXP";
    private static final String PIE = "PIE";

    private static final char ADD = '+';
    private static final char SUBTRACT = '-';
    private static final char MULTIPlY = '*';
    private static final char DIVIDE = '/';

    private char CURRENT_ACTION;
    private String ADVANCE_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        binding.buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                        binding.editText.setText(binding.editText.getText() + ".");
            }
        });

        binding.buttonZero.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });

        binding.buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });

        binding.buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });

        binding.buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        binding.buttonFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });

        binding.buttonSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });

        binding.buttonSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });

        binding.buttonEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });

        binding.buttonNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        binding.buttonLeftC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "(");
            }
        });

        binding.buttonRightC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + ")");
            }
        });

        binding.buttonExp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                ADVANCE_ACTION = EXP;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "EXP");
                binding.editText.setText(null);
            }
        });

        binding.buttonPie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                ADVANCE_ACTION = PIE;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "PIE");
                binding.editText.setText(null);
            }
        });

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADD;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.editText.setText(null);
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACT;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.editText.setText(null);
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPlY;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
                binding.editText.setText(null);
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVIDE;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });

        binding.buttonFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = FACT;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "!");
                binding.editText.setText(null);
            }
        });

        binding.buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = POWER;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "^");
                binding.editText.setText(null);
            }
        });

        binding.buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                ADVANCE_ACTION = SQRT;
                binding.infoTextView.setText("SQRT(" + decimalFormat.format(valueOne) + ")");
                binding.editText.setText(null);
            }
        });

        binding.buttonSine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                ADVANCE_ACTION = SIN;
                binding.infoTextView.setText("SIN(" + decimalFormat.format(valueOne) + ")");
                binding.editText.setText(null);
            }
        });

        binding.buttonCosine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                ADVANCE_ACTION = COS;
                binding.infoTextView.setText("COS(" + decimalFormat.format(valueOne) + ")");
                binding.editText.setText(null);
            }
        });

        binding.buttonTangent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                ADVANCE_ACTION = TAN;
                binding.infoTextView.setText("TAN(" + decimalFormat.format(valueOne) + ")");
                binding.editText.setText(null);
            }
        });

        binding.buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                ADVANCE_ACTION = LOG;
                binding.infoTextView.setText("LOG(" + decimalFormat.format(valueOne) + ")");
                binding.editText.setText(null);
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.editText.getText().length() > 0) {
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.editText.setText("");
                    binding.infoTextView.setText("");
                }
            }
        });

    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if(CURRENT_ACTION == ADD)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACT)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPlY)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVIDE)
                valueOne = this.valueOne / valueTwo;
            else if(CURRENT_ACTION == FACT)
            {
                int i,valueThree=1;
                for(i=(int) valueOne;i>0;i--) //type conversion
                {
                    valueThree *= i;
                }
                valueOne = valueThree;
            }
            else if(CURRENT_ACTION == POWER)
                valueOne = Math.pow(valueOne,valueTwo);
            else if(ADVANCE_ACTION == SQRT)
                valueOne = Math.sqrt(valueOne);
            else if(ADVANCE_ACTION == SIN)
                valueOne = Math.sin(valueOne);
            else if(ADVANCE_ACTION == COS)
                valueOne = Math.cos(valueOne);
            else if(ADVANCE_ACTION == TAN)
                valueOne = Math.tan(valueOne);
            else if(ADVANCE_ACTION == LOG)
                valueOne = Math.log(valueOne);
            else if(ADVANCE_ACTION == PIE)
                valueOne = Math.PI;
            else if(ADVANCE_ACTION == EXP)
                valueOne = Math.E;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
