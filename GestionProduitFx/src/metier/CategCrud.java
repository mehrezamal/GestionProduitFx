package metier;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	//import java.util.ArrayList;
	//import java.util.List;

	import DAO.SingletonCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
	public class CategCrud {
		
		public static  ObservableList <Categ> getALL() {
			//List<Categ> categs = new ArrayList <Categ>();
			ObservableList <Categ> categs =FXCollections.observableArrayList();
			Connection cnx;
			cnx = SingletonCon.getCon() ;
			String rq = "SELECT * FROM `categorie` ";
			//représente le résultat d'une requête de base de données
			ResultSet rs; Categ g;
			
			try {
				PreparedStatement ps = cnx.prepareStatement(rq);
				rs= ps.executeQuery();
				while(rs.next()) {
					g= new Categ (rs.getInt("code") , rs.getString("nomcateg"));
					categs.add(g);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return categs;
		}
	   public static int ajouter (Categ g) {
		   //1.cnx
		   Connection cnx;
			cnx = SingletonCon.getCon() ;
			//2.rq n3aby les point d'interrogation
		   String rq = "INSERT INTO categorie (nomcateg) VALUES (?)";
		    try {
		    	//2.1 preparer req
				PreparedStatement ps= cnx.prepareStatement(rq);
				ps.setString(1, g.getNomcateg());
				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
				return ps.executeUpdate();//return nbr ligne de produit
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
	   }
		    public static int delete ( Categ g) {
		 	   //1.cnx
		 	   Connection cnx;
		 		cnx = SingletonCon.getCon() ;
		 		//2.rq n3aby les point d'interrogation
		 	   String rq = ("DELETE FROM categorie WHERE code=? ;");
		 	    try {
		 	    	//2.1 preparer req
		 			PreparedStatement ps= cnx.prepareStatement(rq);
		 			ps.setInt(1, g.getCode());
		 			//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
		 			return ps.executeUpdate();//return nbr ligne de produit
		 		} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 			return 0;
		 		}
		    }
		 	   public static int update (Categ g) {
		 		   //1.cnx
		 		   Connection cnx;
		 			cnx = SingletonCon.getCon() ;
		 			//2.rq n3aby les point d'interrogation
		 		   String rq =" UPDATE categorie SET nomcateg=? WHERE code=?;";
		 		    try {
		 		    	//2.1 preparer req
		 				PreparedStatement ps= cnx.prepareStatement(rq);
		 				ps.setString(1,  g.getNomcateg());
		 				ps.setInt(2,g.getCode());
		 				
		 				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
		 				return ps.executeUpdate();//return nbr ligne de produit
		 			} catch (SQLException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 				return 0;
		 			}
		 	   }
		 		   public static int find (Categ g) {
			 		   //1.cnx
			 		   Connection cnx;
			 			cnx = SingletonCon.getCon() ;
			 			//2.rq n3aby les point d'interrogation
			 		   String rq =" select * from categorie WHERE code=?;";
			 		    try {
			 		    	//2.1 preparer req
			 				PreparedStatement ps= cnx.prepareStatement(rq);
			 				ps.setInt(1,  g.getCode());
			 				//représente le résultat d'une requête de base de données. Le texte sur les requêtes montre comment le résultat d'une requête est renvoyé sous forme de java.
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



