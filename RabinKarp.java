
class RabinKarp {

    // T is the full string
    // P is the partial string that we need to search
    // d is the number of characters in the input alphabet
    // q is a prime number

    public static void rabinkarpmatcher(String T, String P, int d, int q) {

        int n = T.length();
        int m = P.length();
        double h = 1;
        int p = 0; // we will store hash value for pattern here
        int t = 0; // we will store hash value for string text here
        // int[] dp = new int[P.length()];
        // int[] dt = new int[T.length()];

        for (int i = 0; i < m-1; i++) {
            // h = h + Math.pow( d, m-1) % q;
            h = (h*d) % q;
        }

        //Calculate the hash valueof pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d*p + P.charAt(i))%q;
            t = (d*t + T.charAt(i))%q;
        }
        
        // Slide the pattern over text one by one
        for (int i = 0; i <= n-m; i++) {

            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                        if (T.charAt(i+j) != P.charAt(j)) {
                            break;
                        }
                    }
                    

                    if (j == m) {
                        System.out.println("Pattern found at index " + i);
                    }

            }

            if (i < n-m) {
                t = (int) (d*(t-T.charAt(i)*h) + T.charAt(i+m)) %q;

                if (t < 0) {
                    t =(t+ q);
                }
            }
        }
        // return 0;
    }

    public static void main(String[] args) {
        rabinkarpmatcher(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
    }
}