class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) { //only two points
            return true;
        }
        //find slope
        float m = slope(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        return check(coordinates, m, coordinates[0][0], coordinates[0][1]);
    }
    
    public float slope(int x1, int y1, int x2, int y2) {
        if(x2 == x1) { //straight line passing through an x-coordinate
            return -1;
        }
        return ((y2 - y1)/(x2 - x1));
    }
    
    public boolean check(int[][] coordinates, float m, int x1, int y1) {
        for(int i = 2; i < coordinates.length; i++) { //for every next point
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if(m == -1) {
                if(x != x1) {
                    return false;
                }
            }
            else {
                int lhs = y - y1;
                int rhs = x - x1;
                if(lhs != (m * rhs)) {
                    return false; 
                }
            }
        }
        return true;
    }
}