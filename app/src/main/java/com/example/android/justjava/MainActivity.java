package com.example.android.justjava;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int mQuantity=0;int initialPrice=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view) {
        mQuantity=mQuantity+1;
        if(mQuantity>100){
            Toast.makeText(this,"you cant increase..sorry",Toast.LENGTH_LONG).show();
            mQuantity=100;  }display(mQuantity);}

    public void decrement(View view) {mQuantity=mQuantity-1;
        if(mQuantity==0){
            Toast.makeText(this,"you cant decrease..sorry",Toast.LENGTH_LONG).show();
            mQuantity=1;}
        display(mQuantity);
    }

    private void display(int mQuantity) {

        TextView quantity=findViewById(R.id.text_view_quatity);
        quantity.setText(""+mQuantity);

    }

    private int displayPrice(int mQuantity) {
        return mQuantity*initialPrice;
    }

    private void displayMessage(String message){
        TextView price=findViewById(R.id.text_view_price);
        price.setText(message);
    }

    public void submitOrder(View view) {
        EditText enterName=findViewById(R.id.name_edit_text);
        String name=enterName.getText().toString();
        CheckBox whippedCream=findViewById(R.id.whippedcream_checkBox);
        Boolean addWhippedCream=whippedCream.isChecked();
        CheckBox choclate=findViewById(R.id.choclate_checkBox);
        Boolean addChoclate=choclate.isChecked();


        if(addWhippedCream){
            initialPrice+=1;
        }
        if(addChoclate){initialPrice+=2;
        }

        String message= this.getString(R.string.enterName)+name;
        message+="\n"+this.getString(R.string.addWhippedCream)+addWhippedCream;
        message+="\n"+this.getString(R.string.addChoclate)+addChoclate;
        message+="\n"+this.getString(R.string.quantity)+mQuantity;
        message+="\n"+this.getString(R.string.total)+displayPrice(mQuantity);
        message+= "\n"+this.getString(R.string.thank);
        displayMessage(message);
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_EMAIL,"nadingomaa4@gmail.com");
        intent.putExtra(intent.EXTRA_SUBJECT,"order");
        intent.putExtra(intent.EXTRA_TEXT,message);
        startActivity(intent);}}

