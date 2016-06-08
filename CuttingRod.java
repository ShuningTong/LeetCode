public class CuttingRod {
	public static void main(String[] args){
		int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("Maximum Obtainable Value is: " + cutRod(arr, 8));
		System.out.println("Maximum Obtainable Value is: " + cutRodDP(arr, 8));
	}

	public static int max(int a, int b){
		return (a>b)? a:b;
	}
	public static int cutRod(int[] price, int n){
		if(n <= 0){
			return 0;
		}
		int max_val = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++){
			max_val = max(max_val, price[i] + cutRod(price, n-i-1));
		}
		return max_val;
	}
	public static int cutRodDP(int[] price, int n){
		int[] val = new int[n+1];
		val[0] = 0;
		for (int i = 1; i <= n; i++){
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++){
				max_val = max(max_val, price[j] + val[i - j - 1]);
			}
			val[i] = max_val;
		}
		return val[n];
	}
}
