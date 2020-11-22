package com.example.festival;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;
import com.example.festival.database.Groupe;

import com.orm.query.Condition;
import com.orm.query.Select;

public class DetailsActivity extends AppCompatActivity {

    private ImageView favIcon;
    private Groupe g = MainActivity.selectedGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nomGroupe = findViewById(R.id.groupName);
        nomGroupe.setText(g.getNom());

        ImageView photoGroupe = findViewById(R.id.groupImage);
        photoGroupe.setImageResource(getImageId(this, g.getPhoto()));

        TextView horaireGroupe = findViewById(R.id.timetableValue);
        horaireGroupe.setText(g.getJour() + " à " + g.getHoraire());

        TextView sceneGroupe = findViewById(R.id.sceneTypeValue);
        sceneGroupe.setText(g.getScene());

        JustifiedTextView descriptionGroupe = findViewById(R.id.description);
        descriptionGroupe.setText(g.getDescription() +
                " \n \n" + "Pour plus d'informations : " + g.getSiteWeb());

        favIcon = findViewById(R.id.imageButtonFav);

        if (g.estFavori()){
            favIcon.setImageResource(getImageId(this, "is_favoris"));
        }
    }

    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    public void favoris(View view){
        if (g.estFavori()){
            g.setEstFavori(false);
            g.save();
            favIcon.setImageResource(getImageId(this, "not_favoris"));
        }
        else{
            g.setEstFavori(true);
            g.save();
            favIcon.setImageResource(getImageId(this, "is_favoris"));
        }
    }
}