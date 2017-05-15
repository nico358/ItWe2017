package controller;

import model.JsonCollector;
import network.JsonSerializer;

public class NetworkController {
	
	private JsonCollector jsonCol; 
	private JsonSerializer JsonSer;
	
	public NetworkController(JsonCollector jsonCol, JsonSerializer JsonSer){
		this.jsonCol = jsonCol;
		this.JsonSer = JsonSer;
	}

}
