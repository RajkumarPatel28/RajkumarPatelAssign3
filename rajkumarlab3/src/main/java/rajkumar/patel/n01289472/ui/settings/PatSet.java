package rajkumar.patel.n01289472.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

import rajkumar.patel.n01289472.R;

//Name: Rajkumar Patel
//Student ID: N01289472
//Section: RNA

public class PatSet extends Fragment {

    SeekBar rajSeekBar;
    LinearLayout rajLinearLayout;
    RadioButton rajcolour1, rajcolour2, rajcolour3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pat_set, container, false);

        rajLinearLayout = view.findViewById(R.id.rajLinearLayout);

        rajcolour1 = view.findViewById(R.id.rajcolour1);
        rajcolour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rajLinearLayout.setBackgroundColor(Color.GREEN);
            }
        });

        rajcolour2 = view.findViewById(R.id.rajcolour2);
        rajcolour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rajLinearLayout.setBackgroundColor(Color.BLUE);
            }
        });

        rajcolour3 = view.findViewById(R.id.rajcolour3);
        rajcolour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rajLinearLayout.setBackgroundColor(Color.YELLOW);
            }
        });

        rajSeekBar = view.findViewById(R.id.rajSeekBar);
        Context context = getActivity().getApplicationContext();

        rajSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Context context = getActivity().getApplicationContext();

                boolean writeSettings = Settings.System.canWrite(context);

                if (writeSettings) {

                    int brightnessValue = progress * 255 / 100;

                    Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                    Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightnessValue);
                } else {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        int screenBrightness = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
        rajSeekBar.setProgress(screenBrightness);

        return view;
    }

}