package rajkumar.patel.n01289472.ui.home;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.util.Calendar;

import rajkumar.patel.n01289472.R;

//Name: Rajkumar Patel
//Student ID: N01289472
//Section: RNA

public class RaHome extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner rajSp;
    TextView rajDate;
    EditText rajDateEt;
    ImageButton rajImageBtn;

    private DatePickerDialog.OnDateSetListener DateSet;
    private String Course;
    private String Date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ra_home, container, false);

        Calendar date = Calendar.getInstance();
        String currentdate = DateFormat.getDateInstance(DateFormat.FULL).format(date.getTime());
        rajDate = view.findViewById(R.id.rajDate);
        rajDate.setText(currentdate);

        rajSp = view.findViewById(R.id.rajSp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.course_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rajSp.setAdapter(adapter);
        rajSp.setOnItemSelectedListener(this);

        rajDateEt = view.findViewById(R.id.rajDateEt);
        rajDateEt.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, DateSet, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        DateSet = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Date = month + "|" + day + "|" + year;
                rajDateEt.setText(Date);
            }
        };

        rajImageBtn = view.findViewById(R.id.rajImageBtn);
        rajImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                String message = getString(R.string.course_selected) + Course + getString(R.string.date_selected) + Date;
                builder.setMessage(message);
                builder.setCancelable(true);

                builder.setPositiveButton(R.string.dialog_messageok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Course = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
