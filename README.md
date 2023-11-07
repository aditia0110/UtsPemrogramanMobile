## **Repositori ini dibuat untuk memenuhi penilaian tengah semester matakuliah pemrograman mobile**  
Nama : Aditia Seftiawan  
Nim : 312210094  
Kelas : TI.22.B1  
Mata Kuliah : Pemrograman Mobile  
**Tugas : Membuat tombol yang setiap diklik dapat bertambah angkanya, namun dengan urutan angka fibonacci, lalu lengkapi dengan fitur toast**  
berikut adalah link video aplikasi yang di jalankan (dijalankan pada device menggunakan usb debugging) : [tonton video](https://youtu.be/uteJoBawN_Y)  
<br>
Source Code:  
* activity_main.Xml (dibuat dengan design pada android studio):
  
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/white"
        android:gravity="center"
        android:orientation="vertical"
        android:paddingLeft="40dp"
        android:paddingRight="40dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Increment"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="0"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="Fibonacci"
            android:textAlignment="center"
            android:textSize="24sp" />

        <TextView
            android:id="@+id/textView4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:text="0"
            android:textAlignment="center"
            android:textFontWeight="600"
            android:textSize="24sp" />


    </LinearLayout>

    <Button
        android:id="@+id/button_toast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_alignParentBottom="true"
        android:layout_marginLeft="20dp"
        android:layout_marginBottom="15dp"
        android:backgroundTint="@color/biru"
        android:textColor="@color/white"
        android:text="Toast"/>
    <Button
        android:id="@+id/button_reset"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Reset"
        android:layout_marginTop="20dp"
        android:backgroundTint="@color/red"
        android:textColor="@color/white"
        android:layout_marginLeft="10dp"
        android:textAlignment="center"/>

    <Button
        android:id="@+id/button_hitung"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hitung"
        android:layout_marginBottom="15dp"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:layout_marginRight="20dp"
        android:backgroundTint="@color/biru"
        android:textColor="@color/white"/>
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
