package rajkumar.patel.n01289472.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;

import rajkumar.patel.n01289472.DatePick;
import rajkumar.patel.n01289472.R;

//Name: Rajkumar Patel
//Student ID: N01289472
//Section: RNA

public class RaHome extends Fragment {

    Spinner rajSp;
    TextView rajDate;
    String[] coursesList;
    EditText rajDateEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ra_home, container, false);

        Calendar date = Calendar.getInstance();
        String currentdate = DateFormat.getDateInstance(DateFormat.FULL).format(date.getTime());
        rajDate = view.findViewById(R.id.rajDate);
        rajDate.setText(currentdate);

        coursesList = getResources().getStringArray(R.array.course_list);

        rajDateEt = view.findViewById(R.id.rajDateEt);
        rajDateEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new DatePick();
                fragment.show(getActivity().getSupportFragmentManager(), null);
            }
        });

        rajSp = view.findViewById(R.id.rajSp);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.browser_link_context_header, getResources().getStringArray(R.array.course_list));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rajSp.setAdapter(adapter);

        return view;
    }
}
