import java.util.*;
import java.io.*;

public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int maxVal = 0;
        int x;

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                if(value>maxVal) {
                	maxVal =value;
                }
                stack.push(value);
                arr.add(maxVal);
            } else if ("pop".equals(operation)) {
            	 x = stack.peek();
                stack.pop();
                for(int i=0;i<arr.size();i++) {
                	if(arr.get(i)==x) {
                		arr.remove(i);
                	}
                }
                
            } else if ("max".equals(operation)) {
                //System.out.println(Collections.max(stack));
                Collections.sort(arr,Collections.reverseOrder());
                System.out.println(arr.get(0));
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
