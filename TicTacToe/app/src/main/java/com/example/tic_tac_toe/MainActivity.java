package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive = true;
    //player representation
    //0 - x
    //1 - o
    int activeplayer = 0;
    int[] gamestate ={2,2,2,2,2,2,2,2,2};
    //game state
    //0 - x
    //1- o
    //2 - null
    int[][] winingstate = {{0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
public void playertap(View view){
    ImageView img = (ImageView) view;
    int tappedimage = Integer.parseInt(img.getTag().toString());
    if(!gameactive){
        gamereset(view);
    }
    if(gamestate[tappedimage]==2&&gameactive){
        gamestate[tappedimage]=activeplayer;
        img.setTranslationY(-1000f);
        if(activeplayer==0){
            img.setImageResource(R.drawable.x);
            activeplayer=1;
            TextView status = findViewById(R.id.status);
            status.setText("O's turn tap to play");
        }
        else {
            img.setImageResource(R.drawable.o);
            activeplayer=0;
            TextView status = findViewById(R.id.status);
            status.setText("X's turn tap to play");
        }
        img.animate().translationYBy(1000f).setDuration(100);
    }
    for(int[] winingstates:winingstate){
       if(gamestate[winingstates[0]]==gamestate[winingstates[1]]&&gamestate[winingstates[1]]==gamestate[winingstates[2]]&&gamestate[winingstates[0]]!=2){
           //that means someone won;
           String winnerstr;
           gameactive=false;
        if (gamestate[winingstates[0]]==0){
            winnerstr="X has won!";
        }else{
            winnerstr="O has won!";
        }
        //update status bar for winner
           TextView status = findViewById(R.id.status);
           status.setText(winnerstr);
       }
    }

}
    public void gamereset(View view){
    gameactive=true;
    activeplayer=0;
        for (int i=0;i<=gamestate.length; i++) {
            gamestate[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's turn tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}