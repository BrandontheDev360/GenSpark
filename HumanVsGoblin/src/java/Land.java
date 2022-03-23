import java.util.Arrays;

public class Land {
    public static String[][] land = {
            {" ", "|", "H", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", " ", "|", " "},
            {"-", "+", "-", "+", "-"},
            {" ", "|", "G", "|", " "}
    };
    public static String[] row1 = land[0];
    public static String[] row2 = land[2];
    public static String[] row3 = land[4];
    public static String[] column;
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

        public static String[] getColumn (int index, String[][] land) {
                column = new String[land.length];
                for (int row = 0; row < land.length; row++) {
                    column[row] = land[row][index];
                }
                System.out.println(Arrays.toString(column));
                return column;
        }

    @Override
    public String toString() {
        return "Land = { land = " + Arrays.deepToString(land) + " }";
    }

}
