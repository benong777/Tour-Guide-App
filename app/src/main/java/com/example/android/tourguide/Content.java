package com.example.android.tourguide;

/**
 * {@link Content} represents a location name, description, and an image.
 */
public class Content {

    private String mDescription;
    private String mTitle;

    /** Image resource ID */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Content object.
     *
     * @param title
     * @param description 
     */
    public Content(String description, String title) {
        mDescription = description;
        mTitle = title;
    }

    /**
     * Create a new Content object.
     *
     * @param title
     * @param description
     * @param imageResourceId is the drawable resource ID for the image
     */
    public Content(String description, String title, int imageResourceId) {
        mDescription = description;
        mTitle = title;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the description of the location
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Get the title of the location
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
