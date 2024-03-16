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

public class FilmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_films);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            FilmAdapter adapter = new FilmAdapter();

            adapter.add(new Film("Звездные войны. Эпизод I: Скрытая угроза", "Фантастика", 1999));
            adapter.add(new Film("Звездные войны. Эпизод II: Скрытая угроза", "Фантастика", 2002));
            adapter.add(new Film("Звездные войны. Эпизод III: Скрытая угроза", "Фантастика", 2005));
            adapter.add(new Film("Звездные войны. Эпизод IV: Скрытая угроза", "Фантастика", 1977));
            adapter.add(new Film("Звездные войны. Эпизод V: Империя наносит ответный удар", "Фантастика", 1980));
            adapter.add(new Film("Звездные войны. Эпизод VI: Возвращение джедая", "Фантастика", 1983));
            adapter.add(new Film("Звездные войны. Эпизод VII: Пробуждение силы", "Фантастика", 2015));
            adapter.add(new Film("Звездные войны. Эпизод IIX: Последние джедаи", "Фантастика", 2017));
            adapter.add(new Film("Звездные войны. Эпизод IX: Скайуокер. Восход", "Фантастика", 2019));
            adapter.add(new Film("Звездные войны. Эпизод X: Новый орден джедаев", "Фантастика", 2026));

            ListView lvFilms  = (ListView) findViewById(R.id.lv_films);
            lvFilms.setAdapter(adapter);

            return insets;
        });
    }
}