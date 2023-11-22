package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.SingletonCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminCrud {
	public static ObservableList <Admin> getALL() {
		ObservableList <Admin> admins =FXCollections.observableArrayList();
		Connection cnx;
		cnx = SingletonCon.getCon() ;
		String rq = "SELECT * FROM `Admin` ";
		//représente le résultat d'une requête de base de données
		ResultSet rs; Admin a;
		
		try {
			PreparedStatement ps = cnx.prepareStatement(rq);
			rs= ps.executeQuery();
			while(rs.next()) {
				a= new Admin (rs.getInt("id") , rs.getString("login") , rs.getString("password"));
				admins.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins ;
	}
   public static int ajouter ( Admin a) {
	   //1.cnx
	   Connection cnx;
		cnx = SingletonCon.getCon() ;
		//2.rq n3aby les point d'interrogation
	   String rq = "INSERT INTO admin (login, password) VALUES (?,?)";
	    try {
	    	//2.1 preparer req
			PreparedStatement ps= cnx.prepareStatement(rq);
			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
			return ps.executeUpdate();//return nbr ligne de produit
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
   }
	    public static int delete ( Admin a) {
	 	   //1.cnx
	 	   Connection cnx;
	 		cnx = SingletonCon.getCon() ;
	 		//2.rq n3aby les point d'interrogation
	 	   String rq = ("DELETE FROM admin WHERE id=? ;");
	 	    try {
	 	    	//2.1 preparer req
	 			PreparedStatement ps= cnx.prepareStatement(rq);
	 			ps.setInt(1, a.getId());
	 			//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
	 			return ps.executeUpdate();//return nbr ligne de produit
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			return 0;
	 		}
	    }
	 	   public static int update ( Admin a) {
	 		   //1.cnx
	 		   Connection cnx;
	 			cnx = SingletonCon.getCon() ;
	 			//2.rq n3aby les point d'interrogation
	 		   String rq =" UPDATE admin SET login=?,password=? WHERE id=?;";
	 		    try {
	 		    	//2.1 preparer req
	 				PreparedStatement ps= cnx.prepareStatement(rq);
	 				ps.setString(1,  a.getLogin());
	 				ps.setString(2,a.getPassword());
	 				ps.setInt(3,a.getId());
	 				
	 				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
	 				return ps.executeUpdate();//return nbr ligne de produit
	 			} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 				return 0;
	 			}
	 	   }
	 		   public static int find ( Admin a) {
		 		   //1.cnx
		 		   Connection cnx;
		 			cnx = SingletonCon.getCon() ;
		 			//2.rq n3aby les point d'interrogation
		 		   String rq =" select * from admin WHERE id=?;";
		 		    try {
		 		    	//2.1 preparer req
		 				PreparedStatement ps= cnx.prepareStatement(rq);
		 				ps.setInt(1,  a.getId());
		 				ResultSet rs = ps.executeQuery();
		 				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
		 			//return nbr ligne de produit
		 				if(rs.next())
		 					return 1;
		 				else 
		 					return 0;
		 			} catch (SQLException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 				return 0;
		 			}
	 		    
   }
}

