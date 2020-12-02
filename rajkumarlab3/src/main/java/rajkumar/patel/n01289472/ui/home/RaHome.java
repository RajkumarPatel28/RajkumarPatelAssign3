package rajkumar.patel.n01289472.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;

import rajkumar.patel.n01289472.R;

//Name: Rajkumar Patel
//Student ID: N01289472
//Section: RNA

public class RaHome extends Fragment {

    TextView rajDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ra_home, container, false);

        Calendar date = Calendar.getInstance();
        String currentdate = DateFormat.getDateInstance(DateFormat.FULL).format(date.getTime());
        rajDate = view.findViewById(R.id.rajDate);
        rajDate.setText(currentdate);

        return view;
    }
}
