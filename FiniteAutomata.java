
// Scans the text T for all the pattern P
// very efficient
// The matching time used - after preprocessing the pattern to build the 
// We start with making a automata for the pattern (not the text)
// Sigma -> All possible patterns
// Number of states -> Number of characters in the pattern + 1
  
public class FiniteAutomata {
    public static void automatapatternsearch(char[] pattern, char[] text, int n) {
        
        int m = pattern.length;
        int[][] automataset = new int[m + 1][n];
        for (int i = 0; i <= m; ++i ) {
            for (int j = 0; j < n; ++j) {
                automataset[i][j] = getNextState(pattern, m, i, j);
                // System.out.println(automataset[i][j]);
                // System.out.println();

            }
        }
    }

    public static int getNextState(char[] pattern, int patlen, int i, int j) {

        if (i < patlen && pattern[i] == j) {
            return i+1;
        }
        int rev, curr;
        for (curr = i; curr > 0; curr--) {

            for (rev = 0; rev < curr; rev++) {
                System.out.println(rev);
                if ((pattern[i-curr+1+rev]) != pattern[rev]) {
                    break;
                }

                // System.out.println(rev);
                System.out.println(pattern[rev]);
                // System.out.println(i-curr+1+rev);
                System.out.println(pattern[i-curr+1+rev]);
                
                System.out.println();
            }
            if (rev == (curr-1)) {
                return curr;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String pattern = "AABA";
        String text = "AABAACAADAABAABA";
        automatapatternsearch(pattern.toCharArray(), text.toCharArray(), 256);
    }
}
