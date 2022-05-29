package Model;

public abstract class Employee {
    private int id;
    private String name;

    public abstract long TinhLuong();

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", name= '" + name;
    }
}
