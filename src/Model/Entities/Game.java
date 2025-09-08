package Model.Entities;

import java.time.LocalDate;

public class Game {
    private int id;
    private String title;
    private String gender;
    private String platform;
    private int launchDate;
    private String status;
    private int rating;

    public Game(){
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGender() { return gender; }
    public String getPlatform() { return platform; }
    public int getLaunchDate() { return launchDate; }
    public String getStatus() { return status; }
    public int getRating() { return rating; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPlatform(String platform) { this.platform = platform; }
    public void setLaunchDate(int launchDate) { this.launchDate = launchDate; }
    public void setStatus(String status) { this.status = status; }
    public void setRating(int rating) { this.rating = rating; }


    @Override
    public String toString() {
        return String.format("%s (%s) - %s [%s]", title, platform, gender, status);
    }
}
