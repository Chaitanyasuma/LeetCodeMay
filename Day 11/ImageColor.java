class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor)
            rdfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    public void rdfs(int[][] image, int xin, int yin, int newColor, int orig) {
        if(xin > (image.length - 1) || xin < 0 || yin > (image[0].length - 1) || yin < 0) { //checking if four directional positions are in the image
            return;
        }
        if(image[xin][yin] == orig) {
            image[xin][yin] = newColor; //changed to new color  
            int arr[][] = {{xin - 1, yin},
                           {xin, yin - 1},
                           {xin + 1, yin},
                           {xin, yin + 1}};
            rdfs(image, arr[0][0], arr[0][1], newColor, orig);
            rdfs(image, arr[1][0], arr[1][1], newColor, orig);
            rdfs(image, arr[2][0], arr[2][1], newColor, orig);
            rdfs(image, arr[3][0], arr[3][1], newColor, orig); 
        }
        else
            return;
    }
}