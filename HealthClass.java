public class Main {
	public static void main(String[] args) {
		Check_up patient1=new Check_up();
		patient1.setHealth("good");
		patient1.setMedicine("taken")
		print(patient1.report());
	}
	static void print(String a){
		System.out.println(a);
	}
}
class Check_up{
	String health;
	String first_aid;
	String prev_disease;
	public  void setHealth(String health){
		this.health=health;
	}
	public  String getHealth(){
		return health;
	}
	public void setFirst_aid(String aid){
		this.first_aid=aid;
	}
	public String getMedicine(){
		return medicine;
	}
	public void setPrev_disease(String prev_disease){
		this.prev_disease=prev_disease;
	}
	public String getPrev_disease(){
		return medicine;
	}
	public String report(){
		String Report;
		if (health=="good"){
			if(medicine=="taken" && prev_disease=="no"){
			    Report="You Do Not Need To See A Docter!"};
		}
		else{
			Report="You Need To See A Docter!";
		}
		return Report;
	}
}
