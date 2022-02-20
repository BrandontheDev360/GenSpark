import java.util.Arrays;

public class Land {
    public static String[][] land = {
            {" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "}
    };
    public static String[] row1 = land[0];
    public static String[] row2 = land[2];
    public static String[] row3 = land[4];
    public Land() {
    }
        public static void printLand(String[][] land){
                for (String[] row : land) {
                    for (String i : row) {
                        System.out.print("\t" + i);
                }
                    System.out.println();
            }
        }

    @Override
    public String toString() {
        return "Land = { land = " + Arrays.deepToString(land) + " }";
    }

}
