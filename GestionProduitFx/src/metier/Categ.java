package metier;

public class Categ {
		private int code;
		private String nomcateg;
		
		
		public Categ(String nomcateg) {
			super();
			this.nomcateg = nomcateg;
		}
		public Categ(int code) {
			super();
			this.code = code;
		}
		public Categ(int code, String nomcateg) {
			super();
			this.code = code;
			this.nomcateg = nomcateg;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getNomcateg() {
			return nomcateg;
		}
		public void setNomcateg(String nomcateg) {
			this.nomcateg = nomcateg;
		}
		@Override
		public String toString() {
			return "Test3 [code=" + code + ", nomcateg=" + nomcateg + "]";
		}
		
}
