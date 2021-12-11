package dam.carlosbarrionuevo.u3t4event;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventDataActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    /*  private DatePicker dpDate;
    private TimePicker tpTime;*/
    private TextView tvEventName;
    private EditText place;
    private RadioGroup rgPriority;
    private Button btAccept;
    private Button btCancel;
    private String priority = "Normal";
    //array de mesos
    private String [] meses;
    private TextView fecha;
    private TextView hora;

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

        hora = (TextView)  findViewById(R.id.tv_hora);
        fecha = (TextView) findViewById(R.id.tv_Fecha);
        tvEventName = (TextView) findViewById(R.id.tvEventName);
        //place
        place = (EditText) findViewById(R.id.editTextTextPersonName);
        rgPriority = (RadioGroup)  findViewById(R.id.rgPriority);
        btAccept = (Button) findViewById(R.id.btAccept);
        btCancel = (Button) findViewById(R.id.btCancel);

        //cremos los listeners
        btAccept.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        rgPriority.setOnCheckedChangeListener(this);
        rgPriority.check(R.id.rbNormal);
    }


    //TODO n7 metode fragement calendario
    //este metode crea el fragment amb el calendari
    public void abrir_calendario(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
                fecha.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new DatePickerDialog(EventDataActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }


    //metode crea el fragment del reloj

    //TODO n8 metode fragment reloj
    public void abrir_reloj(View view) {
        Calendar calendar = Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                //TODO n5 cambio formato hora
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                hora.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new TimePickerDialog(EventDataActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
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

                //TODO  n3 recurso del array
                //cree un nou resource  y le asinge el metode que em torna el array
                Resources res = getResources();
                meses = res.getStringArray(R.array.month);

                //TODO n4 Place en el bundle
                eventData.putString("EventData", getResources().getString(R.string.tvPriority) +" : "+ priority + "\n" +getResources().getString(R.string.place) +" : "+ place.getText().toString() + "\n" +
                     getResources().getString(R.string.tv_Fecha) + " : "+ fecha.getText() + "\n"+
                     getResources().getString(R.string.tv_hora )+
                     " : " + hora.getText());

                setResult(RESULT_OK,activityResult);
                activityResult.putExtras(eventData);

                break;

                //TODO  n1 boton Cancel
            case R.id.btCancel:
                //el boton cancel retorna la informacio del bundle al intent
                eventData.putString("EventData"," ");
               setResult(RESULT_CANCELED,activityResult);
                break;
        }

        activityResult.putExtras(eventData);
      //  setResult(RESULT_OK,activityResult);

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