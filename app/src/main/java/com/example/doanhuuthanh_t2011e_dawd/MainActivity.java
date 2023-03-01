package com.example.doanhuuthanh_t2011e_dawd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edName, edDesignation, edSalary;

    Button btAdd, btUpdate, btDelete;
    AppDatabase db;

    RecyclerView rvEmp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);

        edName = findViewById(R.id.edName);
        edDesignation = findViewById(R.id.edDesignation);
        edSalary = findViewById(R.id.edSalary);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);
        btAdd.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);

        List<Employee> list = db.employeeDao().getAllEmp();

        EmpAdapter adapter = new EmpAdapter(this, list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvEmp = findViewById(R.id.rvEmp);
        rvEmp.setLayoutManager(layoutManager);
        rvEmp.setAdapter(adapter);

    }

    private void onAdd() {

        Employee employee = new Employee();
        employee.name = edName.getText().toString();
        employee.designation = edDesignation.getText().toString();
        employee.salary = edSalary.getText().toString();
        long id = db.employeeDao().insertEmp(employee);
        if (id > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                onAdd();
                break;
            default:
                break;
        }
    }
}