package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;

import connectors.CriarConexao;

public class CsvDAO extends CriarConexao { 
	
	public void csv() throws FileNotFoundException{
	
	try {
		this.stmt = this.getConnection().createStatement();
	                    System.out.println("CONECTADO!!!!!");
	                    this.rs = this.stmt.executeQuery("SELECT * FROM CANDIDATOS");
	                   File file = new File("arquivo.txt");
	                    PrintWriter pw = new PrintWriter(file);
	                    while(rs.next()){
	                    pw.printf("%s;%s;%s\n", rs.getString("Numero"),rs.getString("Nome"), rs.getString("Voto"));
	      System.out.printf("%s;%s;%s\n", rs.getString("Numero"),rs.getString("Nome"), rs.getString("Voto"));
	    }
	    pw.flush();
	    pw.close();
	            }catch(SQLException e){
	                e.printStackTrace();
	            }
	      }
	  }


