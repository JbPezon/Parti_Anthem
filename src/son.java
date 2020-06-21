import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.nio.ByteOrder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import java.util.ArrayList;

public class son {

    private int frequence;
    private ArrayList<Float> donnees;

    public int frequence() {return frequence;}
    public ArrayList<Float> donnees() {return donnees;}

    // Constructeur d'un objet permettant de lire un fichier son mono-canal
    // 16 bits PCM little endian, en utilisant les API Java
    public son(final String nomFichier)
    {
        try
        {
            // Ouvrir le fichier comme une source audio
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(nomFichier));
            // Obtenir des informations sur cette source
            AudioFormat af = ais.getFormat();

            if (af.getChannels() == 1 &&	// Si le signal est monophonique
                    af.getEncoding() == AudioFormat.Encoding.PCM_SIGNED &&	// et qu'il est en Pulse Code Modulation signé
                    af.getSampleSizeInBits() == 16)	// et que les échantillons sont sur 16 bits
            {
                final int NombreDonnees = ais.available();	// Combien d'octets constituent les données
                final byte[] bufferOctets = new byte[NombreDonnees];	// Préparer un buffer pour lire tout le flux du fichier
                ais.read(bufferOctets);	// Lire le fichier dans le buffer d'octets
                ais.close();	// On peut fermer le flux du fichier
                ByteBuffer bb = ByteBuffer.wrap(bufferOctets);	// Prépare le travail sur le buffer
                bb.order(ByteOrder.LITTLE_ENDIAN);	// Indique le format des données lues dans le WAV
                ShortBuffer donneesAudio = bb.asShortBuffer();	// Préparer un buffer pour interpréter les données en tableau de short
                donnees = new ArrayList<Float>();
                for (int i = 0; i < donneesAudio.capacity(); ++i)
                    donnees.add((float)donneesAudio.get(i));
                // Récupérer la fréquence du fichier audio
                frequence = (int)af.getSampleRate();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void afficheDonne(){
        System.out.println("nbDonne" + this.donnees.size());
        for (float f : this.donnees) {
            System.out.println(f);
        }
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public ArrayList<Float> getDonnees() {
        return donnees;
    }

    public void setDonnees(ArrayList<Float> donnees) {
        this.donnees = donnees;
    }
}
