package BDD;
import java.sql.*;

public class Connexion {
	
	static Connection conn;
	static Statement stmt;
	static ResultSet result;
	static ResultSetMetaData resultMeta;

	private static String url ="jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/bdd_base?serverTimezone=Europe/Paris";
	private static String user = "";
	private static String passwd = "";
	
	public static  void Connect() throws ClassNotFoundException
	{
		try 
		{   
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver OK");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion établie ...");
		} 
		catch (SQLException sqle) 
		{
			System.out.println("Pb select " + sqle.getMessage());
		}
	}

//---------------------------------------------------------------------------------------------------------------------------------------------------

public static void ajoutTableClient(int idClient, String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays) throws ClassNotFoundException {
	
	String requete = "INSERT INTO Client VALUES ("+idClient+",'"+nom+"','"+prenom+"','"+noRue+"','"+voie+"','"+codePostal+"','"+ville+"','"+pays+"')";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(requete);
		System.out.println("Ajout réussi !");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

public static void ajoutTablePeriodicite(int idPeriodicite, String libelle) throws ClassNotFoundException {
	
	String requete = "INSERT INTO Periodicite VALUES ("+idPeriodicite+",'"+libelle+"')";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(requete);
		System.out.println("Ajout réussi !");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

public static void ajoutTableRevue(int idRevue, String titre, String description, float tarifNumero, String visuel, int idPeriodicite) throws ClassNotFoundException {
	
	String requete = "INSERT INTO Revue VALUES ("+idRevue+",'"+titre+"','"+description+"',"+tarifNumero+",'"+visuel+"',"+idPeriodicite+")";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(requete);
		System.out.println("Ajout réussi !");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

public static void ajoutTableAbo(int idAbonnement, int dateDebYear, int dateDebMonth, int dateDebDay, int dateFinYear, int dateFinMonth, int dateFinDay, int idClient, int idRevue) throws ClassNotFoundException {
	
	String requete = "INSERT INTO Abonnement VALUES ("+idAbonnement+",'"+dateDebYear+"-"+dateDebMonth+"-"+dateDebDay+"','"+dateFinYear+"-"+dateFinMonth+"-"+dateFinDay+"',"+idClient+","+idRevue+")";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(requete);
		System.out.println("Ajout réussi !");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

//---------------------------------------------------------------------------------------------------------------------------------------------------
public static void supprTable(String nomTable, int id) throws ClassNotFoundException
{
	String query = "DELETE FROM "+nomTable+" WHERE id_"+nomTable.toLowerCase()+"="+id;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(query);
		System.out.println("Suppression réussi");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}


//---------------------------------------------------------------------------------------------------------------------------------------------------

public static void modifTableAbonnement(int idAbonnement, int dateDebYear, int dateDebMonth, int dateDebDay, int dateFinYear, int dateFinMonth, int dateFinDay, int idClient, int idRevue) throws ClassNotFoundException
{
	try {
		String query2 = "UPDATE Abonnement SET date_debut='"
				+dateDebYear+"-"+dateDebMonth+"-"+dateDebDay+"', date_fin='"
				+dateFinYear+"-"+dateFinMonth+"-"+dateFinDay+"', id_client="
				+idClient+", id_revue="
				+idRevue+" WHERE id_abonnement="+idAbonnement;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(query2);
		System.out.println("Abonnement "+idAbonnement+" bien modifié ! ");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

public static void modifTableClient(int idClient, String nom, String prenom, String noRue, String voie, String codePostal, String ville, String pays) throws ClassNotFoundException
{
	try {
		String query2 = "UPDATE Client SET nom='"
				+nom+"', prenom='"
				+prenom+"', no_rue='"
				+noRue+"', voie='"
				+voie+"', code_postal='"
				+codePostal+"', ville='"
				+ville+"', pays='"+pays+"' WHERE id_client="+idClient;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(query2);
		System.out.println("Client "+idClient+" bien modifié ");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

public static void modifTablePeriodicite(int idPeriodicite, String libelle) throws ClassNotFoundException
{
	try {
		String query2 = "UPDATE Periodicite SET libelle='"
				+libelle+"' WHERE id_periodicite="+idPeriodicite;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(query2);
		System.out.println("Périodicité "+idPeriodicite+" bien modifié ! ");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

public static void modifTableRevue(int idRevue, String titre, String description, float tarifNumero, String visuel, int idPeriodicite) throws ClassNotFoundException
{
	try {
		String query2 = "UPDATE Revue SET titre='"
				+titre+"', description='"
				+description+"', tarif_numero='"
				+tarifNumero+"', visuel='"
				+visuel+"', id_periodicite="
				+idPeriodicite+" WHERE id_revue="+idRevue;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		stmt.executeUpdate(query2);
		System.out.println("Revue "+idRevue+" bien modifié ! ");
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}

//----------------------------------------------------------------------------------------------------------------------------------------------------

public static void affiche(String nomTable) throws ClassNotFoundException 
{
	String query1 = "SELECT * FROM "+nomTable;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver OK");
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion établie ...");
		stmt = conn.createStatement();
		result = stmt.executeQuery(query1);
		resultMeta = result.getMetaData();
		System.out.println("*************************************************************************************************************************");
		for(int i = 1;i<=resultMeta.getColumnCount();i++)
		{
			System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			
		}
		System.out.println("\n*************************************************************************************************************************");
		while(result.next()) {
			for(int i = 1;i<=resultMeta.getColumnCount();i++)
			{
				System.out.print("\t" + result.getObject(i).toString() + "\t   |");
			}
			System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
		}
		result.close();
		stmt.close();
	} catch (SQLException e) {
		System.out.println("\n************************************************\n"
				+"Erreur: " + e.getMessage()
				+"\n************************************************\n");
	}
}		


} // END CLASS
