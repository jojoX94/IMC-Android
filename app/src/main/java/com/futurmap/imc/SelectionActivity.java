package com.futurmap.imc;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private SeekBar seekBarTwo;
    private TextView lbl_height;
    private TextView lbl_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        seekBar = findViewById(R.id.seekBar);
        seekBarTwo = findViewById(R.id.seekBarTwo);
        seekBar.setMax(150);
        lbl_height = findViewById(R.id.lbl_height);
        lbl_weight = findViewById(R.id.lbl_weight);

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
    }
}