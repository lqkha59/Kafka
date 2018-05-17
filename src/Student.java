
public class Student {
	private String exception;
	private int userid;
	public Student(String exception, int userid) {
		super();
		this.exception = exception;
		this.userid = userid;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
