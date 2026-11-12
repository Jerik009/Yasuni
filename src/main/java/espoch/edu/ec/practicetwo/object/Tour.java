package espoch.edu.ec.practicetwo.object;

public class Tour {

    private String code;
    private String title;
    private float level;
    private Trail[] paths;

    public Tour() {
    }

    public Tour(String code, String title, Trail[] paths, float level) {
        this.code = code;
        this.title = title;
        this.paths = paths;
        this.level = 1.0f;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public Trail[] getPaths() {
        return paths;
    }

    public void setPaths(Trail[] paths) {
        this.paths = paths;
    }

}
