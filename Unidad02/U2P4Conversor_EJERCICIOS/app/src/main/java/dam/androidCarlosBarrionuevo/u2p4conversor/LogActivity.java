package dam.androidCarlosBarrionuevo.u2p4conversor;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class LogActivity extends AppCompatActivity {

    String activityName = this.getClass().getSimpleName();

    private static final String DEBUG_TAG_MAIN = "LOG-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onResume");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onStop");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isFinishing()) {
            Log.i(DEBUG_TAG_MAIN, activityName + " is destroyed by User");

        } else
            Log.i(DEBUG_TAG_MAIN, activityName + " is destroyed  by System");


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView textView = findViewById(R.id.ErrortextView);
        String error = savedInstanceState.getString("error");
        textView.setText(error);

        Log.i(DEBUG_TAG_MAIN, "El estado de la actividad ha sido restaurado");

    }

    @Override
    protected void onSaveInstanceState(Bundle  outState) {
        super.onSaveInstanceState(outState);
        TextView textView = findViewById(R.id.ErrortextView);
        outState.putString("error",textView.getText().toString());
        Log.i(DEBUG_TAG_MAIN, "El estado de la actividad ha sido guardado");

    }




}

