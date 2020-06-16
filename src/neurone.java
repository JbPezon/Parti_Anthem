import java.util.ArrayList;

public class neurone {
    private float bias;
    private float data;
    private ArrayList<connection> conectionEntre;
    private ArrayList<connection> conectionSortie;

    public neurone(float bias){
        this.bias=bias;
        this.data=0;
        this.conectionEntre= new ArrayList<connection>();
        this.conectionSortie= new ArrayList<connection>();
    }

    public void backPropagation(boolean bonneNeurone){
        float nouveauPoid = 0;
        if (bonneNeurone){
            this.setBias(this.getBias() - (this.getData()*(this.getData()-1)));
            for (connection c: this.conectionEntre) {
                nouveauPoid = c.getPoid() - ((this.getData()*(this.getData() - 1))*(float)0.01);
                c.setPoid(nouveauPoid);
            }
        }else{
            this.setBias(this.getBias() - (this.getData()*this.getData()));
            for (connection c: this.conectionEntre) {
                nouveauPoid = c.getPoid() - ((this.getData() * this.getData()) * (float)0.01);
                c.setPoid(nouveauPoid);
            }
        }



        /*
        float n = 0.05f;
        dwi[i] = f[i] * (1 - f[i]) * vWeights[i] * dv;
        f = liste des data en sortie

        for (int i = 0;i<neurons;i++){
            dwi[i] = f[i] * (1 - f[i]) * vWeights[i] * dv;
            for (int j = 0;j<dimension;j++){
                dw[j][i] = n * dwi[i] * x[j];
                this.wWeights[j][i] = wWeights[j][i] + dw[j][i];
            }
        }

        // Modify bias
        for (int i = 0;i<neurons;i++){
            dbi[i] = f[i] * (1 - f[i]) * vWeights[i] * dv;
            db[i] = n * dbi[i] * 1;
            this.bias[i] = bias[i] + db[i];
        }
        */

    }

    public void addConnectionEntre(connection co){
        this.conectionEntre.add(co);
    }

    public void addConnectionSortie(connection co){
        this.conectionSortie.add(co);
    }

    public float getBias() {
        return bias;
    }

    public void setBias(float bias) {
        this.bias = bias;
    }

    public float getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ArrayList<connection> getConectionEntre() {
        return conectionEntre;
    }

    public void setConectionEntre(ArrayList<connection> conectionEntre) {
        this.conectionEntre = conectionEntre;
    }

    public ArrayList<connection> getConectionSortie() {
        return conectionSortie;
    }

    public void setConectionSortie(ArrayList<connection> conectionSortie) {
        this.conectionSortie = conectionSortie;
    }
}
