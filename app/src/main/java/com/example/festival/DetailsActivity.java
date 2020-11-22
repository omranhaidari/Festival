package com.example.festival;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.festival.database.Groupe;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Groupe g = MainActivity.selectedGroup;

        TextView nomGroupe = findViewById(R.id.groupName);
        nomGroupe.setText(g.getNom());

        ImageView photoGroupe = findViewById(R.id.groupImage);
        photoGroupe.setImageResource(getImageId(this, g.getPhoto()));

        TextView horaireGroupe = findViewById(R.id.timetableValue);
        horaireGroupe.setText(g.getJour() + " à " + g.getHoraire());

        TextView sceneGroupe = findViewById(R.id.sceneTypeValue);
        sceneGroupe.setText(g.getScene());

        TextView descriptionGroupe = findViewById(R.id.description);
        descriptionGroupe.setText(g.getDescription() +
                " \n \n" + "Pour plus d'informations : " + g.getSiteWeb());
    }


    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }
}