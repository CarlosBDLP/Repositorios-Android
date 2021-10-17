package dam.androidCarlosBarrionuevo.u2p4conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class U2P4ConversorActivity extends LogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        EditText etPulgada = findViewById(R.id.et_Pulgada);
        EditText etResultado = findViewById(R.id.et_Resultado);
        Button buttonConvertir = findViewById(R.id.button_Convertir);

        buttonConvertir.setOnClickListener(view -> {
            try {
                etResultado.setText(convertirApulgadas(etPulgada.getText().toString()));
            } catch (Exception e) {
                Log.e("LogsConversor", e.getMessage());
            }
        });

    }

    private String convertirApulgadas(String pulgadaText) {
        double pulgadaValue = Double.parseDouble(pulgadaText) * 2.54;

        return String.valueOf(pulgadaValue);
    }

}