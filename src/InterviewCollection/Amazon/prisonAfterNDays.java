package InterviewCollection.Amazon;

public class prisonAfterNDays {

    public static void main(String[] args) {

        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int n = 7;

        prisonAfterNDays(cells, n);

    }

    /*
        Prison Cells After N Days
     */
    private static int[] prisonAfterNDays(int[] cells, int n) {

        for (int i = 0; i < n; i++) {
            prisonAfterNDays(cells);
            for (var c : cells) System.out.print(c + " ");
            System.out.println();
        }

        return cells;
    }

    private static int[] prisonAfterNDays(int[] cells) {

        int prev = cells[0];
        for (int i = 2; i < cells.length; i++) {
            if (prev == cells[i]) {
                prev = cells[i - 1];
                cells[i - 1] = 5;
            } else {
                prev = cells[i - 1];
            }
        }

        for (int i = 0; i < cells.length; i++) {
            cells[i] = (cells[i] == 5) ? 1 : 0;
        }

        return cells;


    }
}
