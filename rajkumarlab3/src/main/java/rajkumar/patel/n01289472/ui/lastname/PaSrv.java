package rajkumar.patel.n01289472.ui.lastname;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import rajkumar.patel.n01289472.R;

//Name: Rajkumar Patel
//Student ID: N01289472
//Section: RNA

public class PaSrv extends Fragment {

    EditText rajZipEt;
    Button rajWebBtn;
    String zipCode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pa_srv, container, false);

        rajZipEt = view.findViewById(R.id.rajZipEt);

        rajWebBtn = view.findViewById(R.id.rajWebBtn);
        rajWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zipCode = rajZipEt.getText().toString().trim();

                if (TextUtils.isEmpty(zipCode)) {
                    rajZipEt.setError(getString(R.string.error_message));
                    return;
                }

                if (zipCode.length() > 5) {
                    rajZipEt.setError(getString(R.string.error_message2));
                    return;
                }
            }
        });

        return view;
    }

    public boolean validZipCode(String myZipCode){

        boolean zipCode = myZipCode.contains(getString(R.string.zipcode_testcase));
        return zipCode;
    }
}