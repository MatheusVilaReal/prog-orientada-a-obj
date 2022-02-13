import java.util.Calendar;

public class Costumer{

	private int age;
	
	private String name,
		   		   task;
	
	private Calendar queueJoinTime;
	
/********************************************************************/
	
	public Costumer(String name, int age, String task){
		
		this.name = name.toUpperCase();
		this.age = age;
		this.task = task;
		
		this.queueJoinTime = Calendar.getInstance();
	}
	
	public String getName(){
		
		return this.name;
	}
	
	public int getAge(){
		
		return this.age;
	}
	
	public String getTask(){
		
		return this.task;
	}
	
	public boolean compareCostumerName(String name){
		
		return this.name.equals(name.toUpperCase());
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
	public void setAge(int age){
		
		this.age = age;
	}
	
	public void setTask(String task){
		
		this.task = task;
	}
	
	public void displayCostumer(String header){
		
		boolean am_pm = this.queueJoinTime.get(Calendar.AM) > 0; 
		
		System.out.printf("%s", header);
		
		System.out.printf("Nome: %S; Idade: %d; Horário de chegada: %02d:%02d:%02d %s;" + 
						  "\nServiço a ser realizado: %s\n",
						  this.name, this.age, this.queueJoinTime.get(Calendar.HOUR),
						  this.queueJoinTime.get(Calendar.MINUTE),
						  this.queueJoinTime.get(Calendar.SECOND),
						  (am_pm)? "PM" : "AM",
						  this.task);
	}
}
