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
public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Strings variables
        String restaurant_1 = getString(R.string.restaurant_1);
        String restaurant_1_description = getString(R.string.restaurant_1_description);
        String restaurant_2 = getString(R.string.restaurant_2);
        String restaurant_2_description = getString(R.string.restaurant_2_description);
        String restaurant_3 = getString(R.string.restaurant_3);
        String restaurant_3_description = getString(R.string.restaurant_3_description);
        String restaurant_4 = getString(R.string.restaurant_4);
        String restaurant_4_description = getString(R.string.restaurant_4_description);
        String restaurant_5 = getString(R.string.restaurant_5);
        String restaurant_5_description = getString(R.string.restaurant_5_description);
        String restaurant_6 = getString(R.string.restaurant_6);
        String restaurant_6_description = getString(R.string.restaurant_6_description);

        // Create a list of contents
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(restaurant_1_description, restaurant_1, R.drawable.restaurant_coasterra));
        contents.add(new Content(restaurant_2_description, restaurant_2, R.drawable.restaurant_peohes));
        contents.add(new Content(restaurant_3_description, restaurant_3, R.drawable.restaurant_blue_point));
        contents.add(new Content(restaurant_4_description, restaurant_4, R.drawable.restaurant_georges));
        contents.add(new Content(restaurant_5_description, restaurant_5, R.drawable.restaurant_starlite));
        contents.add(new Content(restaurant_6_description, restaurant_6, R.drawable.restaurant_civico));

        // Create an {@link ContentAdapter}, whose data source is a list of {@link Content}s. The
        // adapter knows how to create list items for each item in the list.
        // getActivity() encloses "this" Fragment as the context.
        ContentAdapter adapter = new ContentAdapter(getActivity(), contents, R.color.category_restaurants);

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
