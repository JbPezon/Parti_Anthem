import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class FFT {
    public final static int TailleFFTtest = 32768;

    public final static double Periode = 1;

 	private int taille;

	// Indiquer la taille dans le constructeur permettra des optimisations par la suite :
	// on pourra facilement transformer les méthodes statiques en méthodes
	// d'instance, et optimiser l'objet en fonction de la taille indiquée dans
	// le constructeur
 	public FFT(int taille)
 	{
 		this.taille = taille;
 	}


    // Sous-signal obligatoirement découpé par pas de deux
    // La méthode est statique car c'est plutôt une fonction dans notre cas,
    // et privée car elle n'a de réel intérêt qu'à l'intérieur de la classe
    private static Complexe[] demiSignal(Complexe[] signal, int depart)
    {
        Complexe[] sousSignal = new Complexe[signal.length/2];
        for (int i = 0; i < sousSignal.length; ++i)
            sousSignal[i] = signal[depart+2*i];
        return sousSignal;
    }

    // La méthode est statique car c'est plutôt une fonction dans notre cas ;
    // on pourra la rendre méthode d'instance dès qu'on voudra optimiser le code
    // et tenir compte de la taille, ce qui permettra d'éviter de refaire
    // certains calculs à chaque nouvel appel de appliqueSur()
    public static Complexe[] appliqueSur(Complexe[] signal)
    {
        // On crée la donnée renvoyée en retour
        Complexe[] trSignal = new Complexe[signal.length];
        if (signal.length == 1)	// Cas trivial de la FFT d'une valeur unique
            trSignal[0] = new ComplexeCartesien(signal[0].reel(), signal[0].imag());
        else	// Si le cas n'est pas trivial
        {
            // Découpage des deux sous-groupes de données sur lesquels on applique la FFT
            // (voir définition de cours)
            final Complexe[] P0 = appliqueSur(demiSignal(signal, 0));
            final Complexe[] P1 = appliqueSur(demiSignal(signal, 1));
            // On applique le regroupement "papillon" pour créer le résultat final
            for (int k = 0; k < signal.length/2; ++k)
            {
                final ComplexePolaire expo = new ComplexePolaire(1., -2.*Math.PI*k/signal.length);
                final Complexe temp = P0[k];
                trSignal[k] = temp.plus(expo.fois(P1[k]));
                trSignal[k+signal.length/2] = temp.moins(expo.fois(P1[k]));
            }
        }
        return trSignal;
    }

    public static ComplexeCartesien[] fft(ComplexeCartesien[] x) {
        int n = x.length;

        // base case
        if (n == 1) return new ComplexeCartesien[] { x[0] };

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n is not a power of 2");
        }

        // compute FFT of even terms
        ComplexeCartesien[] even = new ComplexeCartesien[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }
        ComplexeCartesien[] evenFFT = fft(even);

        // compute FFT of odd terms
        ComplexeCartesien[] odd  = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[2*k + 1];
        }
        ComplexeCartesien[] oddFFT = fft(odd);

        // combine
        ComplexeCartesien[] y = new ComplexeCartesien[n];
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            ComplexeCartesien wk = new ComplexeCartesien(Math.cos(kth), Math.sin(kth));
            y[k]       = (ComplexeCartesien) evenFFT[k].plus (wk.fois(oddFFT[k]));
            y[k + n/2] = (ComplexeCartesien) evenFFT[k].moins(wk.fois(oddFFT[k]));
        }
        return y;
    }


    public static void main(String[] args)
    {

        // Création d'un signal test simple
        ComplexeCartesien[] signalTest = new ComplexeCartesien[16384];
        son monDo = new son("sample/fa2 16 bits.wav");
        entrer test = new entrer(0,monDo);
        //16384

        System.out.println(test.getNotes().size());
        for (int i = 0; i < 16384; ++i)
            signalTest[i] = new ComplexeCartesien(test.getNotes().get(i), 0);
        // On applique la FFT sur ce signal
        Complexe[] resultat = appliqueSur(signalTest);
        ArrayList<Float> list = new ArrayList<Float>();
        for (Complexe c: resultat) {
            list.add(Math.abs((float)c.reel()));
        }
        // On affiche les valeurs du résultat
        float max = Collections.max(list);
        for (int i = 0; i < 1000; ++i) {

            if((float)Math.abs(resultat[i].reel()) > 1000000) {
                System.out.print(i + " : (" + (float) Math.abs(resultat[i].reel())/max + " ; " + (float) resultat[i].imag() + "i)");
                System.out.println(", (" + (float) Math.abs(resultat[i].mod()) + " ; " + (float) resultat[i].arg() + " rad)");
            }
        }

        /*
        signalTest = fft(signalTest);
        for (ComplexeCartesien c: signalTest) {
            System.out.println(c.reel() + " " + c.imag());
        }

         */

    }

}
