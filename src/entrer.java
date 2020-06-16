import java.util.ArrayList;

public class entrer {
    private int note;
    private int nbnotes ;
    private ArrayList<Float> notes;

    public entrer(int note,int nbnotes){
        this.note =note;
        this.nbnotes=nbnotes;
        this.notes=new ArrayList<Float>();

    }
    public void remplieentrer(float value){
        if (notes.size()<nbnotes)
            this.notes.add(value);
    }

    public float getNote() {
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
