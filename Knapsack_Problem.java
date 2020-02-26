package dynamic;

import java.util.Arrays;

//time complexity O(n*W) ;n=number of weights
public class Knapsack_Problem {

	private int W;
	private int[] weights;

	public Knapsack_Problem(int BagCapacity, int[] weights) {
		W = BagCapacity;
		this.weights = weights;
	}
	
//returns the maximum weight the bag can carry
//every weight can be used only once
	public int maxWeightValue() {
		int[][] opt = new int[W + 1][weights.length + 1];
		opt[0][0] = 0;
		for (int n = 1; n < weights.length+1; n++) {
			for (int s = 1; s < W+1; s++) {
				if (weights[n-1] <= s) {
					opt[s][n] = Math.max(weights[n-1] + opt[s - weights[n-1]][n - 1], opt[s][n - 1]);
				} else {
					opt[s][n] = opt[s][n - 1];
				}
			}
		}
		printSol(opt);
		
		return opt[W][weights.length];
	}
	
//return the max number of weights the bag can carry
//every weight can be used only once
	public int maxNumOfWeights() {
		int[][] opt = new int[W + 1][weights.length + 1];
		opt[0][0] = 0;
		for (int n = 1; n < weights.length+1; n++) {
			for (int s = 1; s < W+1; s++) {
				if (weights[n-1] <= s) {
					opt[s][n] = Math.max(1 + opt[s - weights[n-1]][n - 1], opt[s][n - 1]);
				} else {
					opt[s][n] = opt[s][n - 1];
				}
			}
		}
		printSol(opt);
		return opt[W][weights.length];
	}
	
//return the max number of weights the bag can carry
//can reuse the same weights	
	public int maxNumOfWeights2() {
		int[][] opt = new int[W + 1][weights.length + 1];
		opt[0][0] = 0;
		for (int n = 1; n < weights.length+1; n++) {
			for (int s = 1; s < W+1; s++) {
				if (weights[n-1] <= s) {
					opt[s][n] = Math.max(1 + opt[s - weights[n-1]][n], opt[s][n - 1]);
				} else {
					opt[s][n] = opt[s][n - 1];
				}
			}
		}
		printSol(opt);
		return opt[W][weights.length];
	}
	
	public void printSol(int[][] mat) {
		System.out.println("the weights value "+Arrays.toString(weights)+"\nthe bag capacity: "+W);
		System.out.print("* ");
		for (int n = 0; n < W+1; n++) {
			System.out.print(n+" ");
		}
		int flag;
		for (int n = 0; n < weights.length+1; n++) {
			System.out.println();
			flag=1;
			for (int s = 0; s < W+1; s++) {
				if(flag==1&&n<weights.length+1) {
					System.out.print(n+" ");
					flag=0;
				}
				System.out.print(mat[s][n] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Knapsack_Problem kp = new Knapsack_Problem(7, new int[] { 2, 4, 5 });
//		System.out.println("the max weight value is: "+kp.maxWeightValue());
//		System.out.println("\nthe max weights is: "+kp.maxNumOfWeights());
//		System.out.println("\nthe max weights is: "+kp.maxNumOfWeights2());
	}
}
