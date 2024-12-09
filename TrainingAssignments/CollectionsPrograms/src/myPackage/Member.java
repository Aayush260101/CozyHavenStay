package myPackage;

public class Member {
	private int member_id;
    private String name;
    
 
    // Constructor
    public Member(int member_id, String name) {
        this.member_id = member_id;
        this.name = name;
        
    }
 
    // Getters and Setters
    public int getMemberId() {
        return member_id;
    }
 
    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }
 
    public String getname() {
        return name;
    }
 
    public void setname(String name) {
        this.name = name;
    }
 
	/*
	 * public String getAuthor() { return author; }
	 * 
	 * public void setAuthor(String author) { this.author = author; }
	 */
 
	/*
	 * public double getPrice() { return price; }
	 * 
	 * public void setPrice(double price) { this.price = price; }
	 */
 
    @Override
    public String toString() {
        return "Member [Memberid=" + member_id + ", Name=" + name + "]";
    }
}
