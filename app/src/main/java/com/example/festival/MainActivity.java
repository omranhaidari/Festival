package com.example.festival;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.festival.database.Groupe;
import com.google.android.material.chip.Chip;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView;
    public static Groupe selectedGroup;
    GroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vérifie si la base de données à déjà été initialiser ou pas.
        List<Groupe> groups = Groupe.listAll(Groupe.class);
        if (groups.size() == 0){
            DataGenerator.cleanDatabase();
            DataGenerator.fillDatabase();
        }

        listView = findViewById(R.id.listViewGroups);
        searchView = findViewById(R.id.searchBar);
        adapter = new GroupAdapter(MainActivity.this, groups);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        setupSearchView();

        // Rend les éléments de la liste cliquable
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedGroup = adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        // Lorsque du texte est inséré dans la barre de recherche, la liste est automatiquement filtée
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void setupSearchView()
    {
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Rechercher un groupe");
    }


    // Permets de filtrer les éléments de la liste lorsqu'un bouton de tri est séléctionné
    public void sort(View view){
        List<Groupe> groups;
        Chip chipVendredi = findViewById(R.id.chipVendredi);
        Chip chipSamedi = findViewById(R.id.chipSamedi);
        Chip chipAcoustique = findViewById(R.id.chipAcoustique);
        Chip chipAmplifiee = findViewById(R.id.chipAmplifiee);
        boolean sortByDay = false;
        boolean sortByStage = false;
        String day = null;
        String stage = null;

        // Si l'utilisateur veut trier par jour
        if (chipVendredi.isChecked() || chipSamedi.isChecked()){
            sortByDay = true;
            if (chipVendredi.isChecked())
                day = "Vendredi";
            else
                day = "Samedi";
        }

        // Si l'utilisateur veut trier par scène
        if (chipAcoustique.isChecked() || chipAmplifiee.isChecked()){
            sortByStage = true;
            if (chipAcoustique.isChecked())
                stage = "Acoustique";
            else
                stage = "Amplifiée";
        }

        // Récupération des groupes en fonction des critères choisis par l'utilisateur
        if(sortByDay && sortByStage)
            groups = Select.from(Groupe.class).where(Condition.prop("jour").eq(day),Condition.prop("scene").eq(stage)).list();
        else if(sortByDay)
            groups = Select.from(Groupe.class).where(Condition.prop("jour").eq(day)).list();
        else if (sortByStage)
            groups = Select.from(Groupe.class).where(Condition.prop("scene").eq(stage)).list();
        else
            groups = Groupe.listAll(Groupe.class);

        adapter = new GroupAdapter(MainActivity.this, groups);
        listView.setAdapter(adapter);
    }

    // Affichage dans la liste des éléments ajoutés aux favoris seulement
    public void showFavoris (View view){
        List<Groupe> groups = Select.from(Groupe.class).where(Condition.prop("est_favori").eq(1)).list();
        adapter = new GroupAdapter(MainActivity.this, groups);
        listView.setAdapter(adapter);
    }

    // Enlève tous les filtres et affiche la liste complète des groupes
    public void clearFilter(View view){
        List<Groupe> groups = Groupe.listAll(Groupe.class);
        adapter = new GroupAdapter(MainActivity.this, groups);
        listView.setAdapter(adapter);
    }
}