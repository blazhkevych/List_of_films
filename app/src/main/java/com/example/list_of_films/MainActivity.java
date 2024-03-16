package com.example.list_of_films;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * This class represents the main activity of the application.
 * It extends AppCompatActivity, which is a base class for activities that use the support library action bar features.
 */
public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        // Set a listener to receive callbacks when the insets for this view have changed
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            // Get the system window insets
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Apply the insets as padding to the view
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            MainActivity activity = this;

            // Set a click listener for the button
            ((Button) findViewById(R.id.btnFilms)).setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when the button is clicked.
                 * @param view The view that was clicked.
                 */
                @Override
                public void onClick(View view) {
                    // Create a new intent to start the FilmsActivity
                    Intent intent = new Intent(activity, FilmsActivity.class);
                    // Start the activity
                    activity.startActivity(intent);
                }
            });

            // Return the insets
            return insets;
        });
    }
}