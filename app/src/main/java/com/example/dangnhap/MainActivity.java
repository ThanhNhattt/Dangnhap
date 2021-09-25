package com.example.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtname, edtpassword;
    Button btnDangNhap, btnHuyBo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = (EditText) findViewById(R.id.idname);
        edtpassword = (EditText) findViewById(R.id.idpassword);
        btnDangNhap = (Button) findViewById(R.id.buttonDangNhap);
        btnHuyBo = (Button) findViewById(R.id.buttonHuyBo);

        btnDangNhap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.buttonDangNhap):
                if (edtname.getText().toString().equals("thanhnhat") && edtpassword.getText().toString().equals("1223")) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    //chuyển từ main qua ds ativity
                    Intent ds = new Intent(MainActivity.this, DanhSach.class);
                    //chuyển tài khoản và mật khẩu qua file danh sách ativity
                    ds.putExtra("Tai Khoan",edtname.getText().toString());
                    ds.putExtra("Mat Khau",edtname.getText().toString());
                    startActivity(ds);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
        }
    }
}