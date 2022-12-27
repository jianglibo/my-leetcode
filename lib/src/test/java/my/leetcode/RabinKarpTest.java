package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RabinKarpTest {

	@Test
	void t3() {
		int p, h;
		RabinKarp q;
		String s;
		q = new RabinKarp(1149, 39999, 94536, 71717, true);
		s = "kfedcbdngvlykqyrbvwbnaassgjifjxtawlafhcpjtpzfnbsqfasohevbbhkwmtnmixolfepkjmcbadqcljmsbonrngsgfqwzqiisbiwiqgtqtqddukgtjymbxzmtxrobuhkdxmdmqccrauzkrjisstznnkhupiandekzcchsrzwintkkzhvqomqmnbasynmvtxwydcvwoukqmgrpmgzqancuzapgncasxnbyznlrdvcbomdptjftgxdzeqzyavfdpseoxpvohpxtikyjfvskxyqbubgnseraxtrcrwjxloxymhqgaxwbbvzhjsbncqrlpdbiuakdjzjrbclhxgnjjyfrqyjchlsdrcwtdoktviqwjctlmzqemumgmjufcbixkfhzkugsvnkrrakccguybwhmuexiemqusltaaqrswsezccqzaputgaabrjdeihmkpzbojnusmhkwjdxvgiexwdkkazhhmlalgzvxgqgncfytrxuhkwhwcxhmlbvkhjcnyztepwnlpthozdqexvhxpvheopjrsjzkqrstczffkhkikelwydcbnghfiibeyabgegdgaqvasujmggltkvokmnsmontjzsmzoeeqenafvurbnbwqbizvaqxfgnoxasctfrwvqmoufvpajdkethlvbhbehxahcpcizocbchwfznhuqtblwepeqdhycrovqosmxxeeqaffjvvclmpcqdugndexexcykyusetuamymszlteobxkestwbzubpstbwrstuovlybycevedzgurqvlgkouvavcukccgixixsrndurvrkfegegnchbhockujlafxexlxhgysraviztkjymiqxrlldcixvfnzrpserrqycbfmesqbltywmandcqtluccbisfqzosbvedqhsxepdjevaasylvjmfpvyxqvclaalgxytiukyarojmzyovmiunkvqhkouhxxhbemavagrhteofpowvlpdunjjpwgcjibagfswrzwkgrwklppchvtukzncvoqorlsskyghkhrazwvyqqjfygmduhsfkrseddgmtdvlqeruxogmyttdqmdpmscspatkoifauivwjtbwisiiqztrllfqnjvbagrfylrpjudjmvwhdkhahyxlsfbkuuyofryfgblllzeacfiqqawridcbtqnroxwuqhyspqmwhxmjztqokofnkfvupcykszthicdgjbrgafpztktrcwtayoulnjaazigkinnpttghhyboiczvtswenshlmqyelnwhzqlswblqssiiynypfcxerlykpiyimkoodimdfdlzbwmlwflylcqwaflivqeonjswvowxgeoafmppodmfbvooodtnzgmhfnchenaaywqevklrpgajbmbxgiopofghlouhjfarjxlclcullsgyzhohowtragbkaebrvbkmxfxughlirtikheojbrrgxtqldfdnqxndzvfgajiltnqnuwavxbrvuiycsizunlglwnivpseyfwmgydmmpzhxkdtpuzpddacjmjhvncdoicedkimdgaqobdfagpggvjemstqbsshynyvhdyslgldvkapqgusmnuroqxcivjifkhrotomxodficktxmcytkbqitrlalpbtphowfgtzgfacabjodvivgykorvmxhzpqvskolkbfpbdgowlighossrlwiomgohfhgklmlnekniqfjmvvqvmimkeddfxnxwzzroospxvndynetghkgrakuslukqsrdtmjkblwrmwhzzojcwwogrjvnftdwwpoqcjqimvjbwgqgpeffjnwlzdyhkhwmvpwpcmjmdqneexqwcrvdxsfsnidwyflwxwngczklprhoazeeqwclrqvnicfvrtbqailbwrqxadxslouwdjycidupemdwhpkqekaxxprtdtmjficrhlvqidvgwkllaowyyajkxugqiztbpzvjqtpuyugkvdfcaczzruskvucsxtvroljnjojuzncatgnypbzwvilbajqqnjovqxcfunwwbxgshrjlajwveaswqegidfnedpxqdreddvawrpbllkcshlafnxyocbmwacytvgtoonlkukqhxwbfxcfnbgmrfcnkvtxmygiyjoyoljd";
		p = q.search(s);
		assertThat(936).isEqualTo(p);
	}

	@Test
	void t4() {
		int p, h;
		RabinKarp q;
		String s;
		q = new RabinKarp(2, 0, 20, 7, true);
		s = "leetcode";
		p = q.search(s);
		assertThat(1).isEqualTo(p);
	}

	int v(int[] A) {
		Arrays.sort(A);
		int p = Arrays.binarySearch(A, 0);
		
		int idx = -(p + 1);
		if (p >= 0) {
			idx = p;
		}

		if (idx == A.length) { // all negetive
			return 1;
		} else {
			int tmp = 1;
			for (int i = idx; i < A.length; i++) {
				if (tmp < A[i]) {
					return tmp;
				}
				tmp = A[i] + 1;
			}
			return A[A.length - 1] + 1;
		}
	}

	@Test
	void tt() {
		// write your code in Java SE 8
		int[] A = {-5, -10, -12};
		assertThat(v(A)).isEqualTo(1);
		int[] A1 = {-1, 1, 2, 3};
		assertThat(v(A1)).isEqualTo(4);

		int[] A2 = {-1, 1, 3};
		assertThat(v(A2)).isEqualTo(2);

		int[] A3 = {1,1,1};
		assertThat(v(A3)).isEqualTo(2);

		int[] A4 = {-1,-1,-1};
		assertThat(v(A4)).isEqualTo(1);

		int[] A5 = {0,0,0};
		assertThat(v(A5)).isEqualTo(1);

		int[] A6 = {-1,0,1};
		assertThat(v(A6)).isEqualTo(2);

	}

	int vvv(int[] A, int[] B) {
		long sa = 0, sb = 0;
		for(int i=0;i<A.length;i++) {
			sa += A[i];
			sb += B[i];
		}
		if (sa != sb || sa % 2 != 0) {
			return 0;
		}

		long half = sa / 2;

		long sc = 0, sd = 0;
		int k = 0;
		for(int i=0; i< A.length;i++) {
			sc += A[i];
			sd += B[i];
			if (sc == sd && sc == half && i < A.length - 1 && i > 0) {
				++k;
			}
		}
		return k;
	}

	@Test
	void cc() {
		int[] A = {0, 1};
		int[] B = {0};
		// int a  = vvv(A, B);
		// assertThat(a).isEqualTo(1);
		assertThat(Arrays.binarySearch(A, 0, 2, 0)).isEqualTo(0);
	}


}
