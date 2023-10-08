package nc.binary.search;

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean binarySearch(int[][] matrix, int target, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        int curr = matrix[mid / (matrix[0].length)][mid % matrix[0].length];

        if (curr < target) {
            return binarySearch(matrix, target, mid + 1, end);
        } else if (curr > target) {
            return binarySearch(matrix, target, start, mid - 1);
        } else {
            return true;
        }

    }
}
