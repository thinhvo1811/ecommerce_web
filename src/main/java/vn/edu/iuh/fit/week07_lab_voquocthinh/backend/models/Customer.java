package vn.edu.iuh.fit.week07_lab_voquocthinh.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;
    @Column(name = "cust_name", length = 150, nullable = false)
    private String name;
    @Column(name = "email", unique = true, length = 150, nullable = true)
    private String email;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String name, String email, String phone, String address, User user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}
