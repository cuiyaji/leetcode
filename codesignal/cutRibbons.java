import java.util.*;

class cutRibbons {
	public static void main(String[] args) {
		float[] m = new float[]{5, 4, 2, 1};
		cutRibbons instance = new cutRibbons();
		System.out.println(instance.maxLen(m, 6));
	}

	public float maxLen(float[] arr, int n) {
		int r = arr.length;
		float[][] dp_allrib = new float[r][n+1];
		float[][] dp_sigrib = new float[r][n+1];
		float maxLen = 0f;
		// r = 0
		for(int i = 1; i <= n; i++){
			dp_allrib[0][i] = arr[0] / i;
			dp_sigrib[0][i] = arr[0] / i;
		}
		// n = 1
		for(int i = 0; i < r; i++){
			dp_allrib[i][1] = arr[0];
			dp_sigrib[i][1] = arr[i];
			maxLen = Math.max(maxLen, dp_allrib[i][0]);
		}
		// dp
		for(int rib = 1; rib < r; rib++){
			for(int num = 2; num <= n; num++){
				dp_sigrib[rib][num] = arr[rib] / num;
				for(int cur_num = 1; cur_num <= num; cur_num++){
					dp_allrib[rib][num] = Math.max(Math.min(dp_allrib[rib - 1][num - cur_num], dp_sigrib[rib][cur_num]), dp_allrib[rib][num]);
				}
				dp_allrib[rib][num] = Math.max(dp_allrib[rib][num], dp_allrib[rib-1][num]);
			}
		}
		for(int i = 0; i < r; i++){
			maxLen = Math.max(maxLen, dp_allrib[i][n]);
		}
		return maxLen;
	}
}
