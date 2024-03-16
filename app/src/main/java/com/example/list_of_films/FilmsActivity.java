package com.example.list_of_films;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_of_films.adapters.FilmAdapter;
import com.example.list_of_films.models.Film;

/**
 * This class represents an activity that displays a list of films.
 * It extends AppCompatActivity, which is a base class for activities that use the support library action bar features.
 */
public class FilmsActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting.
     * This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display
        EdgeToEdge.enable(this);
        // Set the activity content from a layout resource
        setContentView(R.layout.activity_films);
        // Set a listener to receive callbacks when the insets for this view have changed
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Get the system window insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Apply the insets as padding to the view
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            // Create a new FilmAdapter
            FilmAdapter adapter = new FilmAdapter();

            // Add films to the adapter
            adapter.add(new Film("Star Wars. Episode I: The Phantom Menace", "Science Fiction", 1999));
            adapter.add(new Film("Star Wars. Episode II: Attack of the Clones", "Science Fiction", 2002));
            adapter.add(new Film("Star Wars. Episode III: Revenge of the Sith", "Science Fiction", 2005));
            adapter.add(new Film("Star Wars. Episode IV: A New Hope", "Science Fiction", 1977));
            adapter.add(new Film("Star Wars. Episode V: The Empire Strikes Back", "Science Fiction", 1980));
            adapter.add(new Film("Star Wars. Episode VI: Return of the Jedi", "Science Fiction", 1983));
            adapter.add(new Film("Star Wars. Episode VII: The Force Awakens", "Science Fiction", 2015));
            adapter.add(new Film("Star Wars. Episode VIII: The Last Jedi", "Science Fiction", 2017));
            adapter.add(new Film("Star Wars. Episode IX: The Rise of Skywalker", "Science Fiction", 2019));
            adapter.add(new Film("Star Wars. Episode X: New Order of the Jedi", "Science Fiction", 2026));

            // Get the ListView and set the adapter
            ListView lvFilms = (ListView) findViewById(R.id.lv_films);
            lvFilms.setAdapter(adapter);

            // Return the insets
            return insets;
        });
    }
}