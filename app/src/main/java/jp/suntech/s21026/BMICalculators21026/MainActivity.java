package jp.suntech.s21026.BMICalculators21026;

import static java.sql.Types.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.bt_math);
        HelloListener listener = new HelloListener();
        btClick.setOnClickListener(listener);

        Button btClear=findViewById(R.id.bt_clear);
        btClear.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText et1 = findViewById(R.id.etage);
            EditText et2 = findViewById(R.id.ethei);
            EditText et3 = findViewById(R.id.etwei);


            TextView output =findViewById(R.id.b02);
            TextView output2 =findViewById(R.id.b01);
            TextView output3 =findViewById(R.id.b03);
            TextView output4 =findViewById(R.id.b04);
            TextView output5 =findViewById(R.id.b05);

            String str1=et1.getText().toString();
            String str2=et2.getText().toString();
            String str3=et3.getText().toString();


            double age = Double.parseDouble(str1);
            double hei = Double.parseDouble(str2);
            double wei = Double.parseDouble(str3);


            double bmi = wei/((hei/100)*(hei/100));
            double tekise_db = 22*(hei/100)*(hei/100);
            double teki = Math.round(tekise_db*10);
            String tekise = String.valueOf(teki/10);
            int id = view.getId();
            int frag = 0;




                switch (id) {
                    case R.id.bt_math:
                        if (age < 17) {
                            BMIDialogFragment dialog = new BMIDialogFragment();
                            dialog.show(getSupportFragmentManager(), "my_dialog");
                        }
                            if (bmi < 18.5) {
                                output.setText("低体重(やせ型)");
                            } else if (bmi < 25) {
                                output.setText("普通体重(適正)");
                            } else if (bmi < 30) {
                                output.setText("肥満(1度)");
                            } else if (bmi < 35) {
                                output.setText("肥満(2度)");
                            } else if (bmi < 40) {
                                output.setText("肥満(3度)");
                            } else {
                                output.setText("肥満(4度)");
                            }
                            output2.setText("あなたの肥満度は");
                            output3.setText("あなたの適正体重は");
                            output4.setText(tekise);
                            output5.setText("kg");

                        break;
                    case R.id.bt_clear:

                            et1.setText(" ");
                            et2.setText(" ");
                            et3.setText(" ");
                            output.setText(" ");
                            output2.setText(" ");
                            output3.setText(" ");
                            output4.setText(" ");
                            output5.setText(" ");
                            break;


                }

        }

    }
}