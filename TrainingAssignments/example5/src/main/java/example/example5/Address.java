package example.example5;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	int house_no;
	String city;
	public int getHouse_no() {
		return house_no;
	}
	public void setHouse_no(int house_no) {
		this.house_no = house_no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [house_no=" + house_no + ", city=" + city + "]";
	}
}
