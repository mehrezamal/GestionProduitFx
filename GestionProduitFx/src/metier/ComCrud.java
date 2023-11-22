package metier;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import DAO.SingletonCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
	public class ComCrud {
			public static ObservableList <Commande> getALL() {
			//List<Commande> commandes = new ArrayList <Commande>();
				ObservableList <Commande> commandes =FXCollections.observableArrayList();
			Connection cnx;
			cnx = SingletonCon.getCon() ;
			String rq = "SELECT * FROM `Commande` ";
			//représente le résultat d'une requête de base de données
			ResultSet rs; Commande c;
			
			try {
				PreparedStatement ps = cnx.prepareStatement(rq);
				rs= ps.executeQuery();
				while(rs.next()) {
					c= new Commande (rs.getInt("id") , rs.getString("nom") , rs.getString("prenom") , rs.getInt("tel") , rs.getString("mail") , rs.getString("adresse"));
					commandes.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commandes;
		}
	   public static int ajouter (Commande c) {
		   //1.cnx
		   Connection cnx;
			cnx = SingletonCon.getCon() ;
			//2.rq n3aby les point d'interrogation
		   String rq = "INSERT INTO commande (nom, prenom, tel, mail,adresse) VALUES (?,?,?,?,?)";
		    try {
		    	//2.1 preparer req
				PreparedStatement ps= cnx.prepareStatement(rq);
				ps.setString(1, c.getNom());
				ps.setString(2, c.getPrenom());
				ps.setInt(3, c.getTel());
				ps.setString(4, c.getMail());
				ps.setString(5, c.getAdresse());
				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
				return ps.executeUpdate();//return nbr ligne de produit
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
	   }
		    public static int delete ( Commande c) {
		 	   //1.cnx
		 	   Connection cnx;
		 		cnx = SingletonCon.getCon() ;
		 		//2.rq n3aby les point d'interrogation
		 	   String rq = ("DELETE FROM commande WHERE id=? ;");
		 	    try {
		 	    	//2.1 preparer req
		 			PreparedStatement ps= cnx.prepareStatement(rq);
		 			ps.setInt(1, c.getId());
		 			//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
		 			return ps.executeUpdate();//return nbr ligne de produit
		 		} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 			return 0;
		 		}
		    }
		 	   public static int update (Commande c) {
		 		   //1.cnx
		 		   Connection cnx;
		 			cnx = SingletonCon.getCon() ;
		 			//2.rq n3aby les point d'interrogation
		 		   String rq =" UPDATE commande SET nom=?,prenom=?,tel=?,mail=?,adresse=? WHERE id=?;";
		 		    try {
		 		    	//2.1 preparer req
		 				PreparedStatement ps= cnx.prepareStatement(rq);
		 				ps.setString(1,  c.getNom());
		 				ps.setString(2,c.getPrenom());
		 				ps.setInt(3,c.getTel());
		 				ps.setString(4,  c.getMail());
		 				ps.setString(5,  c.getAdresse());
		 				ps.setInt(6,c.getId());
		 				
		 				//execute update wa9tely nbedel haja fl base executequery ki tebda select o base m tetmasech
		 				return ps.executeUpdate();//return nbr ligne de produit
		 			} catch (SQLException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 				return 0;
		 			}
		 	   }
		 		   public static int find (Commande c) {
			 		   //1.cnx
			 		   Connection cnx;
			 			cnx = SingletonCon.getCon() ;
			 			//2.rq n3aby les point d'interrogation
			 		   String rq =" select * from commande WHERE id=?;";
			 		    try {
			 		    	//2.1 preparer req
			 				PreparedStatement ps= cnx.prepareStatement(rq);
			 				ps.setInt(1,  c.getId());
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


