public enum Size {
    Small("Маленького размера", 30),
    Medium("Среднего размера", 75),
    Large("Большого размера", 150);
    private final String title;
    private final int height;

    Size(String title, int height) {
        this.title = title;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }
    public int toHeight(){
        return height;
    }

    @Override
    public String toString() {
        return "Size{" +
                "title='" + title + '\'' +
                '}';
    }
}
