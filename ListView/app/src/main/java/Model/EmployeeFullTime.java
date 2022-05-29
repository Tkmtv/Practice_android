package Model;

import androidx.annotation.NonNull;

import java.util.Random;

public class EmployeeFullTime extends Employee {

    public EmployeeFullTime(int id, String name) {
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
        return super.toString() + "Fulltime " + TinhLuong();
    }
}
