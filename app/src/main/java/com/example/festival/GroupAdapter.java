package com.example.festival;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.festival.database.Groupe;

import java.util.ArrayList;
import java.util.List;

public class GroupAdapter extends ArrayAdapter<Groupe> implements Filterable {

    public List<Groupe> groups;

    public GroupAdapter(Context context, List<Groupe> groups){
        super(context,0,groups);
        this.groups = groups;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list_groups,parent, false);
        }

        DetailViewHolder viewHolder = (DetailViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new DetailViewHolder();
            viewHolder.detailNom = convertView.findViewById(R.id.textViewNom);
            viewHolder.detailPhoto = convertView.findViewById(R.id.imageViewGroup);
            viewHolder.detailJour = convertView.findViewById(R.id.textViewJour);
            viewHolder.detailHeure = convertView.findViewById(R.id.textViewHeure);
            viewHolder.detailScene = convertView.findViewById(R.id.textViewScene);
            convertView.setTag(viewHolder);
        }

        Groupe group = getItem(position);

        assert group != null;
        viewHolder.detailNom.setText(group.getNom());
        viewHolder.detailPhoto.setImageResource(getImageId(getContext(),group.getPhoto()));
        viewHolder.detailJour.setText(group.getJour());
        viewHolder.detailHeure.setText(group.getHoraire());
        viewHolder.detailScene.setText("Scène " + group.getScene());

        return convertView;
    }

    @Override
    public Groupe getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return groups.size();
    }

    private static class DetailViewHolder{
        public TextView detailNom;
        public ImageView detailPhoto;
        public TextView detailJour;
        public TextView detailHeure;
        public TextView detailScene;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final List<Groupe> results = new ArrayList<>();
                List<Groupe> allGroups = Groupe.listAll(Groupe.class);
                if (constraint != null && allGroups!=null) {
                    if (allGroups.size() > 0) {
                        for (final Groupe g : allGroups) {
                            if (g.getNom().toLowerCase().contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                    oReturn.count = results.size();
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                groups = (List<Groupe>) results.values;
                if (results.count > 0) {
                    notifyDataSetChanged();
                    clear();
                    for (Groupe g : groups)
                        add(g);
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public static int getImageId(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }
}
