package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount =0;
    private int mCountFibo =0;
    private TextView mShowCount;
    private TextView mShowCountFibo;
    private Button buttonToast;
    private Button buttonHitung;
    private Button buttonReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_activity);
        mShowCount = (TextView) findViewById(R.id.textViewNumber);
        mShowCountFibo = (TextView) findViewById(R.id.textViewNumberFibo);
        buttonToast = (Button) findViewById(R.id.button_toast);
        buttonHitung = (Button) findViewById(R.id.button_hitung);
        buttonReset = (Button) findViewById(R.id.button_reset);

        buttonHitung.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { hitungIncrement(view);}
        });
        buttonToast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { showToast(view);}
        });
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { resetCountDanFibbo(view);}
        });
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(this,R.string.toast_pesan, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void hitungIncrement(View view){
        mCount++;
        int fibo = hitungFibonacci(mCount);
        mCountFibo = fibo;
        if (mShowCount != null && mShowCountFibo != null){
            mShowCount.setText(Integer.toString(mCount));
            mShowCountFibo.setText(Integer.toString(mCountFibo));
        }
    }

    public int hitungFibonacci(int n){
        if (n <= 1){
            return n;
        }
        int prev = 0;
        int current = 1;
        for(int i = 2; i <= n; i++){
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }
    public void resetCountDanFibbo(View view){
        mCount = 0;
        mCountFibo = 0;
        mShowCount.setText(Integer.toString(mCount));
        mShowCountFibo.setText(Integer.toString(mCountFibo));
    }
}
