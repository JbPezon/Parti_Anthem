import java.util.ArrayList;

public class entrer {
    private int note;
    private int nbnotes ;
    private ArrayList<Float> notes;

    public entrer(int note, son monSon){
        this.notes=new ArrayList<Float>();
        this.note = note;
        int tailleEchantillion = 0;
        float moyenne = 0;
        if (monSon.donnees().size() >= 1000) {
            tailleEchantillion = monSon.getDonnees().size()/1000;
            //System.out.println("Mes moyenne : \n");
            for (int i = 0; i < 1000; i++) {
                for (int j = i*tailleEchantillion; j < i*tailleEchantillion+tailleEchantillion; j++)
                    moyenne += monSon.getDonnees().get(j);
                moyenne = moyenne/tailleEchantillion;
                this.notes.add((moyenne+1000)/2000);
                System.out.println(moyenne);
                moyenne = 0;
            }

        }
        else{
            System.out.println("Erreur taille fichier wav");
        }

    }
    public void remplieentrer(float value){
        this.notes.add(value);
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getNbnotes() {
        return nbnotes;
    }

    public void setNbnotes(int nbnotes) {
        this.nbnotes = nbnotes;
    }

    public ArrayList<Float> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Float> notes) {
        this.notes = notes;
    }
}
