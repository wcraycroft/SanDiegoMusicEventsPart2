package edu.miracostacollege.cs134.sandiegomusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/*
 * This activity displays the details for a selected event, including the event name, date, day,
 * time, venue, city and state. The activity receives all text Strings from MainActivity.
 */
public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventArtistTextView;
    private TextView eventDateTextView;
    private TextView eventTimeTextView;
    private TextView eventVenueTextView;
    private TextView eventCityTextView;
    private TextView eventStateTextView;


    public static final String TAG = EventDetailsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent = getIntent();

        // Link View objects
        eventImageView = findViewById(R.id.eventImageView);
        eventArtistTextView = findViewById(R.id.eventArtistTextView);
        eventDateTextView = findViewById(R.id.eventDateTextView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);
        eventVenueTextView = findViewById(R.id.eventVenueTextView);
        eventCityTextView = findViewById(R.id.eventCityTextView);
        eventStateTextView = findViewById(R.id.eventStateTextView);

        // Set TextViews
        eventArtistTextView.setText(intent.getStringExtra("Artist"));
        eventDateTextView.setText(String.format("%s - %s", intent.getStringExtra("Date"),
                intent.getStringExtra("Day")));
        eventTimeTextView.setText(intent.getStringExtra("Time"));
        eventVenueTextView.setText(intent.getStringExtra("Venue"));
        eventCityTextView.setText(intent.getStringExtra("City"));
        eventStateTextView.setText(intent.getStringExtra("State"));

        // Set ImageView
        String title = intent.getStringExtra("ImageName");
        AssetManager am = getAssets();
        try {
            InputStream stream = am.open(title);
            Drawable eventImage = Drawable.createFromStream(stream, title);
            eventImageView.setImageDrawable(eventImage);
        }
        catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }

    }
}
