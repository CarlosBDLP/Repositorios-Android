package dam.carlosbarrionuevo.u3t4event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class EventDataActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    private TextView tvEventName;
    private RadioGroup rgPriority;
    private DatePicker dpDate;
    private TimePicker tpTime;
    private Button btAccept;
    private Button btCancel;
    private String priority = "Normal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_data);

        setUI();
        // a traves de getIntent y el metodo
        //getExtras,de esta forma accedemos al bundle que hemos enviado desde la actividad anterior
        Bundle inputData = getIntent().getExtras();

        //asignamos el nombre del evento que recogemos en el intent
        tvEventName.setText(inputData.getString("EventName"));

    }

    private void setUI(){
        //añadimos los atributos a la activty para el acceso a los componentes del layout

        tvEventName = (TextView) findViewById(R.id.tvEventName);
        rgPriority = (RadioGroup)  findViewById(R.id.rgPriority);
        dpDate = (DatePicker)  findViewById(R.id.dpDate);
        tpTime =(TimePicker) findViewById(R.id.tpTime);
        //cambiamos el formato a 24h
        tpTime.setIs24HourView(true);
        btAccept = (Button) findViewById(R.id.btAccept);
        btCancel = (Button) findViewById(R.id.btCancel);

        //cremos los listeners
        btAccept.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        rgPriority.setOnCheckedChangeListener(this);
        rgPriority.check(R.id.rbNormal);
    }

    @Override
    public void onClick(View view){
        //cremoas un nuevo intent y le inyectamos el bundle con la info para pasarla a la main activiy
        Intent activityResult = new Intent();
        Bundle eventData = new Bundle();

        //cuando el usuario pulse el boton Acept se recompilan los datos del evento
        //y se los añadimos al bundle
        switch (view.getId()) {
            case R.id.btAccept:
                String[] month = {
                        "January", "February", "March", "April", "May", "June", "July",
                        "August", "September", "October", "November", "December"};
                eventData.putString("EventData", "Priority" + priority + "\n" +
                        "Month: " + month[dpDate.getMonth()] + "\n" +
                        "Day: " + dpDate.getDayOfMonth() + "\n" +
                        "Year: " + dpDate.getYear());
                break;

            case R.id.btCancel:
                eventData.putString("EventData"," ");
                break;
        }

        activityResult.putExtras(eventData);
        setResult(RESULT_OK,activityResult);

        finish();

    }




    @Override
    public void onCheckedChanged(RadioGroup group, int id) {
        switch (id){
            case R.id.rbLow:
                priority = "Low";
                break;
            case R.id.rbNormal:
                priority = "Normal";
                break;
            case R.id.rbHigh:
                priority = "High";
                break;
        }

    }
}