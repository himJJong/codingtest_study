import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2597 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        float s = 0;
        float e = N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        float r1 = Float.parseFloat(st.nextToken());
        float r2 = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(br.readLine());
        float b1 = Float.parseFloat(st.nextToken());
        float b2 = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(br.readLine());
        float y1 = Float.parseFloat(st.nextToken());
        float y2 = Float.parseFloat(st.nextToken());

        float mid = (r1 + r2) / 2;
        b1 = mid + Math.abs(mid - b1);
        b2 = mid + Math.abs(mid - b2);
        y1 = mid + Math.abs(mid - y1);
        y2 = mid + Math.abs(mid - y2);
        s = mid + Math.abs(mid - s);
        if (s > e)
            e = s;
        s = mid;

        if (b1 != b2) {
            mid = (b1 + b2) / 2;
            y1 = mid + Math.abs(mid - y1);
            y2 = mid + Math.abs(mid - y2);
            s = mid + Math.abs(mid - s);
            if (s > e)
                e = s;
            s = mid;
        }

        if (y1 != y2) {
            mid = (y1 + y2) / 2;
            s = mid + Math.abs(mid - s);
            if (s > e)
                e = s;
            s = mid;
        }
        System.out.println(e - s);
    }
}
