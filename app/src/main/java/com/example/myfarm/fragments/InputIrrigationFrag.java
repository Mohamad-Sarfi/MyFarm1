package com.example.myfarm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myfarm.R;

public class InputIrrigationFrag extends Fragment {

    private SeekBar seekBar;
    private  int duration;
    String s,rgv;
    RadioGroup RG;
    RadioButton RB;
    int idInt;
    Button confirm;
    TextView TVd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.irrigation_input_frag, null);
        TVd = rootView.findViewById(R.id.seekBarTxt);

        seekBar = rootView.findViewById(R.id.seekBar);
        seekBar.setMax(48);
        RG = rootView.findViewById(R.id.radioGroup);

        idInt = RG.getCheckedRadioButtonId();
        RB = rootView.findViewById(idInt);
        confirm = rootView.findViewById(R.id.i_button);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                duration = seekBar.getProgress();
                s = "ساعت" + String.valueOf(duration);
                TVd.setText(s);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                done();
            }
        });



        return rootView;
    }


    private void done(){
        rgv = RB.getText().toString();
        duration = Integer.valueOf(TVd.getText().toString());
    }



    public interface irrigationFragListener{
        void onIrrigationFragFinish(String NAME, int DURATION, String DATE, String INTENSITY );
    }
}
