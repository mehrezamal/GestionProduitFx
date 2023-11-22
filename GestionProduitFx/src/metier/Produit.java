package metier;

public class Produit {
	private int id;
	private String lib;
	private String image;
	private int quantite;
	private int prix;
	private String categ;
	public Produit(int id) {
		super();
		this.id = id;
	}

	public Produit(int id, String lib, String image, int quantite, int prix, String categ) {
		super();
		this.id = id;
		this.lib = lib;
		this.image = image;
		this.quantite = quantite;
		this.prix = prix;
		this.categ = categ;
		
	}

	public Produit(String lib, String image, int quantite, int prix, String categ) {
		super();
		this.lib = lib;
		this.image = image;
		this.quantite = quantite;
		this.prix = prix;
		this.categ = categ;
	}
	public Produit(int id2, String lib2, String string, String string2, int prix2, String categ2) {
		super();
		this.id = id2;
		this.lib = lib2;
		this.image = "image";
		this.quantite = 0;
		this.prix = prix2;
		this.categ = categ2;
		// TODO Auto-generated constructor stub
	}

	

	public Produit(String lib2, String image, String string2, int prix2, String categ2) {
		// TODO Auto-generated constructor stub
		super();
		this.lib = lib2;
		this.image = image;
		this.quantite = 0;
		this.prix = prix2;
		this.categ = categ2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getCateg() {
		return categ;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", lib=" + lib + ", image=" + image + ", quantite=" + quantite + ", prix=" + prix
				+  ", categ=" + categ +"]";
	}
	
	

}
