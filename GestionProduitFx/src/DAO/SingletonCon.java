package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
//un patron de conception (design pattern)
//s'assure de l'existence d'un seul objet de son genre et fournit un unique point d'accès vers cet objet
public class SingletonCon {

	//tester si cnx null on faire appel a  une cnx prete(setCon) 
private static Connection cnx= null;
public static Connection getCon() {
	if (cnx==null)
		SingletonCon.setCon();
	return cnx ;
	}

 private static void setCon () {
	 try {
		 //Class.forName(driver); // driver contient une chaine de caractères lié à la base de données
		 //charger dynamiquement une classe dont le nom pleinement qualifié est fourni en paramètre
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 //jdbc : connecter et exécuter des requêtes sur une base de données
		 //Driver : établit une connexion avec une base de données 
		 SingletonCon.cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","");
     System.out.println("succes!");
	 } catch (Exception e) {
		 e.printStackTrace();
		 
	 }
 }



		
	}


