package com.example.act02video;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class LogActivity extends AppCompatActivity {

    private static final String MainName = MainActivity.class.getSimpleName();
    String activityName = this.getClass().getSimpleName();

    private static final String DEBUG_TAG_MAIN = "LOG-";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected void onPause() {
        notify("onPause");
        super.onPause();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onPause");

    }

    @Override
    protected void onResume() {
        notify("onResume");
        super.onResume();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onResume");


    }

    @Override
    protected void onStart() {
        notify("onStart");
        super.onStart();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onStart");

    }

    @Override
    protected void onStop() {
        notify("onStop");
        super.onStop();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onStop");

    }


    @Override
    protected void onRestart() {
        notify("onRestart");
        super.onRestart();
        Log.i(DEBUG_TAG_MAIN, activityName + " is onRestart");

    }

    @Override
    protected void onDestroy() {
        notify("onDestroy");
        super.onDestroy();

        if (isFinishing()) {
            Log.i(DEBUG_TAG_MAIN, activityName + " is destroyed by User");

        } else
            Log.i(DEBUG_TAG_MAIN, activityName + " is destroyed  by System");


    }
    //Este metodo sirve para restaurar un punto de guardado,imagina que en un juego guardas la partida,este metodo se encarga
    //de cargarla,es la unica(hasta donde yo se) forma de restaurar,ya que android se carga los procesos cuando quiere para liberar memoria
    //
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(DEBUG_TAG_MAIN, "El estado de la actividad ha sido restaurado");
    }
    //Este metodo se encarga de guardar la partida,con este metodo podemos "guardar la partida" o mejor dicho los resultados de variables por ejemplo
    // guarda el estado de dicha variable y el metodo onRestore se encarga de cargarlo
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(DEBUG_TAG_MAIN, "El estado de la actividad ha sido guardado");
    }


    private void notify(String eventName){

        String activityName = this.getClass().getSimpleName();

        String CHANNEL_ID = "My_LifeCycle";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel (CHANNEL_ID,"My_LifeCycle",NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription("Life cycle events");
            notificationChannel.setShowBadge(true);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            if(notificationManager != null){
                notificationManager.createNotificationChannel(notificationChannel);
            }

        }

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle(eventName + " " + activityName)
                .setContentText(getPackageName())
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManagerCompat.notify((int) System.currentTimeMillis(), notificationBuilder.build());



    }

}
