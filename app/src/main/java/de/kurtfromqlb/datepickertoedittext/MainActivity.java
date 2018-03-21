package de.kurtfromqlb.datepickertoedittext;
// http://androidlift.info/2015/10/23/date-picker-dialog-time-picker-dialog/
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

    public class MainActivity extends Activity implements View.OnClickListener{

        EditText etDate;
        private int mYear, mMonth, mDay;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etDate = (EditText) findViewById(R.id.etDate);

            etDate.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {

        if (v == etDate) {

            // Process to get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // Launch Date Picker Dialog
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // Display Selected date in EditText
                            etDate.setText(dayOfMonth + "."
                                    + (monthOfYear + 1) + "." + year);
                        }
                    }, mYear, mMonth, mDay);
            dpd.show();
        }
    }
}
