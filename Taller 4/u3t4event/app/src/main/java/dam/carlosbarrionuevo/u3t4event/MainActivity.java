package dam.carlosbarrionuevo.u3t4event;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etEventName;
    private TextView tvCurrentData;
    //esta variable contiene el objeto que lanza una activity que delvuelve el intent  como resultado
    //preguntar a empar
    private ActivityResultLauncher<Intent> eventActivityResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //esta activity se encarga de lanzar eventualente
        // una nueva actividad para la introduccion de propiedades desde ese evento
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUi();
        // a traves de getIntent y el metodo
        //getExtras,de esta forma accedemos al bundle que hemos enviado desde la actividad anterior
        Bundle inputData = getIntent().getExtras();
        registerForEventResult();
    }




    private void setUi(){

        //definimos el acceso a los componentes del layout, que estasmo llamando desde el OnCreate
        etEventName = (EditText) findViewById(R.id.etEventName);
        tvCurrentData = (TextView) findViewById(R.id.tvCurrentData);

        tvCurrentData.setText(" ");
    }


    public void editEventData(View view) {
        //al pulsar el boton se invoca este metodo, el cual nos devolvera
        // los datos que ha introducido el usuario y se los enviara a la siguiente activity
        //tambien llamamos a launch para iniciar el intent de la nueva activity(que contiene el bundle asociado
        //a los datos del evento

        Intent intent = new Intent(this,EventDataActivity.class);
        Bundle bundle = new Bundle();

        //hacemos un set de la info del bundle
        bundle.putString("EventName",etEventName.getText().toString());
        //añadimos el bundle al intent
        intent.putExtras(bundle);
        //lanza la activity
        eventActivityResult.launch(intent);
    }

    //este metodo gestiona la respuesta desde la otra activiy(la del calendario etc..)
    private void registerForEventResult(){
        eventActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        //comprobamos si el resultado de la activiy es correcto
                        if(result.getResultCode() == RESULT_OK){
                            Intent data = result.getData();
                        if(data != null)
                            tvCurrentData.setText(data.getStringExtra("EventData"));
                        }
                    }
                });


    }
}