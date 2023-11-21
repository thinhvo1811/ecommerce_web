package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.enums;

public enum UserType {
    CUSTOMER(0),
    EMPLOYEE(1);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
