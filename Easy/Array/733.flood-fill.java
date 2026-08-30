/*
 * 733. Flood Fill
 * Difficulty: Easy
 * https://leetcode.com/problems/flood-fill/
 *
 * ──────────────────────────────────────────────────
 *
 * You are given an image represented by an m x n grid of integers
 * image, where image[i][j] represents the pixel value of the image. You
 * are also given three integers sr, sc, and color. Your task is to
 * perform a flood fill on the image starting from the pixel
 * image[sr][sc].
 *
 * To perform a flood fill:
 *
 * 	• Begin with the starting pixel and change its color to color.
 *
 * • Perform the same process for each pixel that is directly adjacent
 * (pixels that share a side with the original pixel, either horizontally
 * or vertically) and shares the same color as the starting pixel.
 *
 * • Keep repeating this process by checking neighboring pixels of the
 * updated pixels and modifying their color if it matches the original
 * color of the starting pixel.
 *
 * • The process stops when there are no more adjacent pixels of the
 * original color to update.
 *
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 *
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 *
 * Explanation:
 *
 * From the center of the image with position (sr, sc) = (1, 1) (i.e.,
 * the red pixel), all pixels connected by a path of the same color as
 * the starting pixel (i.e., the blue pixels) are colored with the new
 * color.
 *
 * Note the bottom corner is not colored 2, because it is not
 * horizontally or vertically connected to the starting pixel.
 *
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 *
 * Output: [[0,0,0],[0,0,0]]
 *
 * Explanation:
 *
 * The starting pixel is already colored with 0, which is the same as
 * the target color. Therefore, no changes are made to the image.
 *
 *
 *
 * Constraints:
 *
 * 	• m == image.length
 *
 * 	• n == image[i].length
 *
 * 	• 1 <= m, n <= 50
 *
 * 	• 0 <= image[i][j], color < 2^16
 *
 * 	• 0 <= sr < m
 *
 * 	• 0 <= sc < n
 *
 *  O(n * m) in space and time
*/

class Solution {
    private static int[] UP = {-1, 0};
    private static int[] RIGHT = {0, 1};
    private static int[] DOWN = {1, 0};
    private static int[] LEFT = {0, -1};
    private static int[][] DIRECTIONS = { UP, RIGHT, DOWN, LEFT};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int prevColor = image[sr][sc];
        if (prevColor == color) return image;
        image[sr][sc] = color;


        for (int[] dir: DIRECTIONS) {
            int adjSr = sr + dir[0];
            int adjSc = sc + dir[1];

            if (isInBounds(image, adjSr, adjSc) && prevColor == image[adjSr][adjSc])
                floodFill(image, adjSr, adjSc, color);
        }

        return image;
    }

    public boolean isInBounds(int[][] image, int sr, int sc) {
        return 0 <= sr && sr < image.length
            && 0 <= sc && sc < image[0].length;
    }
}
