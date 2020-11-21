package com.example.festival;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.festival.database.Groupe;
import com.google.android.material.chip.Chip;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Groupe> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataGenerator.cleanDatabase();
        DataGenerator.fillDatabase();

        ListView listView = findViewById(R.id.listViewGroups);
        groups = Groupe.listAll(Groupe.class);
        final GroupAdapter adapter = new GroupAdapter(MainActivity.this, groups);
        listView.setAdapter(adapter);
    }

    public void sort(View view){
        Chip chipVendredi = findViewById(R.id.chipVendredi);
        Chip chipSamedi = findViewById(R.id.chipSamedi);
        Chip chipAcoustique = findViewById(R.id.chipAcoustique);
        Chip chipAmplifiee = findViewById(R.id.chipAmplifiee);
        boolean sortByDay = false;
        boolean sortByStage = false;
        String day = null;
        String stage = null;

        if (chipVendredi.isChecked() || chipSamedi.isChecked())
            sortByDay = true;
        if (chipAcoustique.isChecked() || chipAmplifiee.isChecked())
            sortByStage = true;

        if (sortByDay){
            if (chipVendredi.isChecked())
                day = "Vendredi";
            else
                day = "Samedi";
        }

        if (sortByStage){
            if (chipAcoustique.isChecked())
                stage = "Acoustique";
            else
                stage = "Amplifiée";
        }

        if(sortByDay && sortByStage)
            groups = Select.from(Groupe.class).where(Condition.prop("jour").eq(day),Condition.prop("scene").eq(stage)).list();
        else if(sortByDay)
            groups = Select.from(Groupe.class).where(Condition.prop("jour").eq(day)).list();
        else if (sortByStage)
            groups = Select.from(Groupe.class).where(Condition.prop("scene").eq(stage)).list();

        if (sortByDay || sortByStage){
            final GroupAdapter adapter = new GroupAdapter(MainActivity.this, groups);
            ListView listView = findViewById(R.id.listViewGroups);
            listView.setAdapter(adapter);
        }
    }
}