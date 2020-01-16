public class SetZero{
    public void setZeroes(int[][] matrix) {
        Set<Integer> set_row = new HashSet<>();
        Set<Integer> set_col = new HashSet<>();
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    set_col.add(j);
                    set_row.add(i);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (set_row.contains(i) || set_col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
