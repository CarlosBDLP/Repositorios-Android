package dam.androidCarlosBarrionuevo.u2p4conversor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        TextView textView = (TextView) findViewById(R.id.ErrortextView);
        textView.setVisibility(View.INVISIBLE);

        buttonConvertir.setOnClickListener(view -> {
            try {

                etResultado.setText(convertirApulgadas(Double.parseDouble(etPulgada.getText().toString())));
            } catch (ErrorUsuario errorUsuario) {
                errorUsuario.getMessage();
            }
        });



        buttonConvertir.setOnLongClickListener(v -> {
            try {
                etResultado.setText(convertirAcm(Double.parseDouble(etPulgada.getText().toString())));
            } catch (ErrorUsuario errorUsuario) {
                errorUsuario.getMessage();
            }

            return false;
        });
    }

    private String convertirApulgadas(double pulgadaText) throws ErrorUsuario {
        TextView textView = (TextView) findViewById(R.id.ErrortextView);
        double pulgadaValue = Double.parseDouble(String.valueOf(pulgadaText)) * 2.54;

        try {
            if (pulgadaText <= 0)
                throw new ErrorUsuario(1);
            else{
                textView.setVisibility(View.INVISIBLE);
            }
        } catch (ErrorUsuario ex) {
            ex.getMessage();
        }

        return String.valueOf(pulgadaValue);
    }

    private String  convertirAcm(double cmText) throws ErrorUsuario {
        TextView textView = (TextView) findViewById(R.id.ErrortextView);
        double cmValue = Double.parseDouble(String.valueOf(cmText)) / 2.54;

        try {
            if (cmText <=0 )
                throw new ErrorUsuario(1);
            else{
                textView.setVisibility(View.INVISIBLE);
            }
        } catch (ErrorUsuario ex) {
            ex.getMessage();
        }
        return String.valueOf(cmValue);
    }




    class ErrorUsuario extends Exception {
        private int codigoError = 1;

        public ErrorUsuario(int codigoError) {
            this.codigoError = codigoError;
        }

        public String getMessage() {
            TextView textView = (TextView) findViewById(R.id.ErrortextView);

            if (codigoError == 1) {

                textView.setVisibility(View.VISIBLE);

            }

            return String.valueOf(textView);

        }
    }

}

