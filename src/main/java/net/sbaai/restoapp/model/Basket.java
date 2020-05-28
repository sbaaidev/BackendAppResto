package net.sbaai.restoapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Basket implements Serializable{
private Map<Long,Command_line> items=new HashMap<Long,Command_line>();


public void addLineFood(Food f,int qte){
	 
	Command_line cl=new Command_line();
		if(items.get(f.getIdFood())==null){
		//System.out.println(items.get(f.getIdFood()));
		cl.setFood(f);
		cl.setQte(qte);
		cl.setPrix(f.getPrix());
		System.out.println("qte :"+cl.getQte());
		items.put(f.getIdFood(), cl);
		
	}else{
		Command_line lc=items.get(f.getIdFood());
		lc.setQte(lc.getQte()+qte);
		//items.put(f.getIdFood(), cl);
	}
}

public Collection<Command_line> getItems(){
	return items.values();
}

public double getTotal(){
	double total=0;
	for(Command_line lc:items.values()){
		total+=lc.getPrix()*lc.getQte();
	}
	return total;
}

public int getSize(){
	return items.size();
}

public void deleteItem(Long idFood){
	items.remove(idFood);
}

}
