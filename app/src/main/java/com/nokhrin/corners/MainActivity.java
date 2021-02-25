package com.nokhrin.corners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public int[][] checkersPositions = new int[9][9];
    public ImageView[][] imageViewCheckersWhite = new ImageView[9][9];
    public ImageView[][] imageViewCheckersBlack = new ImageView[9][9];
    public int[][] blackCheckerPositions = new int[9][9];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                checkersPositions[i][j]=0;
            }
        }
        for(int i=6;i<9;i++){
            for(int j=1;j<5;j++){
                checkersPositions[i][j]=1;
            }
        }
        for(int i=1;i<4;i++){
            for(int j=5;j<9;j++){
                checkersPositions[i][j]=-1;
            }
        }

        imageViewCheckersWhite[1][1]=findViewById(R.id.whiteCh11);
        imageViewCheckersWhite[1][2]=findViewById(R.id.whiteCh12);
        imageViewCheckersWhite[1][3]=findViewById(R.id.whiteCh13);
        imageViewCheckersWhite[1][4]=findViewById(R.id.whiteCh14);
        imageViewCheckersWhite[1][5]=findViewById(R.id.whiteCh15);
        imageViewCheckersWhite[1][6]=findViewById(R.id.whiteCh16);
        imageViewCheckersWhite[1][7]=findViewById(R.id.whiteCh17);
        imageViewCheckersWhite[1][8]=findViewById(R.id.whiteCh18);

        imageViewCheckersWhite[2][1]=findViewById(R.id.whiteCh21);
        imageViewCheckersWhite[2][2]=findViewById(R.id.whiteCh22);
        imageViewCheckersWhite[2][3]=findViewById(R.id.whiteCh23);
        imageViewCheckersWhite[2][4]=findViewById(R.id.whiteCh24);
        imageViewCheckersWhite[2][5]=findViewById(R.id.whiteCh25);
        imageViewCheckersWhite[2][6]=findViewById(R.id.whiteCh26);
        imageViewCheckersWhite[2][7]=findViewById(R.id.whiteCh27);
        imageViewCheckersWhite[2][8]=findViewById(R.id.whiteCh28);

        imageViewCheckersWhite[3][1]=findViewById(R.id.whiteCh31);
        imageViewCheckersWhite[3][2]=findViewById(R.id.whiteCh32);
        imageViewCheckersWhite[3][3]=findViewById(R.id.whiteCh33);
        imageViewCheckersWhite[3][4]=findViewById(R.id.whiteCh34);
        imageViewCheckersWhite[3][5]=findViewById(R.id.whiteCh35);
        imageViewCheckersWhite[3][6]=findViewById(R.id.whiteCh36);
        imageViewCheckersWhite[3][7]=findViewById(R.id.whiteCh37);
        imageViewCheckersWhite[3][8]=findViewById(R.id.whiteCh38);

        imageViewCheckersWhite[4][1]=findViewById(R.id.whiteCh41);
        imageViewCheckersWhite[4][2]=findViewById(R.id.whiteCh42);
        imageViewCheckersWhite[4][3]=findViewById(R.id.whiteCh43);
        imageViewCheckersWhite[4][4]=findViewById(R.id.whiteCh44);
        imageViewCheckersWhite[4][5]=findViewById(R.id.whiteCh45);
        imageViewCheckersWhite[4][6]=findViewById(R.id.whiteCh46);
        imageViewCheckersWhite[4][7]=findViewById(R.id.whiteCh47);
        imageViewCheckersWhite[4][8]=findViewById(R.id.whiteCh48);

        imageViewCheckersWhite[5][1]=findViewById(R.id.whiteCh51);
        imageViewCheckersWhite[5][2]=findViewById(R.id.whiteCh52);
        imageViewCheckersWhite[5][3]=findViewById(R.id.whiteCh53);
        imageViewCheckersWhite[5][4]=findViewById(R.id.whiteCh54);
        imageViewCheckersWhite[5][5]=findViewById(R.id.whiteCh55);
        imageViewCheckersWhite[5][6]=findViewById(R.id.whiteCh56);
        imageViewCheckersWhite[5][7]=findViewById(R.id.whiteCh57);
        imageViewCheckersWhite[5][8]=findViewById(R.id.whiteCh58);

        imageViewCheckersWhite[6][1]=findViewById(R.id.whiteCh61);
        imageViewCheckersWhite[6][2]=findViewById(R.id.whiteCh62);
        imageViewCheckersWhite[6][3]=findViewById(R.id.whiteCh63);
        imageViewCheckersWhite[6][4]=findViewById(R.id.whiteCh64);
        imageViewCheckersWhite[6][5]=findViewById(R.id.whiteCh65);
        imageViewCheckersWhite[6][6]=findViewById(R.id.whiteCh66);
        imageViewCheckersWhite[6][7]=findViewById(R.id.whiteCh67);
        imageViewCheckersWhite[6][8]=findViewById(R.id.whiteCh68);

        imageViewCheckersWhite[7][1]=findViewById(R.id.whiteCh71);
        imageViewCheckersWhite[7][2]=findViewById(R.id.whiteCh72);
        imageViewCheckersWhite[7][3]=findViewById(R.id.whiteCh73);
        imageViewCheckersWhite[7][4]=findViewById(R.id.whiteCh74);
        imageViewCheckersWhite[7][5]=findViewById(R.id.whiteCh75);
        imageViewCheckersWhite[7][6]=findViewById(R.id.whiteCh76);
        imageViewCheckersWhite[7][7]=findViewById(R.id.whiteCh77);
        imageViewCheckersWhite[7][8]=findViewById(R.id.whiteCh78);

        imageViewCheckersWhite[8][1]=findViewById(R.id.whiteCh81);
        imageViewCheckersWhite[8][2]=findViewById(R.id.whiteCh82);
        imageViewCheckersWhite[8][3]=findViewById(R.id.whiteCh83);
        imageViewCheckersWhite[8][4]=findViewById(R.id.whiteCh84);
        imageViewCheckersWhite[8][5]=findViewById(R.id.whiteCh85);
        imageViewCheckersWhite[8][6]=findViewById(R.id.whiteCh86);
        imageViewCheckersWhite[8][7]=findViewById(R.id.whiteCh87);
        imageViewCheckersWhite[8][8]=findViewById(R.id.whiteCh88);


        //заполнение картинок черных пешек
        imageViewCheckersBlack[1][1]=findViewById(R.id.blackCh11);
        imageViewCheckersBlack[1][2]=findViewById(R.id.blackCh12);
        imageViewCheckersBlack[1][3]=findViewById(R.id.blackCh13);
        imageViewCheckersBlack[1][4]=findViewById(R.id.blackCh14);
        imageViewCheckersBlack[1][5]=findViewById(R.id.blackCh15);
        imageViewCheckersBlack[1][6]=findViewById(R.id.blackCh16);
        imageViewCheckersBlack[1][7]=findViewById(R.id.blackCh17);
        imageViewCheckersBlack[1][8]=findViewById(R.id.blackCh18);

        imageViewCheckersBlack[2][1]=findViewById(R.id.blackCh21);
        imageViewCheckersBlack[2][2]=findViewById(R.id.blackCh22);
        imageViewCheckersBlack[2][3]=findViewById(R.id.blackCh23);
        imageViewCheckersBlack[2][4]=findViewById(R.id.blackCh24);
        imageViewCheckersBlack[2][5]=findViewById(R.id.blackCh25);
        imageViewCheckersBlack[2][6]=findViewById(R.id.blackCh26);
        imageViewCheckersBlack[2][7]=findViewById(R.id.blackCh27);
        imageViewCheckersBlack[2][8]=findViewById(R.id.blackCh28);

        imageViewCheckersBlack[3][1]=findViewById(R.id.blackCh31);
        imageViewCheckersBlack[3][2]=findViewById(R.id.blackCh32);
        imageViewCheckersBlack[3][3]=findViewById(R.id.blackCh33);
        imageViewCheckersBlack[3][4]=findViewById(R.id.blackCh34);
        imageViewCheckersBlack[3][5]=findViewById(R.id.blackCh35);
        imageViewCheckersBlack[3][6]=findViewById(R.id.blackCh36);
        imageViewCheckersBlack[3][7]=findViewById(R.id.blackCh37);
        imageViewCheckersBlack[3][8]=findViewById(R.id.blackCh38);

        imageViewCheckersBlack[4][1]=findViewById(R.id.blackCh41);
        imageViewCheckersBlack[4][2]=findViewById(R.id.blackCh42);
        imageViewCheckersBlack[4][3]=findViewById(R.id.blackCh43);
        imageViewCheckersBlack[4][4]=findViewById(R.id.blackCh44);
        imageViewCheckersBlack[4][5]=findViewById(R.id.blackCh45);
        imageViewCheckersBlack[4][6]=findViewById(R.id.blackCh46);
        imageViewCheckersBlack[4][7]=findViewById(R.id.blackCh47);
        imageViewCheckersBlack[4][8]=findViewById(R.id.blackCh48);

        imageViewCheckersBlack[5][1]=findViewById(R.id.blackCh51);
        imageViewCheckersBlack[5][2]=findViewById(R.id.blackCh52);
        imageViewCheckersBlack[5][3]=findViewById(R.id.blackCh53);
        imageViewCheckersBlack[5][4]=findViewById(R.id.blackCh54);
        imageViewCheckersBlack[5][5]=findViewById(R.id.blackCh55);
        imageViewCheckersBlack[5][6]=findViewById(R.id.blackCh56);
        imageViewCheckersBlack[5][7]=findViewById(R.id.blackCh57);
        imageViewCheckersBlack[5][8]=findViewById(R.id.blackCh58);

        imageViewCheckersBlack[6][1]=findViewById(R.id.blackCh61);
        imageViewCheckersBlack[6][2]=findViewById(R.id.blackCh62);
        imageViewCheckersBlack[6][3]=findViewById(R.id.blackCh63);
        imageViewCheckersBlack[6][4]=findViewById(R.id.blackCh64);
        imageViewCheckersBlack[6][5]=findViewById(R.id.blackCh65);
        imageViewCheckersBlack[6][6]=findViewById(R.id.blackCh66);
        imageViewCheckersBlack[6][7]=findViewById(R.id.blackCh67);
        imageViewCheckersBlack[6][8]=findViewById(R.id.blackCh68);

        imageViewCheckersBlack[7][1]=findViewById(R.id.blackCh71);
        imageViewCheckersBlack[7][2]=findViewById(R.id.blackCh72);
        imageViewCheckersBlack[7][3]=findViewById(R.id.blackCh73);
        imageViewCheckersBlack[7][4]=findViewById(R.id.blackCh74);
        imageViewCheckersBlack[7][5]=findViewById(R.id.blackCh75);
        imageViewCheckersBlack[7][6]=findViewById(R.id.blackCh76);
        imageViewCheckersBlack[7][7]=findViewById(R.id.blackCh77);
        imageViewCheckersBlack[7][8]=findViewById(R.id.blackCh78);

        imageViewCheckersBlack[8][1]=findViewById(R.id.blackCh81);
        imageViewCheckersBlack[8][2]=findViewById(R.id.blackCh82);
        imageViewCheckersBlack[8][3]=findViewById(R.id.blackCh83);
        imageViewCheckersBlack[8][4]=findViewById(R.id.blackCh84);
        imageViewCheckersBlack[8][5]=findViewById(R.id.blackCh85);
        imageViewCheckersBlack[8][6]=findViewById(R.id.blackCh86);
        imageViewCheckersBlack[8][7]=findViewById(R.id.blackCh87);
        imageViewCheckersBlack[8][8]=findViewById(R.id.blackCh88);


        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(checkersPositions[i][j]==1){
                    imageViewCheckersWhite[i][j].setVisibility(View.VISIBLE);
                }
            }
        }

        for(int i=1;i<9;i++){
            for(int j=1;j<9;j++){
                if(checkersPositions[i][j]==-1){
                    imageViewCheckersBlack[i][j].setVisibility(View.VISIBLE);
                }
            }
        }
        /*imageViewCheckersBlack[1][8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewCheckersBlack[8][8].setVisibility(View.VISIBLE);
            }
        });
        imageViewCheckersWhite[8][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewCheckersWhite[1][1].setVisibility(View.VISIBLE);
            }
        });*/





    }

}