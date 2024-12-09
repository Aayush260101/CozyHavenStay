package example.example4;
 
 
import javax.persistence.*;
import java.util.Date;
 
@Entity
@Table(name = "STUDENT")
public class Student {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;
 
    @Column
    private String name;
 
    @Column
    private double fee;
 
    @Temporal(TemporalType.DATE)
   
    private Date admissionDate;
 
    @Temporal(TemporalType.TIMESTAMP)
   
    private Date lastUpdated;
 
    @Lob // Annotation to specify that this column stores large binary data
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private byte[] image;
 
    @Transient
    private String tempInfo;
 
    // Getters and setters
    public int getRollno() {
        return rollno;
    }
 
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getFee() {
        return fee;
    }
 
    public void setFee(double fee) {
        this.fee = fee;
    }
 
    public Date getAdmissionDate() {
        return admissionDate;
    }
 
    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }
 
    public Date getLastUpdated() {
        return lastUpdated;
    }
 
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
 
    public byte[] getImage() {
        return image;
    }
 
    public void setImage(byte[] image) {
        this.image = image;
    }
 
    public String getTempInfo() {
        return tempInfo;
    }
 
    public void setTempInfo(String tempInfo) {
        this.tempInfo = tempInfo;
    }
 
    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", fee=" + fee + "]";
    }
}