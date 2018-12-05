package problemsolving;

public class MaxCosecutiveDays {
    
    /*
     * Given an attendance array, in which data[i][j] represents attendance of jth employee on ith day.
     * We need to return maximum number of consecutive days on which all employees were present.
     *
     */
    
    public static int getMaxConsecutiveDays(int data[][])
    {
        int days = data.length;
        int maxConsecutiveDays = 0;
        int currConsecutiveDays = 0;
        
        for(int i=0; i<days; i++) {
            
            if(allEmployeesArePresent(data,i)) {
                currConsecutiveDays++;
                if(currConsecutiveDays > maxConsecutiveDays) {
                    maxConsecutiveDays = currConsecutiveDays;
                }
                
            } else {
                currConsecutiveDays = 0;
            }
        }
        return maxConsecutiveDays;
    }

    private static boolean allEmployeesArePresent(int[][] data, int i) {
        
        for(int j = 0; j < data[0].length ; j++) {
            if(data[i][j] == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
        int data[][] = {{1,1,1,1}, {1,1,1,0}, {1,1,1,1}, {1,1,1,0}, {1,1,1,0},{1,1,1,1},{1,0,1,1},{0,0,1,0}};
        System.out.println(getMaxConsecutiveDays(data));
    }

}
