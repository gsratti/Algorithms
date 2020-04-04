package problemsolving;

/*
 * Question : https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMaxArea {
	
	/*
	 * Brute force (O(n2))
	 */
	
	public int getMaxArea(int height[]) {
		
		int maxArea = 0;
		int rectHeight;
		for (int i = 0; i< height.length; i++) {
			for(int j = i+1; j < height.length; j++) {
				rectHeight = height[i] > height[j] ? height[j] : height[i];
				if ((j-i) * rectHeight > maxArea) {
					maxArea = (j-i) * rectHeight;
				}
			}
		}
		return maxArea;
	}
	
	/*
	 * Two pointer approach ( O(n))
	 */
	
	public int getMaxArea1(int height[]) {
		
		int maxArea = 0;
		int currArea = 0;
		
		int left, right;
		left = 0 ;
		right = height.length;
		
	    while(left < right) {
	    	currArea = Math.min(height[left], height[right]) * (right - left);
	    	if(currArea > maxArea) {
	    		maxArea = currArea;
	    	}
	    	if(height[left] > height[right]) right--;
	    	else left++;
	    }
		return maxArea;
		
	}

}
