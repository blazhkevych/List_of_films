package com.example.list_of_films.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.list_of_films.R;
import com.example.list_of_films.models.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends BaseAdapter {

    List<Film> films = new ArrayList<Film>();

    // Add a film to this list and then notify the adapter that the data set has changed by calling notifyDataSetChanged().
    // This method call is necessary because it triggers the ListView to refresh and display the updated data.
    public void add(Film film) {
        films.add(film);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent
                    .getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.film_item_layout, null);
        }

        Film film = films.get(position);
        ((TextView) convertView.findViewById(R.id.filmTitle_textView)).setText(film.getTitle());
        ((TextView) convertView.findViewById(R.id.filmGenre_textView)).setText(film.getGenre());
        ((TextView) convertView.findViewById(R.id.filmYear_textView)).setText(String.format("%d year", film.getYear()));

        return convertView;
    }
}
