package Model;

import androidx.annotation.NonNull;

import java.util.Random;

public class EmployeePartTime extends Employee {

    public EmployeePartTime(int id, String name) {
        super(id, name);
    }

    @Override
    public long TinhLuong() {
        Random rd = new Random();
        return rd.nextLong();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString() + "Parttime " + TinhLuong();
    }
}
