package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.prefs.Preferences;

@Data
public class ProjectBuilder {
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    @SerializedName(value = "suite_mode")
    private int typeOfProject;
    private boolean isCompleted;
    private User user;

    public static Preferences builder() {
        return null;
    }
}
