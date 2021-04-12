package formation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bn", eager = true)
@SessionScoped
public class BatailleNavale {

	List<List<String>> lignes = new ArrayList<List<String>>();
	HashMap<String,String> selectionnees = new HashMap<String, String>();
	GestionNavire gn = new GestionNavire(10,10, 2);
	String message = "Bienvenue";

	public BatailleNavale() {
		// remplir la grille
		for (int l = 0; l < 10; l++) {
			List<String> ligne = new ArrayList<String>();
			for (int unecase = 0; unecase < 10; unecase++) {
				ligne.add(String.format("(%d,%d)", l, unecase));
			}
			lignes.add(ligne);
		}
	}
	public List<List<String>> getLignes() {
		return lignes;
	}

	public String getMessage() {
		return message;
	}

	

	public String couleur (String unecase) {
		String rep = "lightgray";
		if(selectionnees.containsKey(unecase)) {
			String etat = selectionnees.get(unecase);
			if(etat.equals("Raté !")) rep = "black";
			if(etat.equals("Touché !")) rep = "orange";
			if(etat.equals("Coulé !")) rep = "red";
		}
		return rep;
}

	public void selection(String tir) {
		System.out.println(tir);
		message = gn.evaluer(tir);
		if (message.equals("Coulé !")) {
			for(String cle : selectionnees.keySet())
			{
				if(selectionnees.get(cle).equals("Touché !")) {
					selectionnees.put(cle, "Coulé !");
				}
			}
		}
		selectionnees.put(tir, message);
	}
	
	public void monreset() {
		selectionnees.clear();
		gn.reset(2);
	}
}
