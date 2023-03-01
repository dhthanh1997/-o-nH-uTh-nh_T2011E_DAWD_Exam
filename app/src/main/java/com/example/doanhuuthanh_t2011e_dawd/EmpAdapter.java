package com.example.doanhuuthanh_t2011e_dawd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmpAdapter extends RecyclerView.Adapter {

    Activity activity;
    List<Employee> list;

    public EmpAdapter(Activity activity, List<Employee> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.activity_main, parent, false);
        EmpHoler holer = new EmpHoler(itemView);
        return holer;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmpHoler vh = (EmpHoler) holder;
        Employee employee = list.get(position);
        vh.tvName.setText(employee.name);
        vh.tvDesignation.setText(employee.designation);
        vh.tvSalary.setText(employee.salary);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmpHoler extends RecyclerView.ViewHolder {
        TextView tvName, tvDesignation, tvSalary;
        public EmpHoler(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.edName);
            tvDesignation = itemView.findViewById(R.id.edDesignation);
            tvSalary = itemView.findViewById(R.id.edSalary);
        }
    }

}
