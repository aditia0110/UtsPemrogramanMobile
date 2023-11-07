## **Repositori ini dibuat untuk memenuhi penilaian tengah semester matakuliah pemrograman mobile**  
Nama : Aditia Seftiawan  
Nim : 312210094  
Kelas : TI.22.B1  
Mata Kuliah : Pemrograman Mobile  
**Tugas : Membuat tombol yang setiap diklik dapat bertambah angkanya, namun dengan urutan angka fibonacci, lalu lengkapi dengan fitur toast**  
berikut adalah link video aplikasi yang di jalankan (dijalankan pada device menggunakan usb debugging) : [tonton video](https://youtu.be/uteJoBawN_Y)  
<br>
Source Code:  
* toast_activity.Xml (dibuat dengan design pada android studio):
  
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:background="#eeeeee"
        android:orientation="vertical"
        android:padding="40dp"
        android:paddingRight="40dp">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Increment"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textViewNumber"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="0"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Fibonnaci"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textViewNumberFibo"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="0"
            android:textFontWeight="600"
            android:textColor="@color/black"
            android:textAlignment="center"
            android:textSize="24sp" />
    </LinearLayout>

    <Button
        android:id="@+id/button_toast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentLeft="true"
        style="@style/Widget.AppCompat.Button"
        android:text="Toast" />
    <Button
        android:id="@+id/button_reset"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Reset"
        android:layout_margin="10dp"
        android:backgroundTint="@color/red"
        android:textColor="@color/white"
        android:textAlignment="center"/>
    <Button
        android:id="@+id/button_hitung"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:backgroundTint="@color/teal_700"
        android:layout_marginRight="10dp"
        android:textColor="@color/white"
        android:text="Hitung"/>
        
    </RelativeLayout>


Penjelasan :  
1. kita isi relative layout dengan 2 linear layout
2. linear layout1 diisi dengan 3 textview:
   * nama + nim
   * jumlah klik pada tombol hitung
   * angka fibonacci terakhir
3. linear layout 2 berisi :
   * button hitung
   * button reset
   * dan button toast  

* MainActivity.Java :

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

  * colors.xml (untuk menambahkan warna)
``` Java
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="biru">#0000ff</color>
    <color name="red">#D10000</color>

    <color name="colorPrimary">#3F51B5</color>
    <color name="colorPrimaryDark">#303F9F</color>
    <color name="colorAccent">#FF4081</color>
    <color name="kuning">#FFFF00</color>
    <color name="purple_200">#FFBB86FC</color>
    <color name="purple_500">#FF6200EE</color>
    <color name="purple_700">#FF3700b3</color>
    <color name="teal_200">#FF03DAC5</color>
    <color name="teal_700">#FF018786</color>

</resources>
```
* string.xml (untuk type data text)

  ``` Java
  <resources>
    <string name="app_name">MyApplication</string>
    <string name="button_main">Toast</string>
    <string name="button_label_hitung">Hitung</string>
    <string name="hitung_initial_value">0</string>
    <string name="toast_pesan">Halo saya Aditia Seftiawan</string>
</resources> 


kurang lebihnya mohon maaf 

Terimakasih
