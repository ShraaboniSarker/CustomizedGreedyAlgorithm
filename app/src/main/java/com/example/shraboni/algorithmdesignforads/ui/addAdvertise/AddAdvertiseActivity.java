package com.example.shraboni.algorithmdesignforads.ui.addAdvertise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shraboni.algorithmdesignforads.R;
import com.example.shraboni.algorithmdesignforads.adapter.AddAdvertiseAdapter;
import com.example.shraboni.algorithmdesignforads.model.addvertise.Advertise;

import java.util.ArrayList;

public class AddAdvertiseActivity extends AppCompatActivity {

    private AddAdvertiseAdapter addAdvertiseAdapter;
    private RecyclerView rvAddAdapter;
    private ArrayList<Advertise> addList;
    private EditText tvAddLength,etNoOfAds,etTimeSlot;
    private Button btnAddLength,btnShowResults;
    static ArrayList<ArrayList<Advertise>> probableAddList;
    String broadCast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_advertise);
        rvAddAdapter = findViewById(R.id.rvAddList);
        addList = new ArrayList<>();
        tvAddLength = findViewById(R.id.tvAddLength);
        btnAddLength = findViewById(R.id.btnAddLength);
        btnShowResults = findViewById(R.id.btnShowResults);
        etNoOfAds = findViewById(R.id.etNoOfAds);
        etTimeSlot = findViewById(R.id.etTimeSlot);
        probableAddList = new ArrayList<>();
        broadCast = "Dear user, you can broadcast advertise ";
        btnAddLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemNum = addList.size()+1;
                if(tvAddLength.getText() != null && !tvAddLength.getText().toString().isEmpty() && addList.size()<= 10)
                addList.add(new Advertise("Add "+itemNum+"  .........",tvAddLength.getText().toString()));
                addAdvertiseAdapter.notifyDataSetChanged();
            }
        });

        adapterAttached(addList);

        btnShowResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowResults();
            }
        });
    }

    public void adapterAttached(ArrayList<Advertise> listing){
        addAdvertiseAdapter = new AddAdvertiseAdapter(getApplicationContext(),listing);
        rvAddAdapter.setAdapter(addAdvertiseAdapter);
        LinearLayoutManager recycler = new LinearLayoutManager(AddAdvertiseActivity.this);
        addAdvertiseAdapter.notifyDataSetChanged();
        rvAddAdapter.setLayoutManager(recycler);
        rvAddAdapter.setHasFixedSize(false);
    }

    void ShowResults(){

        int noOfAdds = Integer.parseInt(etNoOfAds.getText().toString());
        int timeSlot =  Integer.parseInt(etTimeSlot.getText().toString());

        Log.i("ShowResults", "ShowResults:................ ");

        if(String.valueOf(noOfAdds) != null && !String.valueOf(noOfAdds).isEmpty() &&
                String.valueOf(timeSlot) != null && !String.valueOf(timeSlot).isEmpty()) {

            sum_up(addList, timeSlot);

            for (int i = 0; i < probableAddList.size(); i++) {
                if (noOfAdds == probableAddList.get(i).size()) {
                    for (int j = 0; j < probableAddList.get(i).size(); j++) {
                        broadCast = broadCast + probableAddList.get(i).get(j).getAddname();

                    }
                }
            }
        }
        Toast.makeText(this, broadCast, Toast.LENGTH_SHORT).show();
    }
    static void sum_up(ArrayList<Advertise> ads, int timeSlot) {
        sum_up_recursive(ads,timeSlot,new ArrayList<Advertise>());
    }
    static void sum_up_recursive(ArrayList<Advertise> numbers, int target, ArrayList<Advertise> partial) {
        int s = 0;
        for (Advertise x: partial) s += Integer.parseInt(x.getTime());
        if (s <= target)
            probableAddList.add(partial);
        Log.i("probableAddList", "sum_up_recursive:....... "+partial.size());
        if (s >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Advertise> remaining = new ArrayList<>();
            Advertise n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Advertise> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }
}