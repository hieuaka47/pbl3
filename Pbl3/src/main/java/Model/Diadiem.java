package Model;

import java.util.*;

public class Diadiem {
 private int idlocation;
 private String diadiem;
 
 public Diadiem() {
	 
 }

public Diadiem(int idlocation, String diadiem) {
	
	this.idlocation = idlocation;
	this.diadiem = diadiem;
}

public int getIdlocation() {
	return idlocation;
}

public void setIdlocation(int idlocation) {
	this.idlocation = idlocation;
}

public String getDiadiem() {
	return diadiem;
}

public void setDiadiem(String diadiem) {
	this.diadiem = diadiem;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Diadiem{"+"idlocation"+idlocation+",diadiem"+diadiem+'}';
}



 
 
}
