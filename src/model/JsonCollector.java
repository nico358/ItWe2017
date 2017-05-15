package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
public class JsonCollector extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4281933782407823951L;
	
	public JsonCollector(){
		this.put("Metadata ", String.format("Metadata ", String.format("Date of change %1$s, FileSize %2$s", LocalDate.now().getDayOfWeek() + " " + LocalTime.now().getHour() + "Uhr" + LocalTime.now().getMinute(), this.size())));
	}
	
	public void addObject(String key, Object obj){
		this.put(key, obj);
		this.replace("Metadata ", String.format("Date of change %1$s, FileSize %2$s", LocalDate.now().getDayOfWeek() + " " + LocalTime.now().getHour() + "Uhr" + LocalTime.now().getMinute(), this.size()));
	}
	
	public Object getObject(String key){
		return this.get(key);
	}
	
	public void printAll(){
		this.forEach((k,v) -> System.out.println(k+ " " +v));	
	}
	
	public HashMap<String, Object> getAll(){
		return this;
	}
	
	public void setAll(HashMap<String, Object> map){
		this.clear();
		this.putAll(map);
		this.put("Metadata ", String.format("Date of change %1$s, FileSize %2$s", LocalDate.now().getDayOfWeek() + " " + LocalTime.now().getHour() + "Uhr" + LocalTime.now().getMinute(), this.size()));
	}
	

}