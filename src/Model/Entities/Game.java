package Model.Entities;

import Model.Enums.GenderEnum;
import Model.Enums.StatusEnum;

import java.time.LocalDate;

public class Game {
    private int id;
    private String title;
    private GenderEnum gender;
    private String platform;
    private LocalDate launchDate;
    private StatusEnum status;

    public Game(int id, String title, GenderEnum gender, String platform, LocalDate launchDate, StatusEnum status) {
        this.id = id;
        this.title = title;
        this.gender = gender;
        this.platform = platform;
        this.launchDate = launchDate;
        this.status = status;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public GenderEnum getGender() { return gender; }
    public String getPlatform() { return platform; }
    public LocalDate getLaunchDate() { return launchDate; }
    public StatusEnum getStatus() { return status; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setGender(GenderEnum gender) { this.gender = gender; }
    public void setPlatform(String platform) { this.platform = platform; }
    public void setLaunchDate(LocalDate launchDate) { this.launchDate = launchDate; }
    public void setStatus(StatusEnum status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("%s (%s) - %s [%s]", title, platform, gender, status);
    }
}
