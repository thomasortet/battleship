package formation;

import java.util.ArrayList;
import java.util.List;

public class Navire {
	
	public int l, c, lg;
	char or;
	List<Boolean> etat = new ArrayList<Boolean>();
	
	public Navire(int l, int c, int lg, char or) {
		this.l = l;
		this.c = c;
		this.lg = lg;
		this.or = or;
		
		for (int i = 0; i<lg; i++) {
			etat.add(true);
		}
		
	}
	
	String impact (int l, int c) {
		String rep = "Raté !";
		if(l == this.l) {
			if (c >= this.c && c<this.c+this.lg) {
				rep = "Touché !";
				etat.set(c-this.c, false);
				if ( ! etat.contains(true)) {
					rep = "Coulé !";
				}
			}
		}
		return rep;
	}

	@Override
	public String toString() {
		return "Navire [l=" + l + ", c=" + c + ", lg=" + lg + ", or=" + or + ", etat=" + etat + "]";
	}
	
	
}
