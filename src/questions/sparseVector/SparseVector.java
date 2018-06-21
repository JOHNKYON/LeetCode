package questions.sparseVector;

import java.util.HashMap;
import java.util.List;

public class SparseVector {
    HashMap<Integer, Double> map;

    public SparseVector() {
        this.map = new HashMap<>();
    }

    public double get(int index) {
        return this.get(index);
    }

    public void set(int index, double value) {
        this.map.put(index, value);
    }


    public double dot(SparseVector another) {
        double sum = 0;

        for (int index: this.map.keySet()){
            Double multip = another.map.get(index);
            if (multip != null){
                sum += this.map.get(index) * multip;
            }
//            if (another.map.containsKey(index)){
//                sum += this.map.get(index) * another.map.get(index);
//            }
        }

        return sum;
    }

    public double norm() {
        double res=0;

        for (double value : this.map.values()){
            res += value*value;
        }

        return Math.sqrt(res);
    }

    public double L1Norm(){
        double res = 0;
        return res;
    }

}
