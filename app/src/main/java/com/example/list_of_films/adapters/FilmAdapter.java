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

/**
 * This class is a custom adapter for a ListView in Android, specifically for displaying a list of films.
 * The adapter extends the BaseAdapter class, which is a common base class of general implementation for an Adapter.
 */
public class FilmAdapter extends BaseAdapter {

    // List to store the data that the adapter will display
    List<Film> films = new ArrayList<Film>();

    /**
     * This method is used to add a film to the list and then notify the adapter that the data set has changed.
     * This triggers the ListView to refresh and display the updated data.
     *
     * @param film The film to be added to the list.
     */
    public void add(Film film) {
        films.add(film);
        notifyDataSetChanged();
    }

    /**
     * This method returns the number of items in the data set.
     *
     * @return The size of the films list.
     */
    @Override
    public int getCount() {
        return films.size();
    }

    /**
     * This method returns the data item at the specified position in the data set.
     *
     * @param position The position of the item in the data set.
     * @return The film at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    /**
     * This method returns the row id of the item at the specified position in the data set.
     *
     * @param position The position of the item in the data set.
     * @return The position of the item.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * This method is used to get a View that displays the data at the specified position in the data set.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view we want.
     * @param convertView The old view to reuse, if possible. If it's null, a new view is inflated.
     * @param parent      The parent that this view will eventually be attached to.
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an old view can be reused, otherwise inflate a new view
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent
                    .getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.film_item_layout, null);
        }

        // Get the film at the current position
        Film film = films.get(position);

        // Set the title, genre and year of the film in the corresponding TextViews
        ((TextView) convertView.findViewById(R.id.filmTitle_textView)).setText(film.getTitle());
        ((TextView) convertView.findViewById(R.id.filmGenre_textView)).setText(film.getGenre());
        ((TextView) convertView.findViewById(R.id.filmYear_textView)).setText(String.format("%d year", film.getYear()));

        // Return the completed view to render on screen
        return convertView;
    }
}