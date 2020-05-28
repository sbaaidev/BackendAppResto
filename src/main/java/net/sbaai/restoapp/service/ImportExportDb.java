package net.sbaai.restoapp.service;

import java.io.IOException;

public class ImportExportDb {
public static void main(String args[]) {
	
	try {
		Process p2 = Runtime.getRuntime().exec("cmd /c c:/\"Program Files\"/PostgreSQL/9.5/bin/pg_dump.exe -U admin  resto >D://out5.sql");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void importdb(String path,String db,String user){
	try {
		Process p2 = Runtime.getRuntime().exec("cmd /c c:/\"Program Files\"/PostgreSQL/9.5/bin/psql.exe -U "+user+" "+db+" <"+path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public void exportdb(String path,String db,String user){
	try {
		Process p2 = Runtime.getRuntime().exec("cmd /c c:/\"Program Files\"/PostgreSQL/9.5/bin/pg_dump.exe  -U "+user+" "+db+" >"+path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
