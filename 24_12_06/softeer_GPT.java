import java.util.*;

class Pair implements Comparable<Pair> {
    int integerPart;
    int fractionalPart;

    public Pair(int integerPart, int fractionalPart) {
        this.integerPart = integerPart;
        this.fractionalPart = fractionalPart;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.integerPart != other.integerPart) {
            return Integer.compare(this.integerPart, other.integerPart);
        }
        return Integer.compare(this.fractionalPart, other.fractionalPart);
    }
}

public class softeer_GPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Pair[] arr = new Pair[N];

        for (int i = 0; i < N; i++) {
            String tmp = scanner.nextLine();

            String[] parts = tmp.split("\\.");
            int integerPart = Integer.parseInt(parts[0]);
            int fractionalPart = (parts.length > 1) ? Integer.parseInt(parts[1]) : -1;

            arr[i] = new Pair(integerPart, fractionalPart);
        }

        Arrays.sort(arr);

        for (Pair pair : arr) {
            if (pair.fractionalPart == -1) {
                System.out.println(pair.integerPart);
            } else {
                System.out.println(pair.integerPart + "." + pair.fractionalPart);
            }
        }

        scanner.close();
    }
}