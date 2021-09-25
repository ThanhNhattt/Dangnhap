package com.example.dangnhap;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DanhSach extends AppCompatActivity {

    TextView txtThongBao;
    EditText txtTenMonHoc;
    Button btnThem, btnSua;
    ListView lstDS;
    ArrayList<String> arrmonhoc;
    int vitri=-1;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        txtThongBao = (TextView) findViewById(R.id.textViewThongBao);
        lstDS = (ListView) findViewById(R.id.listViewDS);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnSua = (Button) findViewById(R.id.buttonSua);
        txtTenMonHoc = (EditText) findViewById(R.id.txtTenMonHoc);


                Bundle bd = getIntent().getExtras();
                if(bd != null) {
                    txtThongBao.setText("Xin chao " + bd.getString("Tai Khoan") + "!");
                }
                //Tạo mảng các môn học
        arrmonhoc = new ArrayList<>();
        arrmonhoc.add("Android");
        arrmonhoc.add("SQL");
        arrmonhoc.add("C#");
        arrmonhoc.add("HTML");
        arrmonhoc.add("Asp.net");

                //Dùng ArrayAdapter để chứa dữ liệu đỗ vào listview
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, arrmonhoc);
        lstDS.setAdapter(adapter);

        lstDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtTenMonHoc.setText(arrmonhoc.get(i));
                vitri = i;
            }
        });

        lstDS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DanhSach.this);
                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn xóa hay không?");
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrmonhoc.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = txtTenMonHoc.getText().toString();
                arrmonhoc.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = txtTenMonHoc.getText().toString();
                arrmonhoc.set(vitri, monhoc);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
