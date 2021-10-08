package umn.ac.uts_00000036266;

import android.os.Parcel;
import android.os.Parcelable;

public class Library implements Parcelable {
    private String title;
    private String category;
    private String soundURI;

    public Library(String title, String category, String soundURI){
        this.title = title;
        this.category = category;
        this.soundURI = soundURI;
    }

    protected Library(Parcel in) {
        title = in.readString();
        category = in.readString();
        soundURI = in.readString();
    }

    public static final Creator<Library> CREATOR = new Creator<Library>() {
        @Override
        public Library createFromParcel(Parcel in) {
            return new Library(in);
        }

        @Override
        public Library[] newArray(int size) {
            return new Library[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSoundURI() {
        return soundURI;
    }

    public void setSoundURI(String soundURI) {
        this.soundURI = soundURI;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(category);
        parcel.writeString(soundURI);
    }
}
