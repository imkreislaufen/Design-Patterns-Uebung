public class Spiel {
	protected int spielTag;
	protected String heim;
	protected String gast;
	protected int toreHeim;
	protected int toreGast;
	
	public Spiel(int spielTag,
			String heim,
			String gast,
			int toreHeim,
			int toreGast) {
		
		this.spielTag = spielTag;
		this.heim = heim;
		this.gast = gast;
		this.toreHeim = toreHeim;
		this.toreGast = toreGast;
	}
}
