package com.example.helptheinnocentbird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView bird,enemy1,enemy2,enemy3,coin,volume;
    private Button buttonStart;
    private Animation animation;
    private MediaPlayer mediaPlayer;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bird = findViewById(R.id.bird);
        enemy1 = findViewById(R.id.enemy1);
        enemy2 = findViewById(R.id.enemy2);
        enemy3 = findViewById(R.id.enemy3);
        coin = findViewById(R.id.coin);
        volume = findViewById(R.id.volume);
        buttonStart = findViewById(R.id.buttonStart);

        animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_animation);
        bird.setAnimation(animation);
        enemy1.setAnimation(animation);
        enemy2.setAnimation(animation);
        enemy3.setAnimation(animation);
        coin.setAnimation(animation);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.reset();
                volume.setImageResource(R.drawable.baseline_volume_up_24);

                Intent i = new Intent(MainActivity.this,GameActivity.class);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.game_sound);
        mediaPlayer.start();
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!status){
                    mediaPlayer.setVolume(0,0);
                    volume.setImageResource(R.drawable.baseline_volume_off_24);
                    status = true;
                }
                else {
                    mediaPlayer.setVolume(1,1);
                    volume.setImageResource(R.drawable.baseline_volume_up_24);
                    status = false;
                }
            }
        });
    }
}