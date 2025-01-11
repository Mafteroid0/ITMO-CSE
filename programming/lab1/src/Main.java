
public class Main {
    public static void main(String[] args) {


        long[] w = new long[20];
        long ch = 20;
        for (int i = 0; i < 20; i++){
            w[i] = ch;
            ch--;
        }

        double[] x = new double[20];
        for (int i = 0; i < 20; i++){
            x[i] = (Math.random()*(10+13))-13;
        }

        double[][] r = new double[20][20];

        for (int i=0; i<20; i++){
            for (int j = 0; j<20; j++){
                if (w[i] == 10){
                    r[i][j] = Math.cbrt(Math.cbrt(Math.asin((x[j]-1.5)/23)));
                }
                else {
                    if(findCont(w[i])){
                        r[i][j] = 3/(x[j]*2);
                    }
                    else {
                        r[i][j] = Math.log(Math.abs(Math.cbrt((1-Math.log(Math.abs(x[j])))/6) + 4));
                    }
                }


            }
        }

        for (int i=0; i<20; i++){
            for (int j = 0; j<20; j++){
                System.out.format("%8.3f", r[i][j]);
            }
            System.out.println();
        }


    }
    private static boolean findCont(double x){
        long[] dia = {2, 3, 4, 5, 6, 7, 11, 12, 15, 16};
        for (double el: dia){
            if (x == el){
                return true;
            }
        }
        return false;
    }
}
