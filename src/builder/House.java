package builder;

public class House {

    private Integer walls;
    private Integer windows;
    private String color;

    @Override
    public String toString() {
        return "House{" +
                "walls=" + walls +
                ", windows=" + windows +
                ", color='" + color + '\'' +
                '}';
    }

    private House(HouseBuilder houseBuilder) {
        walls = houseBuilder.walls;
        windows = houseBuilder.windows;
        color = houseBuilder.color;
    }

    public static class HouseBuilder {
        private Integer walls;
        private Integer windows;
        private String color;

        public HouseBuilder setWalls(Integer walls) {
            this.walls = walls;
            return this;
        }

        public HouseBuilder setWindows(Integer windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public House build() {
            return new House(this);
        }

    }

}
