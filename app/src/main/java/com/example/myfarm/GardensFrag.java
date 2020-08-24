package com.example.myfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfarm.DataBase.GardenEntity;
import com.example.myfarm.viewModel.GardenViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static android.app.Activity.RESULT_OK;

public class GardensFrag extends Fragment {

    public static final int NEW_GARDEN_ACTIVITY_REQUEST_CODE = 1;
    GardenViewModel gardenViewModel;
    GardensRecycleAdapter adapter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gardens,null);
        final LinearLayout linearLayout = rootView.findViewById(R.id.GL0);
        recyclerView = rootView.findViewById(R.id.recyclerGarden);
        final Button buttonSample = rootView.findViewById(R.id.buttonSample);
         adapter = new GardensRecycleAdapter(this);
         recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
         recyclerView.setAdapter(adapter);



         buttonSample.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 GardenEntity g1 = gardenViewModel.getByName("اصلی");
                 String ss = g1.getType1();
                 buttonSample.setText(ss);
                 if (adapter.getItemCount() != 0){
                     int a = adapter.getItemCount();
                     String s = Integer.toString(a);
                     Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                     recyclerView.setVisibility(View.VISIBLE);
                     linearLayout.setVisibility(View.INVISIBLE);
                 }
             }
         });



        FloatingActionButton FAB = rootView.findViewById(R.id.fab);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GardenInputActivity.class);
                startActivityForResult(intent,NEW_GARDEN_ACTIVITY_REQUEST_CODE);
            }
        });



        initViewModel();


        return rootView;




    }

    private void initViewModel() {

        gardenViewModel = ViewModelProviders.of(this).get(GardenViewModel.class);
        gardenViewModel.getAllGardens().observe(this, new Observer<List<GardenEntity>>() {
            @Override
            public void onChanged(final List<GardenEntity> gardenEntities) {
                adapter.setmGardens(gardenEntities);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_GARDEN_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            GardenEntity gardenEntity = new GardenEntity(data.getStringExtra("name"),data.getIntExtra("age",0),
                    data.getStringExtra("type1"),"type2","type3","type4",5,5);
            gardenViewModel.insert(gardenEntity);

            Toast.makeText(getContext(),"Successful",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getContext(),"Something went wrong!",Toast.LENGTH_SHORT).show();
        }

    }
}

