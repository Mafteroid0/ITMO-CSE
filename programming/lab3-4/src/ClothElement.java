public enum ClothElement {
    Trousers("Штаны"),
    Sandals("Сандали"),
    Boots("Ботинки"),
    Blazer("Пиджак"),
    Cap("Кепка"),
    Spacesuit("Скафандр");
    private final String title;

    ClothElement(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "ClothElement{" +
                "title='" + title + '\'' +
                '}';
    }
}
