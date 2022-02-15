import javax.sql.XAConnection;
import java.util.ArrayList;
import java.util.zip.ZipEntry;

public class M {

    ArrayList <Integer> xi ;
    ArrayList <Integer> vi ;

    public M(ArrayList<Integer> xi, ArrayList<Integer> vi) {
        this.xi = xi;
        this.vi = vi;
        this.onShowSum();
    }

    public M() {
        xi =  new ArrayList<>();
        vi =  new ArrayList<>();
    }

    public String  onShowSum(){
        int sum = 0;
        for (int i = 0 ; i<xi.size();i++){
            sum =sum + xi.get(i)*vi.get(i);
        }
        return  "M = " +sum ;
    }
    ArrayList <Xs> xss =new  ArrayList<>();

    public String onShowM1M2(){
        String st="";
        int i =1;
        for (Xs xs : xss){
            String s1 = "";
            String s2 = "";
            String s3 = "";
            for (X x : xs.getXs()){
                    s1 = s1 +x.getA()+" ";
                    s2 = s2 +x.getB()+" ";
                    s3 = s3 +x.getA_b()+" ";
            }
            st = st + "-----------------"+"\n"+"X "+i+"1 |   "+s1+"\n"+"X "+i+"2 |   "+s2+"\n"+ "_____________________"+"\n"+"DFR |   "+ s3+"\n";
            i++;
        }

        int sum_1=0;
        int sum_2=0;
        String sm_1 = "M1 = ";
        String sm_2 = "M2 = ";

        for (int j = 0 ;j< xss.size();j++){
            Xs xs = xss.get(j);
            X min =xs.getMin();
            if (j==xss.size()-1){
                sm_1 =sm_1 + min.a + " * "+ vi.get(j);
                sm_2 =sm_2 + min.b + " * "+ vi.get(j);
            }else {
                sm_1 =sm_1 + min.a + " * "+ vi.get(j)+ " + ";
                sm_2 =sm_2 + min.b + " * "+ vi.get(j)+" + ";
            }

            sum_1 =sum_1 + (min.a *vi.get(j));
            sum_2 =sum_2 + (min.b *vi.get(j));


        }
        st = st +"\n"+sm_1;
        st = st +"\n"+sm_2;
        st = st +"\nM1 = "+sum_1;
        st = st +"\nM2 = "+sum_2;

        return st;
    }

    public void onFindM1M2(){

        for (int i = 0;i<xi.size();i++){
            System.out.println("--------------------------------------");
            Xs xs = new Xs();
            for (int j = 0;j<=xi.get(i);j++){
                X x = new X(j ,xi.get(i)-j,Math.abs(j - (xi.get(i)-j)));
                System.out.println(j);
                System.out.println(xi.get(i)-j);
                System.out.println(Math.abs(j - (xi.get(i)-j)));
                xs.addXs(x);
            }
            X min =xs.getMin();
            System .out.println("Min : a : "+min.a  +" b : "+min.b+" a-b : " +min.a_b);
            System.out.println("--------------------------------------");
            xss.add(xs);
        }
           int sum_1=0;
           int sum_2=0;

        for (int i = 0 ;i< xss.size();i++){
            Xs xs = xss.get(i);
            X min =xs.getMin();

            sum_1 =sum_1 + (min.a *vi.get(i));
            sum_2 =sum_2 + (min.b *vi.get(i));


        }

        System.out.println("M1 = "+sum_1);
        System.out.println("M2 = "+sum_2);
    }

    public ArrayList<Integer> getXi() {
        return xi;
    }

    public void setXi(ArrayList<Integer> xi) {
        this.xi = xi;
    }

    public ArrayList<Integer> getVi() {
        return vi;
    }

    public void setVi(ArrayList<Integer> vi) {
        this.vi = vi;
    }
}
