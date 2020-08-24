package com.example.myfarm.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfarm.R;
import com.google.android.material.snackbar.Snackbar;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class InputFertilizerFrag extends Fragment {

    Spinner spinner;
    Button confirm;
    EditText mat1,mat2,mat3,mat4;
    TextView dateTV;
    String NAME_S,DATE_S,S;
    String[] MATS_ARRAY = new String[4];

    fragmentListener mListener;
    PersianDatePickerDialog picker;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        mListener = (fragmentListener) context;


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fertilizer_input_frag, null);

        spinner = rootView.findViewById(R.id.f_spinner);
        confirm = rootView.findViewById(R.id.f_button);
        mat1 = rootView.findViewById(R.id.m2ETX);
        mat2 = rootView.findViewById(R.id.m1ETX);
        mat3 = rootView.findViewById(R.id.m3ETX);
        mat4 = rootView.findViewById(R.id.m4ETX);
        dateTV = rootView.findViewById(R.id.f_dateTV);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                done();
            }
        });



        PersianCalendar persianCalendar = new PersianCalendar();
        persianCalendar.setPersianDate(1399, 2, 15);


        picker = new PersianDatePickerDialog(getActivity()).setPositiveButtonString("تایید")
                .setNegativeButton("لغو")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setInitDate(persianCalendar)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setMinYear(1300)
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        Toast.makeText(getActivity(), persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                        S = persianCalendar.getPersianYear() + " / " + persianCalendar.getPersianMonth() + " / " + persianCalendar.getPersianDay() + "  ";
                        int day = persianCalendar.getPersianDay();
                        String dayS;
                        switch (day){
                            case 1:
                                dayS = "شنبه";
                                break;
                             case 2:
                                 dayS = "یکشنبه";
                                break;

                            case 3:
                                dayS = "دوشنبه";
                                break;
                            case 4:
                                dayS = "سه شنبه";
                                break;
                            case 5:
                                dayS = "چهارشنبه";
                                break;
                            case 6:
                                dayS = "پنجشنبه";
                                break;
                            case 7:
                                dayS = "جمعه";
                                break;
                                default:
                                    dayS = " ";
                                    break;
                        }
                        dateTV.setText(S);

                    }

                    @Override
                    public void onDismissed() {

                    }
                });


        dateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.show();

            }
        });






        return rootView;
    }

    private void done(){
        DATE_S = dateTV.getText().toString();
        MATS_ARRAY[0] = mat1.getText().toString().trim();
        MATS_ARRAY[1] = mat2.getText().toString().trim();
        MATS_ARRAY[2] = mat3.getText().toString().trim();
        MATS_ARRAY[3] = mat4.getText().toString().trim();

        mListener.onFragmentFinish(" " , MATS_ARRAY, DATE_S);



    }

    public interface fragmentListener{
        void onFragmentFinish(String GARDEN_NAME, String[] MATERIALS, String DATE);
    }



}
