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
public class BeachesFragment extends Fragment {

    public BeachesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_list, container, false);

        // Strings
        String beach_1 = getString(R.string.beach_1);
        String beach_1_description = getString(R.string.beach_1_description);
        String beach_2 = getString(R.string.beach_2);
        String beach_2_description = getString(R.string.beach_2_description);
        String beach_3 = getString(R.string.beach_3);
        String beach_3_description = getString(R.string.beach_3_description);
        String beach_4 = getString(R.string.beach_4);
        String beach_4_description = getString(R.string.beach_4_description);
        String beach_5 = getString(R.string.beach_5);
        String beach_5_description = getString(R.string.beach_5_description);
        String beach_6 = getString(R.string.beach_6);
        String beach_6_description = getString(R.string.beach_6_description);

        // Create a list of contents
        final ArrayList<Content> contents = new ArrayList<Content>();
        contents.add(new Content(beach_1_description, beach_1, R.drawable.kaanapali_beach));
        contents.add(new Content(beach_2_description, beach_2, R.drawable.keawakapu_beach));
        contents.add(new Content(beach_3_description, beach_3, R.drawable.kapalua_beach));
        contents.add(new Content(beach_4_description, beach_4, R.drawable.kahekili_beach));
        contents.add(new Content(beach_5_description, beach_5, R.drawable.napili_bay));
        contents.add(new Content(beach_6_description, beach_6, R.drawable.baby_beach));

        // Create an {@link ContentAdapter}, whose data source is a list of {@link Content}s. The
        // adapter knows how to create list items for each item in the list.
        // getActivity() encloses "this" Fragment as the context.
        ContentAdapter adapter = new ContentAdapter(getActivity(), contents, R.color.category_beaches);

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
