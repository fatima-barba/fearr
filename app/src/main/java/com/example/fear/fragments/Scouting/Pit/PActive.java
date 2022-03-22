package com.example.fear.fragments.Scouting.Pit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.example.fear.R;
import com.example.fear.databinding.FragmentPitActiveBinding;

public class PActive {

    SeekBar seekBar;
    TextView textView;

    SeekBar seekBarAccuracy;
    TextView textViewAccuracy;



    private FragmentPitActiveBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPitActiveBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        seekBar = (SeekBar) root.findViewById(R.id. seekBarRating);
        textView = (TextView) root.findViewById(R.id.textViewRating);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("rating " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarAccuracy = (SeekBar) root.findViewById(R.id. seekBarAccuracy);
        textViewAccuracy = (TextView) root.findViewById(R.id.textViewAccuracy);

        seekBarAccuracy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textViewAccuracy.setText("accuracy " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        Button button = root.findViewById(R.id.savePitActive);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_pit_home);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
