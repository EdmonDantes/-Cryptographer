package mainpackage;

public class MyException extends Exception {
	private static final long serialVersionUID = 5617323265658691711L;
	private int id = -1;
	
	public MyException(int id){
		super();
		this.id = id;
	}
	
	public int getID(){
		return id;
	}

}
