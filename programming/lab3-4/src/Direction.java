public enum Direction {
    AWAY ("В сторону"),
    LEFT ("Влево"),
    RIGHT ("Вправо");
    private final String title;

    Direction(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "title='" + title + '\'' +
                '}';
    }
}
