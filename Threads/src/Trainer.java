public class Trainer implements Person {
    private String name;

    public Trainer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                '}';
    }
}
