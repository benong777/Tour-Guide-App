package com.example.android.tourguide;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {
    public EntertainmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Strings variables
        String activities_1 = "SeaWorld";
        String activities_1_description = "Spread across the beautiful Mission Bay Park, SeaWorld is known for its amazing animals, interactive attractions and rides.";
        String activities_2 = "San Diego Zoo";
        String activities_2_description = "San Diego zoo is a tropical oasis with amazing habitats for gorillas, Komodo dragons, tigers, polar bears, and pandas.";
        String activities_3 = "LegoLand";
        String activities_3_description = "Families can enjoy rides, shows and attractions! Marvel at cities built entirely out of millions of LEGO® bricks.";
        String activities_4 = "Maritime Museum";
        String activities_4_description = "Experience a world-class collection of historic sailing ships, steam-powered boats, and submarines.";
        String activities_5 = "Cabrillo National Park";
        String activities_5_description = "San Diego's 'only' National Park offers tremendous views and excellent opportunities to explore it's history.";
        String activities_6 = "Belmont Park Amusement";
        String activities_6_description = "Located on Mission Beach, Belmont Park is San Diego's only beachfront amusement and entertainment center!";

        // Create a list of contents
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(activities_1_description, activities_1, R.drawable.activities_sea_world));
        contents.add(new Content(activities_2_description, activities_2, R.drawable.activities_sd_zoo));
        contents.add(new Content(activities_3_description, activities_3, R.drawable.activities_legoland));
        contents.add(new Content(activities_4_description, activities_4, R.drawable.activities_maritime));
        contents.add(new Content(activities_5_description, activities_5, R.drawable.activities_cabrillo));
        contents.add(new Content(activities_6_description, activities_6, R.drawable.activities_belmont_park));

        // Create an {@link ContentAdapter}, whose data source is a list of {@link Content}s. The
        // adapter knows how to create list items for each item in the list.
        // getActivity() encloses "this" Fragment as the context.
        ContentAdapter adapter = new ContentAdapter(getActivity(), contents, R.color.category_entertainment);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // content_list.xml layout file.
        // The rootView object contains children views such as the ListView
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ContentAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Content} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Content} object at the given position the user clicked on
                Content content = contents.get(position);
            }
        });
        return rootView;
    }
}
