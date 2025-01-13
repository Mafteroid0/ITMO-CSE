public enum FruitType {
    PEAR ("Груша"),
    APPLE("Яблоко"),
    BERRY("Ягода");
    private final String title;

    FruitType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "FruitType{" +
                "title='" + title + '\'' +
                '}';
    }
}
