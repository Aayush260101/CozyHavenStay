package example.example6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Result {
	@Id
	@Column
	int rid;
	public Result(int rid, int marks, String sub) {
		super();
		this.rid = rid;
		this.marks = marks;
		this.sub = sub;
	}
	
	@Column
	int marks;
	@Column
	String sub;
	
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
	
}
