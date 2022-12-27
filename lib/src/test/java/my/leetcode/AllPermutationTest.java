package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.atIndex;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AllPermutationTest {

	@Test
	void t1() {

		int[] a = {0, 1, 2, 3, 4, 5, 6};
		AllPermutation ap = new AllPermutation(a);

		ap.GetFirst();
		while (ap.HasNext()) {
			ap.GetNext();
		}
	}

	@Test
	void tchar() {
		char[] cc = {'a', 'c', 'n', 'b'};
		Arrays.sort(cc);
		char[] ccn = {'a', 'b', 'c', 'n'};
		char[] ccn1 = {'b', 'c', 'a', 'n'};
		assertThat(cc).containsExactly(ccn);
		assertThat(cc).contains(ccn1);
		assertThat(1 << 5).isEqualTo(32);
		assertThat(Integer.toBinaryString(1 << 5)).isEqualTo("100000");

	}

	@Test
	void tregex() {
		String regex = "(\\b\\w+)\\s+(\\1\\s+)*(\\1\\b)";
		Pattern p = Pattern.compile(regex,
				Pattern.CASE_INSENSITIVE/* Insert the correct Pattern flag here. */);
		String input = "a a a a a a a a a a a a a a a a";
		Matcher m = p.matcher(input);
		while (m.find()) {
			String g0 = m.group(0);
			String g1 = m.group(1);
			String g = m.group();
			input = input.replaceAll("\\b" + m.group(), m.group(1));
		}
		log.info("{}", input);
	}

	boolean matchedTag(String tagInDq, String tag) {
		if (tag.charAt(1) == '/' && tagInDq.charAt(1) != '/') {
			String tmp = '<' + tag.substring(2);
			return tagInDq.equals(tmp);
		} else {
			return false;
		}
	}

	void extracContent(String line, Pattern tagPattern, Deque<MatchResult> dq,
			Consumer<String> cs) {
		Matcher m = tagPattern.matcher(line);
		int[] lastContent = new int[2];
		boolean once = false;
		while (m.find()) {
			MatchResult mr2 = m.toMatchResult();
			if (mr2.group().charAt(1) != '/') {
				dq.push(mr2);
			} else {
				MatchResult mrDq = dq.peek();
				if (mrDq != null) {
					if (matchedTag(mrDq.group(), mr2.group())) {
						if (lastContent[1] != 0 && (mrDq
								.end() < lastContent[0]
								|| (mrDq.end() == lastContent[0]
										&& mr2.start() > lastContent[1]))) {
							// cs.accept("None");
							// Noop
							// log.info("{}",
							// Arrays.toString(lastContent));
						} else if (mrDq.end() == lastContent[0]
								&& mr2.start() == lastContent[1]) {
							// Noop
							// log.info("{}",
							// Arrays.toString(lastContent));
						} else {
							String content = line.substring(mrDq.end(),
									mr2.start());
							if (!content.isEmpty()) {
								cs.accept(content);
								once = true;
							}
						}
						lastContent[0] = mrDq.start();
						lastContent[1] = mr2.end();
						dq.pop();
					} else {
						dq.clear();
					}
				}
			}
		}
		if (!once) {
			cs.accept("None");
		}
	}

	@Test
	void tExtract() {
		String html = "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>";
		Deque<MatchResult> dq = new ArrayDeque<>();
		Pattern ptn = Pattern.compile("<.+?>");
		String lines = """
				<h1>had<h1>public</h1515></h1>
				wRhDGQCG`r N4=cWqp4jF"#I7#)jofKUYktmjH("s2nD4+NxsN)tpCf2U@78MsGNbEgSgR=6`"y685~I(D-p&T2BnaJNa%S%y9pYMb_9v{PlScQ7R=~~xnSkpSd<orcsjzalN#eslhhH2d"1MD)pzc*$tBG-mmI_*zW><xMphtS-F8MVM^u2n5tN2DthGw{KZ`y7)><ZpjQU2&UMjzwJwnV70-CiM}M-OvR%a)Vk3R}2><DqcnlvJJa7ZYYrX^M*BI^*A_-mm0 HT4i^syNtujpEE8M@><mpX{FWXe#$d`)QdqT#eBbH=EJOXc@cFhxpJg14#*G0 o-w9G++`GA9U><PbwFCKiY2D^jhX_l7fM}tsB6QKv#@U#g%P%><WNbHpmOM# X_$FjjX$49DedlEf~_d&3j`LU9OLM%@y)2u^A5aO#><gXzyXZFrpOGaC+M4)kG`d5L*lRW5A#O0i=V023f_iSwqL$_qRMp59PW gf6><GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>YjncQJp=mN8OV9WEviqvJT`YS$WD=^gryB)NWAal</GfYTkjn{CTWM-U@3Wv(h( ~Cnc9&BKA>QMewBnIzsV</WNbHpmOM# X_$FjjX$49DedlEf~_d&3j`LU9OLM%@y)2u^A5aO#></PbwFCKiY2D^jhX_l7fM}tsB6QKv#@U#g%P%>dPcdFnfTMuYyOFExhXoymEYRVptmHjbgR</ZpjQU2&UMjzwJwnV70-CiM}M-OvR%a)Vk3R}2>wDegwAFAmjapXOejj</xMphtS-F8MVM^u2n5tN2DthGw{KZ`y7)>gEpaCbApodfJVPXVuct<bbgnEsMI_M%9L=E v)f6GjS_kSK6W5HWdel)VbBvZRG)#&b=+6k(O9=&C>rulVew89#uyWF}4`T"xULOZ%1"5Cu)&x7qD0</bbgnEsMI_M%9L=E v)f6GjS_kSK6W5HWdel)VbBvZRG)#&b=+6k(O9=&C><RicmJtmTo9uWkW^szFhT_OJ}_Jr4Galzm^v24RxPJkiUQN`vXV><ofMiPADbv&XoS=rU{r5JRfE+R}DgSHV@%zDk1golMD_IMuJ1U`~~TyD><lCERjrGdOfuVC0"8W##`L8x+qC=HW><UnWhEk9TPbbij$y_M0J {0FKn*Gk`IHq88Z3I*18iOvbdA_><pXHzGgQgKWj}@x^Mr}7X_Sf6_P*b_{`A$$AouU&e81l}uy3ijn&K1BmXHY>nhPeJWSTIkb Gs_~ztKS*b#36E+ThD</pXHzGgQgKWj}@x^Mr}7X_Sf6_P*b_{`A$$AouU&e81l}uy3ijn&K1BmXHY></UnWhEk9TPbbij$y_M0J {0FKn*Gk`IHq88Z3I*18iOvbdA_>zBesDtLSpVYfUzgds</lCERjrGdOfuVC0"8W##`L8x+qC=HW>OjuAcMjbwMLuylplc</RicmJtmTo9uWkW^szFhT_OJ}_Jr4Galzm^v24RxPJkiUQN`vXV>ZuWHgfxmI&l}D@r%q=mSj  Y&paOAZFf=~}I_Eg<CJQuDskoQL=5PG-ONFzA"yYhcEB2#ize-4H%+^b=Db~p(1U%=UKeCt5ZWS>RCKchSzpkdh0oF aNt (%Vu ^ap3K0GP634h_k%1FsO$Wu0n1aeLEPSBHpGpHdWrIrIApQrorxMIBVbyhh</CJQuDskoQL=5PG-ONFzA"yYhcEB2#ize-4H%+^b=Db~p(1U%=UKeCt5ZWS><XqPMRbmTQnlc#1 =N^z7~QuF2v(4}fd6^2BVJ8Wog4EHA~l%RNg_7Zb><RIEb0nii0bO5WV$%n#}TgB*fLl>RIAFwuGoRsU_9PleTRq{FS}fa3)1kRgn(C}ohOYXDqk</RIEb0nii0bO5WV$%n#}TgB*fLl>fQtRVddxdcuYJAikIUG</XqPMRbmTQnlc#1 =N^z7~QuF2v(4}fd6^2BVJ8Wog4EHA~l%RNg_7Zb>WmwMTg1FWlk0G6(mmh-SN"k&hoKwzfF0PLel$2)aLS5tW22jz=zX9M7S88Hm_1aF7<rQNSVnYKC-ALi0RYY#sqP%J9CRykB_p14ifh@@#j0Svdm57N}{6_#QRpFytrvzk&E{$1>tULUXNsa`iS~T(_BQ`EqJNSgxcO)$`~d=`F2Dqbst4-_N</rQNSVnYKC-ALi0RYY#sqP%J9CRykB_p14ifh@@#j0Svdm57N}{6_#QRpFytrvzk&E{$1><MB=7g =8{_aUlwE_>MoUMPsYfBJNd$G~"=dbO0U%aiOUaBBG&%(oFSfOZYvXSPFfwh@R QqyvTQ)3rJu%k6OBuBXkSShV=nm"qJ46_VKi1- oHK^EdKTk~gs%t"8<XnRH-gxlai2Jh`jmje=IUBZh`SUC"et(=81U0_wyx_mnRD4>LfOJpqbcGhsTzasaaYU</XnRH-gxlai2Jh`jmje=IUBZh`SUC"et(=81U0_wyx_mnRD4>YYYbEkrZ^wz=4046`&}N (^*_8EO^Eraw*jTFD~+IX%YX_Oo`f3BlFjmhSrEtE8FTe5870&+z(i@czXtI2mRfw7p^yFO_~r{*D0su6w&vnXb0aC+52Kol<byi)o%`Y{NBe>zYcZaQOKUCW4G0mJ$xe*xGIuY-&@1S`wkck%203&P{N}<lHrYNvRe#sQdvy-TurFDw+lUOyM1UI2sv`=><Nrp"OjKiUXOhM(fRCqS"C1-SmCTx%urq^=NEF-i*q&x><XKKZIu2zuIXam%aUp`bmJ(JwI`A""";
		Scanner scanner = new Scanner(lines);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			extracContent(line, ptn, dq, System.out::println);
		}
		scanner.close();
	}

	@Test
	void tTag() {
		assertThat('/' + "/").isEqualTo("//");
		String html = "<a><a>hello<b></a></a>";
		Pattern ptn = Pattern.compile("<.+?>");
		Matcher m = ptn.matcher(html);
		assertThat(m.find()).isTrue();
		assertThat(m.start()).isEqualTo(0);
		assertThat(m.end()).isEqualTo(3); // exclude.
		assertThat(m.group()).isEqualTo("<a>"); // exclude.

		MatchResult mr = m.toMatchResult();

		assertThat(m.find()).isTrue();
		MatchResult mr1 = m.toMatchResult();
		assertThat(m.start()).isEqualTo(3);
		assertThat(m.end()).isEqualTo(6); // exclude.
		assertThat(m.group()).isEqualTo("<a>"); // exclude.


		assertThat(mr.group()).isEqualTo("<a>");
		assertThat(mr1.group()).isEqualTo("<a>");

		Deque<MatchResult> dq = new ArrayDeque<>();
		Matcher m1 = ptn.matcher(html);
		if ("</a>".charAt(1) == '/') {
			String p = "</a>".substring(0, 1) + "</a>".substring(2);
			assertThat(p).isEqualTo("<a>");
		}
		while (m1.find()) {
			MatchResult mr2 = m1.toMatchResult();
			if (mr2.group().charAt(1) != '/') {
				dq.push(mr2);
			} else {
				MatchResult mrDq = dq.peek();
				if (mrDq != null) {
					if (matchedTag(mrDq.group(), mr2.group())) {
						String content = html.substring(mrDq.start(),
								mr2.end());
						assertThat(content).isEqualTo("hello");
						dq.pop();
					} else {
						dq.clear();
					}
				}
			}
		}
	}

	@Test
	void tArray() {
		String[] ary = {"Larry", "Moe", "Curly"};
		List<String> stooges = Arrays.asList(ary);
		assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> {
			stooges.add("c");
		});
		// List<String> sub1 = stooges
		Collections.reverse(stooges.subList(1, 3));
		assertThat(stooges).contains("Moe", atIndex(2));
		assertThat(stooges).contains("Larry", atIndex(0));
		assertThat(ary).contains("Moe", atIndex(2));
		assertThat(ary).contains("Larry", atIndex(0));
		assertThat(ary).containsExactly("Larry", "Curly", "Moe");
		Collections.reverse(stooges);
		assertThat(ary).containsExactly("Moe", "Curly", "Larry");

	}
}
