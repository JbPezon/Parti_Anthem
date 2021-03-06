import java.util.ArrayList;

public class neurone {
    private float bias;
    private float data;

    private ArrayList<connection> connectionEntre;
    private ArrayList<connection> connectionSortie;


    public neurone(float bias) {
        this.bias = bias;
        this.data = 0;
        this.connectionEntre = new ArrayList<connection>();
        this.connectionSortie = new ArrayList<connection>();
    }

    public static double sigmoid(float x) {
        return (1 / (1 + Math.pow(Math.E, (-1 * x))));
    }

    public void backPropagation(boolean bonNeurone, float fOut) {
        float nouveauPoid = 0;
        float n = 0.08f;
        /*
        float error = 0;

        if (bonNeurone)
            error = 1 - this.getData();
        else
            error = this.getData();

        for (connection c: connectionEntre) {
            c.setPoid(c.getPoid()+n*c.getNeuroneGauche().getData()*error);
        }
        this.setBias();
        */



        float dv = 0;
        float dwi = 0;
        float dbi = 0;
        float db = 0;

        if (bonNeurone) {
            dv = fOut * (1 - fOut) * (fOut - 1);
        } else {
            dv = fOut * (1 - fOut) * fOut;
        }

        for (connection c : this.connectionEntre) {
            dwi = this.getData() * (1 - this.getData()) * c.getPoid() * dv;
            nouveauPoid = c.getPoid() + n * dwi * c.getNeuroneGauche().getData();


            dbi = this.getData() * (1 - this.getData()) * c.getPoid() * dv;
            db = n * dbi * 1;

            this.setBias(this.getBias() + db);

            c.setPoid(nouveauPoid);
        }



        /*
        float n = 0.05f;
        dwi[i] = f[i] * (1 - f[i]) * vWeights[i] * dv;
        f = liste des data en sortie
        dv = fOut * (1-fOut) * error;
        x = liste des entrees
        error : t - fout

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

    public void addConnectionEntre(connection co) {
        this.connectionEntre.add(co);
    }

    public void addConnectionSortie(connection co) {
        this.connectionSortie.add(co);
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

    public void setData(float data) {
        this.data = data;
    }

    public ArrayList<connection> getConnectionEntre() {
        return connectionEntre;
    }

    public void setConnectionEntre(ArrayList<connection> connectionEntre) {
        this.connectionEntre = connectionEntre;
    }

    public ArrayList<connection> getConnectionSortie() {
        return connectionSortie;
    }

    public void setConnectionSortie(ArrayList<connection> connectionSortie) {
        this.connectionSortie = connectionSortie;
    }

    @Override
    public String toString() {
        String result = " neurone :\n";
        result += "data : " + this.getData() + " bias : " + this.getBias() + "\n";
        return result;
    }
}
