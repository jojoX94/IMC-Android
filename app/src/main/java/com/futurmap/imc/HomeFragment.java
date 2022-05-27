package com.futurmap.imc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.futurmap.imc.utils.ConstraintRadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private SeekBar seekBar;
    private SeekBar seekBarTwo;
    private TextView lbl_height;
    private TextView lbl_weight;
    private ConstraintRadioGroup constraintRadioGroup;
    private ImageView img_men;
    private ImageView img_women;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seekBar = view.findViewById(R.id.seekBar);
        seekBarTwo = view.findViewById(R.id.seekBarTwo);
        seekBar.setMax(150);
        lbl_height = view.findViewById(R.id.lbl_height);
        lbl_weight = view.findViewById(R.id.lbl_weight);
        constraintRadioGroup = view.findViewById(R.id.radioGroup_gender);
        img_men = view.findViewById(R.id.img_men);
        img_women = view.findViewById(R.id.img_women);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                lbl_height.setText("" + (progress + 150) + " cm");
                lbl_height.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBarTwo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                lbl_weight.setText("" + (progress + 30) + " kg");
                lbl_weight.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        constraintRadioGroup.SetOnCheckedChangeListener(new ConstraintRadioGroup.OnCheckedChangeListener() {
            @Override
            public void OnCheckedChanged(ConstraintRadioGroup rg, int nCheckedId) {
                if (nCheckedId == R.id.check_men) {
                    img_men.setVisibility(View.VISIBLE);
                    img_women.setVisibility(View.GONE);
                } else {
                    img_women.setVisibility(View.VISIBLE);
                    img_men.setVisibility(View.GONE);
                }
            }
        });

    }
}