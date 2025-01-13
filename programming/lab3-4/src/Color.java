public enum Color {
    RED("Красный"),
    GINGER("Рыжий"),
    BLUE("Синий"),
    WHITE("Белый"),
    GREEN("Зелёный");
    private final String title;

    Color(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }
}
