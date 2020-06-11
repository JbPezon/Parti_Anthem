public class connection {

    private float poid;
    private neurone neuroneGauche;
    private neurone neuroneDroite;

    public connection(float poid){
        this.poid = poid;
        this.neuroneDroite = new neurone(1);
        this.neuroneGauche = new neurone(1);
    }

    public float getPoid() {
        return poid;
    }

    public void setPoid(float poid) {
        this.poid = poid;
    }

    public neurone getNeuroneGauche() {
        return neuroneGauche;
    }

    public void setNeuroneGauche(neurone neuroneGauche) {
        this.neuroneGauche = neuroneGauche;
    }

    public neurone getNeuroneDroite() {
        return neuroneDroite;
    }

    public void setNeuroneDroite(neurone neuroneDroite) {
        this.neuroneDroite = neuroneDroite;
    }
}
