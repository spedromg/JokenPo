package br.com.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectedStone(View view) {
        this.selectOption("Stone");
    }
    public void selectedPaper(View view){
        this.selectOption("Paper");
    }
    public void selectedScissors(View view){
        this.selectOption("Scissors");
    }
    public void selectOption(String optionSelected) {
        ImageView image = findViewById(R.id.imgDefault);
        TextView textResult = findViewById(R.id.txtResult);
        int number = new Random().nextInt(3);
        String[] option = {"Stone", "Paper", "Scissors"};
        String optionApp = option[number];

        switch (optionApp){ // Define option selected from App
            case "Stone":
                image.setImageResource(R.drawable.pedra);
                break;
            case "Paper":
                image.setImageResource(R.drawable.papel);
                break;
            case "Scissors":
                image.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((optionApp.equals("Scissors") && optionSelected.equals("Paper")) || (optionApp.equals("Paper") && optionSelected.equals("Stone")) || (optionApp.equals("Stone") && optionSelected.equals("Scissors"))) {
            textResult.setText("You Lost!!!");
        } else if ((optionSelected.equals("Scissors") && optionApp.equals("Paper")) || (optionSelected.equals("Paper") && optionApp.equals("Stone")) || (optionSelected.equals("Stone") && optionApp.equals("Scissors"))) {
            textResult.setText("You Win!!!");
        } else {
            textResult.setText("Equals!!!!");
        }
    }
}