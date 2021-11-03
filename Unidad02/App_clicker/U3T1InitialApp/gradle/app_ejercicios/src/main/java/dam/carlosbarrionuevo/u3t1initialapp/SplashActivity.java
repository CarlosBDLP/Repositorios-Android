package dam.carlosbarrionuevo.u3t1initialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
  private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    sound = MediaPlayer.create(getApplicationContext(),R.raw.sound);
                    sound.start();
                    sleep(5000);

                }catch (InterruptedException e){
                }
                finally {
                    startActivity(new Intent("dam.carlosbarrionuevo.u3t1initialapp.STARTINGPOINT"));
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.release();
        finish();
    }
}