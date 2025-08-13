package in.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_amount")
    private String courseAmount;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "date_of_purchase")
    private String dateOfPurchase;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "rzp_paymentid")
    private String rzpPaymentId;

    @Column(name = "user_email")
    private String userEmail;

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseAmount() {
        return courseAmount;
    }
    public void setCourseAmount(String courseAmount) {
        this.courseAmount = courseAmount;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }
    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRzpPaymentId() {
        return rzpPaymentId;
    }
    public void setRzpPaymentId(String rzpPaymentId) {
        this.rzpPaymentId = rzpPaymentId;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
