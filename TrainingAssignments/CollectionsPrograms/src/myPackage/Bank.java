package myPackage;


public class Bank
{
	static int c;
	int ActNo;
	String name,email;
	double balance;
	static int no_of_customers;
	static void no_of_customers() {
		no_of_customers=c;
		System.out.println("No. of Customers : "+no_of_customers);
	}
	
	public void setActNo(int ActNo){
		this.ActNo=ActNo;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setemail(String email){
		this.email=email;
	}
	public void setbalance(double balance){
		this.balance=balance;
	}
	public int getActNo() {
		return ActNo;
	}
	public String getname() {
		return name;
	}
	public String getemail() {
		return email;
	}
	public double getbalance() {
		return balance;
	}
	public Bank() {
		c++;
		this.ActNo=c;
	}
	public Bank(String name,String email,Double balance) {
		c++;
		this.ActNo=c;
		this.name=name;
		this.email=email;
		this.balance=balance;
	}
	@Override
    public String toString() {
        return "Account Number: " + ActNo + ", Name: " + name + ", Email: " + email + ", Balance: " + balance;
    }
	
}

