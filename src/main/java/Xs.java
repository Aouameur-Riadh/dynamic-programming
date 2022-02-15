import java.util.ArrayList;

public class Xs {
    ArrayList <X> xs ;

    public Xs() {
        this.xs = new ArrayList<>();
    }

    public void addXs(X x){
        this.xs.add(x);
    }
    public ArrayList<X> getXs() {
        return xs;
    }

    public void setXs(ArrayList<X> xs) {
        this.xs = xs;
    }

    public X getMin(){
        X min = this.xs.get(0);
        for (int i =1 ; i<this.xs.size();i++){
            if(min.a_b>this.xs.get(i).a_b){
                min = this.xs.get(i);
            }

        }

        return min;

    }

}
