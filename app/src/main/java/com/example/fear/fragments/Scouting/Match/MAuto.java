package com.example.fear.fragments.Scouting.Match;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.fear.R;
import com.example.fear.databinding.FragmentMatchAutoBinding;

public class MAuto {
    private FragmentMatchAutoBinding binding;
    private int totalAutoScoreL = 0;
    private int totalAutoScoreR = 0;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentMatchAutoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button autoPlusL = root.findViewById(R.id.autoPlusL);
        Button autoMinusL = root.findViewById(R.id.autoMinusL);
        Button autoPlusR = root.findViewById(R.id.autoPlusR);
        Button autoMinusR = root.findViewById(R.id.autoMinusR);
        TextView autoScoreL = root.findViewById(R.id.textView_upperScoreAuto);
        TextView autoScoreR = root.findViewById(R.id.textView_lowerScoreAuto);
        autoScoreL.setText(String.valueOf(totalAutoScoreL));
        autoScoreR.setText(String.valueOf(totalAutoScoreR));

        autoPlusL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalAutoScoreL++;
                autoScoreL.setText(String.valueOf(totalAutoScoreL));
            }
        });

        autoMinusL.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalAutoScoreL > 0){
                    totalAutoScoreL--;
                    autoScoreL.setText(String.valueOf(totalAutoScoreL));
                }
            }
        }));

        autoPlusR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalAutoScoreR++;
                autoScoreR.setText(String.valueOf(totalAutoScoreR));
            }
        });

        autoMinusR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalAutoScoreR > 0){
                    totalAutoScoreR--;
                    autoScoreR.setText(String.valueOf(totalAutoScoreR));
                }
            }
        });

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                BottomNavigationView teleAutoBar = root.findViewById(R.id.tele_auto_bar);
                NavigationUI.setupWithNavController(teleAutoBar, navController);
                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            }
        }, 10);
        return root;
    }

    @Override
    public void onDestroyView(){
        setRetainInstance(true);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        super.onDestroyView();
        binding = null;
    }
}
