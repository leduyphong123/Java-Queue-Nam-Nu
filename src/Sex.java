public class Sex {
    private int id;
    private String name;
    private int age;
    private String gt;

    Sex(int id, String name, int age, String gt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gt = gt;
    }

    public String getGt() {
        return this.gt;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "name: " + name + " - age: " + age + " - gt: " + gt;
    }
}
