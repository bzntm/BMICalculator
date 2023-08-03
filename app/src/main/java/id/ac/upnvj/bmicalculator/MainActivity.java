package id.ac.upnvj.bmicalculator;

import static id.ac.upnvj.bmicalculator.CalculateBMI.BMI_CATEGORY_HEALTHY;
import static id.ac.upnvj.bmicalculator.CalculateBMI.BMI_CATEGORY_OBESE;
import static id.ac.upnvj.bmicalculator.CalculateBMI.BMI_CATEGORY_OVERWEIGHT;
import static id.ac.upnvj.bmicalculator.CalculateBMI.BMI_CATEGORY_UNDERWEIGHT;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    CalculateBMI calculateBMI = new CalculateBMI();
    EditText txtBodyMass, txtBodyHeight;
    TextView txtBodyStatus;
    Button btnBMICHK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBodyMass = findViewById(R.id.txtBodyMass);
        txtBodyHeight = findViewById(R.id.txtBodyHeight);
        txtBodyStatus = findViewById(R.id.txtBodyStatus);
        btnBMICHK = findViewById(R.id.btnBMICHK);
        btnBMICHK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtBodyMass.length()==0||txtBodyHeight.length()==0){
                    Toast.makeText(MainActivity.this, "Please input Body Mass and Body Height to Calculate BMI", Toast.LENGTH_SHORT).show();
                }
                String stringBodyMass = txtBodyMass.getText().toString();
                String stringBodyHeight = txtBodyHeight.getText().toString();
                double BodyMass = Double.parseDouble(stringBodyMass);
                double BodyHeight = Double.parseDouble(stringBodyHeight);
                double BMI = calculateBMI.getInstance().CountBMI(BodyHeight, BodyMass);
                showBMI(BMI);
            }
        });
    }

    private void showBMI(double BMI) {
        String bmiCategory = calculateBMI.getInstance().classifyBMI(BMI);
        txtBodyStatus.setText(bmiCategory);

        switch (bmiCategory) {
            case BMI_CATEGORY_UNDERWEIGHT:
                break;
            case BMI_CATEGORY_HEALTHY:
                break;
            case BMI_CATEGORY_OVERWEIGHT:
                break;
            case BMI_CATEGORY_OBESE:
                break;
        }
    }
}