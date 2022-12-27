package my.leetcode;

public class RabinKarp {
	private long patHash; // pattern hash value
	private int M; // pattern length
	private long Q; // modulus
	private int R; // radix
	private long RM1; // R^(M-1) % Q
	private boolean reverse;

	public RabinKarp(){}

	public RabinKarp(int patLen, int patHash, long modulo, int power, boolean reverse) {
		M = patLen;
		this.R = power;
		this.Q = modulo;
		RM1 = 1;
		for (int i = 1; i <= M - 1; i++)
			RM1 = (power * RM1) % Q;
		this.reverse = reverse;
		this.patHash = patHash;
		this.R = power;
	}

	public RabinKarp(String pat, long modulo, int power, boolean reverse) {
		M = pat.length();
		this.R = power;
		this.Q = modulo;
		RM1 = 1;
		for (int i = 1; i <= M - 1; i++)
			RM1 = (power * RM1) % modulo;
		this.reverse = reverse;
		patHash = hash(pat, M);
	}

	private int val(String key, int idx) {
		return key.charAt(idx) - 'a' + 1;
	}

	long hash(String key, int M) {
		long h = 0;
		if (reverse) {
			int slen = key.length();
			for (int j = slen - 1; j >= slen - M; j--) {
				int c =  val(key, j);
				h = (h * R + c) % Q;

			}
		} else {

			for (int j = 0; j < M; j++)
				h = (h * R + val(key, j)) % Q;
		}
		return h;
	}

	public int search(String txt) {
		if (reverse)
			return searchReverse(txt);
		int N = txt.length();
		long txtHash = hash(txt, M);
		if (patHash == txtHash)
			return 0;
		for (int i = M; i < N; i++) {
			txtHash = (txtHash + Q - RM1 * val(txt, i - M) % Q) % Q;
			txtHash = (txtHash * R + val(txt, i)) % Q;
			if (patHash == txtHash)
				return i - M + 1;
		}
		return N;
	}


	private int searchReverse(String txt) {
		int N = txt.length();
		long txtHash = hash(txt, M);
		int res = -1;
		if (patHash == txtHash)
			res = txt.length() - M;
		for (int i = N - 1; i - M >= 0; i--) {
			txtHash = (txtHash + 5*Q - RM1 * val(txt, i) % Q) % Q;
			txtHash = (txtHash * R + val(txt, i - M)) % Q;
			if (patHash == txtHash)
				res = i - M;
		}
		
		return res;

	}

}
