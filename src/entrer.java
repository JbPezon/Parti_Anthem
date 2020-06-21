import java.util.ArrayList;
import java.util.Collections;

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
            ComplexeCartesien[] signalTest = new ComplexeCartesien[16384];
            ArrayList<Float> list = new ArrayList<Float>();
            for (int i = 0; i < 16384; ++i)
                signalTest[i] = new ComplexeCartesien(monSon.getDonnees().get(i), 0);
            Complexe[] resultat = FFT.appliqueSur(signalTest);
            for (int i = 0; i < 1000; i++) {
                list.add( Math.abs((float) resultat[i].reel()));
            }
            float max = Collections.max(list);
            for (int i = 0; i < 1000; i++) {
                notes.add(list.get(i)/max);
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
