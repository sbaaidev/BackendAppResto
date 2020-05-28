package net.sbaai.restoapp.service;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import net.sbaai.restoapp.dao.IOperation;
import net.sbaai.restoapp.model.Tables;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionTables extends Thread{
	public  Button tb;
	private Tables i;
	@Autowired
	private IOperation service;;
	/*public  ActionTables(Button btn,Tables i,IAdminService service) {
		this.tb=btn;
		this.i=i;
		this.service=service;	
	}*/
@Override
public void run() {
		tb.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			System.out.println("table"+i.toString()+i.isReserved());
			if(i.isReserved()==false){
				/*i.setReserved(true);
				tb.setStyle("-fx-border-color: red;\n"
		                + "-fx-border-insets: 5;\n"
		                + "-fx-border-width: 3;\n"
		                + "-fx-border-style: dashed;\n"
		                +"-fx-background-color:#eee000;\n");*/
						//CommandController.table=i;
						///main.commandWindow();
				//tb.setText(" �����"+i.toString());
			}else{
				i.setReserved(false);
				tb.setStyle("-fx-border-color: green;\n"
		                + "-fx-border-insets: 5;\n"
		                + "-fx-border-width: 3;\n"
		                + "-fx-border-style: dashed;\n"
		                +"-fx-background-color:lightblue;\n");
				tb.setText(" ����� �����"+i.toString());
				//service.updateTables(i);
			}
			
			}
		});	
}
}
