package com.example.mohamed.test;

//import android.os.Parcel;
//import android.os.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    @SerializedName("original_title")
    @Expose
    String title;
    @SerializedName("poster_path")
    @Expose
    String poster;
    @SerializedName("overview")
    @Expose
    String overview;
    @SerializedName("vote_average")
    @Expose
    String vote;
    @SerializedName("release_data")
    @Expose
    String release;
    @SerializedName("id")
    @Expose
    String id;



    protected Movie(Parcel in) {
        title = in.readString();
        poster = in.readString();
        overview = in.readString();
        vote = in.readString();
        release = in.readString();
        id = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//
//    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster);
        dest.writeString(overview);
        dest.writeString(vote);
        dest.writeString(release);
        dest.writeString(id);
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getOverview() {
        return overview;
    }

    public String getVote() {
        return vote;
    }

    public String getRelease() {
        return release;
    }

    public String getId() {
        return id;
    }

    public static Creator<Movie> getCREATOR() {
        return CREATOR;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movi{" +
                "original_title='" + title + '\'' +
                ", id=" + id +
                ", vote_average=" + vote +
                ", poster_path='" + poster + '\'' +
                ", release_date='" + release + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
