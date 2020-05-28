package net.sbaai.restoapp.service;


import javafx.application.Platform;

import net.sbaai.restoapp.model.Message;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageThread extends Thread{
	//private IAdminService service=ServiceClass.getService();
	private int size=0;

	

	//Main main;
	

	public MessageThread() {
	
	}
	public void run() {
	//main=new Main();
	try {
		ServerSocket server=new ServerSocket(4000);
		System.out.println("sever is running");
		while(true){
			Socket s=server.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			Message msg=new Message(dis.readUTF());
			//Platform.runLater(() ->main.messageWindow(msg));
			dis.close();
			s.close();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		
	}
	};

}
