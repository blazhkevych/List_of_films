package com.example.list_of_films;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.list_of_films.adapters.FilmAdapter;
import com.example.list_of_films.models.Film;

public class AddFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_film);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);





            // Create a new FilmAdapter
            //FilmAdapter adapter = new FilmAdapter();
            ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = ((EditText) findViewById(R.id.editTitle)).getText().toString();
                    String genre = ((EditText) findViewById(R.id.editGenre)).getText().toString();
                    int year = Integer.parseInt(((EditText) findViewById(R.id.editYear)).getText().toString());

                    Film film = new Film(title, genre, year);
                    // Add the film to the adapter
                    //adapter.add(film);

                    FilmAdapter filmAdapter = FilmsActivity.getAdapter();
                    filmAdapter.add(film);
                    // Это уведомит адаптер о том, что данные изменились, и он обновит отображение.
                    filmAdapter.notifyDataSetChanged();
                    // вернуться на предыдущую активность
                    finish();









                }
            });





            return insets;
        });
    }
}