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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Strings variables
        String shopping_1 = getString(R.string.shopping_1);
        String shopping_1_description = getString(R.string.shopping_1_description);
        String shopping_2 = getString(R.string.shopping_2);
        String shopping_2_description = getString(R.string.shopping_2_description);
        String shopping_3 = getString(R.string.shopping_3);
        String shopping_3_description = getString(R.string.shopping_3_description);
        String shopping_4 = getString(R.string.shopping_4);
        String shopping_4_description = getString(R.string.shopping_4_description);
        String shopping_5 = getString(R.string.shopping_5);
        String shopping_5_description = getString(R.string.shopping_5_description);
        String shopping_6 = getString(R.string.shopping_6);
        String shopping_6_description = getString(R.string.shopping_6_description);

        // Create a list of contents
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(shopping_1_description, shopping_1, R.drawable.shopping_lanefield));
        contents.add(new Content(shopping_2_description, shopping_2, R.drawable.shopping_delmar));
        contents.add(new Content(shopping_3_description, shopping_3, R.drawable.shopping_westfield));
        contents.add(new Content(shopping_4_description, shopping_4, R.drawable.shopping_lasamericas));
        contents.add(new Content(shopping_5_description, shopping_5, R.drawable.shopping_bazaar));
        contents.add(new Content(shopping_6_description, shopping_6, R.drawable.shopping_del));

        // Create an {@link ContentAdapter}, whose data source is a list of {@link Content}s. The
        // adapter knows how to create list items for each item in the list.
        // getActivity() encloses "this" Fragment as the context.
        ContentAdapter adapter = new ContentAdapter(getActivity(), contents, R.color.category_shopping);

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
