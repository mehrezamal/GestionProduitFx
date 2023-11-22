package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.SingletonCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProduitCrud {
	public static ObservableList <Produit> getALL() {
		/*List<Produit> produits = new ArrayList <Produit>();*/
		ObservableList <Produit> produits =FXCollections.observableArrayList();
		Connection cnx;
		cnx = SingletonCon.getCon() ;
		String rq = "SELECT * FROM `produit` ";
		//représente le résultat d'une requête de base de données
		ResultSet rs; Produit p;
		
		try {
			//preparer la requette
			PreparedStatement ps = cnx.prepareStatement(rq);
			rs= ps.executeQuery();
			while(rs.next()) {
				p= new Produit (rs.getInt("id") , rs.getString("lib") , rs.getString("image") , rs.getInt("quantite") , rs.getInt("prix") , rs.getString("categ"));
				produits.add(p);
			}
			//try catch gestion des erreurs
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
	//ajouter un produit
   public static int ajouter ( Produit p) {
	   //1.cnx
	   Connection cnx;
		cnx = SingletonCon.getCon() ;
		//2.rq n3aby les point d'interrogation
	   String rq = "INSERT INTO produit (lib, image, quantite, prix,categ) VALUES (?,?,?,?,?)";
	    try {
	    	//2.1 preparer req
			PreparedStatement ps= cnx.prepareStatement(rq);
			ps.setString(1, p.getLib());
			ps.setString(2, p.getImage());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, p.getPrix());
			ps.setString(5, p.getCateg());
			//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
			return ps.executeUpdate();//return nbr ligne de produit
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
   }
	    public static int delete ( Produit p) {
	 	   //1.cnx
	 	   Connection cnx;
	 		cnx = SingletonCon.getCon() ;
	 		//2.rq n3aby les point d'interrogation
	 	   String rq = ("DELETE FROM produit WHERE id=? ;");
	 	    try {
	 	    	//2.1 preparer req
	 			PreparedStatement ps= cnx.prepareStatement(rq);
	 			ps.setInt(1, p.getId());
	 			//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
	 			return ps.executeUpdate();//return nbr ligne de produit
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 			return 0;
	 		}
	    }
	 	   public static int update ( Produit p) {
	 		   //1.cnx
	 		   Connection cnx;
	 			cnx = SingletonCon.getCon() ;
	 			//2.rq n3aby les point d'interrogation
	 		   String rq =" UPDATE produit SET lib=?,prix=?,categ=? WHERE id=?;";
	 		    try {
	 		    	//2.1 preparer req
	 				PreparedStatement ps= cnx.prepareStatement(rq);
	 				ps.setString(1,  p.getLib());
	 				ps.setInt(2,p.getPrix());
	 				ps.setString(3,  p.getCateg());
	 				ps.setInt(4,p.getId());
	 				
	 				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
	 				return ps.executeUpdate();//return nbr ligne de produit
	 			} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 				return 0;
	 			}
	 	   }
	 		   public static int find ( Produit p) {
		 		   //1.cnx
		 		   Connection cnx;
		 			cnx = SingletonCon.getCon() ;
		 			//2.rq n3aby les point d'interrogation
		 		   String rq =" select * from produit WHERE id=?;";
		 		    try {
		 		    	//2.1 preparer req
		 				PreparedStatement ps= cnx.prepareStatement(rq);
		 				ps.setInt(1,  p.getId());
		 				//représente le résultat d'une requête de base de données. Le texte sur les requêtes montre comment le résultat d'une requête est renvoyé sous forme de java
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

