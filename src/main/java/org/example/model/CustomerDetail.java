package org.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CUSTOMER_DETAIL")
public class CustomerDetail {

    //birebir ilişkiin kurulduğu alan
    @OneToOne
    @JoinColumn
    private Customer customer; //buradaki customerla mappliyoruz
    // --------------------------------------------------------------------------------------

    @Id
    @GenericGenerator(name="generator",strategy = "foreign",
            parameters = @Parameter(name="property",value="customer"))
    @GeneratedValue(generator = "generator")
    @Column(name = "CUSTOMER_ID")
    private int customerId;

    @Column(name="ADDRESS",nullable = false)
    private String address;

    @Column(name="PHONE")
    private String phone;

    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_DATE")
    private Date recordDate;

    public CustomerDetail() {
    }

    public CustomerDetail(int customerId, String address, String phone, Date recordDate) {
        this.customerId = customerId;
        this.address = address;
        this.phone = phone;
        this.recordDate = recordDate;
    }

    public CustomerDetail(String address, String phone, Date recordDate) {
        this.address = address;
        this.phone = phone;
        this.recordDate = recordDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
