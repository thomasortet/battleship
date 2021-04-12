package formation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GestionNavire {

	List<Navire> nv = new ArrayList<Navire> ();
    Random rnd = new Random ();
    int maxl, maxc, nbnv;
   
    public GestionNavire (int maxl, int maxc, int nbnv)
    {
        this.maxl=maxl;
        this.maxc=maxc;
        this.nbnv=nbnv;
        reset(nbnv);
    }
   
    public String evaluer (String tir)
    {
        String m = "Raté !";
        // conversion de (3,4) => [(3] [4)] en 3 et 4 integer
        //----------------------------------------------------
        String [] morceaux = tir.split(",");
        // morceaux[0] == "(3"
        // morceaux[1] == "12)"
        int l = Integer.parseInt(morceaux[0].substring(1));    
        int c = Integer.parseInt(morceaux[1].substring(0,morceaux[1].length()-1));
        // chaque navire doit revoir son etat
        //----------------------------------------------------
        List<String> cumulEtat = new ArrayList<String>();
        for (Navire n : nv)
        {
            cumulEtat.add(n.impact (l,c));
        }
        // Logique d'impact
        if (cumulEtat.contains("Touché !")) m = "Touché !";
        if (cumulEtat.contains("Coulé !")) m = "Coulé !";
        return m;
    }
   
    public void reset (int nbnv)
    {
    	nv.clear();
        for(int i=0; i<nbnv; i++)
        {
            int lg = 2 + rnd.nextInt (5);
            int l = rnd.nextInt (maxl);
            int c = rnd.nextInt (maxc-lg);
            nv.add(new Navire (l,c,lg, 'H'));
            System.out.println(nv);
        }
    }
}