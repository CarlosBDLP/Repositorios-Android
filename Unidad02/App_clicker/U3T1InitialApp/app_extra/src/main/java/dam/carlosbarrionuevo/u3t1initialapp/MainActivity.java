package dam.carlosbarrionuevo.u3t1initialapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int count;
    private TextView tvDisplay;
    private Button buttonIncrese, buttonDecrease, buttonReset, buttonIncrese2, buttonDecrease2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUi();
    }

    private void setUi(){
        tvDisplay = findViewById(R.id.tvDisplay);
        buttonIncrese = findViewById(R.id.buttonIncrese);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonReset = findViewById(R.id.buttonReset);
        buttonIncrese2 = findViewById(R.id.buttonIncrese2);
        buttonDecrease2 = findViewById(R.id.buttonDecrease2);

        buttonIncrese.setOnClickListener(this);
        buttonIncrese2.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonDecrease2.setOnClickListener(this);
        buttonReset.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonIncrese: count++; break;
            case R.id.buttonDecrease: count--; break;
            case R.id.buttonReset: count = 0; break;
            case R.id.buttonIncrese2: count = count+2; break;
            case R.id.buttonDecrease2: count = count-2; break;


        }
        tvDisplay.setText(getString(R.string.number_of_elements) + ": "+ count);
    }

    @Override
    protected void onSaveInstanceState( Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        tvDisplay.setText(getString(R.string.number_of_elements)+": "+count);
    }

}