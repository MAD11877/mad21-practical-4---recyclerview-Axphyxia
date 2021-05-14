package sg.edu.np.week2practical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG= "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView middleButton = findViewById(R.id.middleButton);

        middleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                userQuery();
            }
        });
    }

    private int randomNumber(){
        Random ranInt = new Random();
        int ranVal = ranInt.nextInt(1000000000);
        return ranVal;
    }

    private void userQuery(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Madness");
        builder.setTitle("Profile");
        builder.setCancelable(false);

        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int raNo = randomNumber();

                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("Number", raNo);
                startActivity(intent);

            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

}