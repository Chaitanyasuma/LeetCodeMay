class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] fourdirection = fourdirectional(image.length, image[0].length, sr, sc);
        for(int i = 0; i < fourdirection.length; i++) {
            if(fourdirection[i][0] != -1) { //i.e. valid position
                if(image[fourdirection[i][0]][fourdirection[i][1]] == image[sr][sc]) { //i.e. same color
                    image[sr][sc] = newColor;
                    image = floodFill(image, fourdirection[i][0], fourdirection[i][1], newColor);
                }  
            }
        }
        return image;
    }   
    public int[][] fourdirectional(int height, int width, int x, int y) {
        int i = 0, j = 0;
        int arr[][] = {{x - 1, y},
                       {x, y - 1},
                       {x + 1, y},
                       {x, y + 1}};
        for(i = 0; i < arr.length; i++) {
            int xin = arr[i][0];
            int yin = arr[i][1];
            if(xin > (height - 1) || xin < 0 || yin > (width - 1) || yin < 0) { //checking if four directional positions are in the image
                arr[i][0] = -1; //made it invalid
            }
        }
        return arr;
    }
}