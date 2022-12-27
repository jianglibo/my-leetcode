package my.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import my.leetcode.DoubleLink.Dnode;

public class DoubleLinkTest {
	
	@Test
	void t() {
		DoubleLink dl = new DoubleLink(10);
		dl.add(new Dnode(1, 1));
		dl.add(new Dnode(2, 2));
		assertThat(dl.cntToFirstNode).hasSize(1);
		Dnode dn = dl.popTail();
		assertThat(dn.getKey()).isEqualTo(1);
		dl.add(new Dnode(1, 1));
		assertThat(dl.getTail().getKey()).isEqualTo(2);
		dl.increaseCnt(2);
		dl.getTail(); // key is 2
		assertThat(dl.getTail().getKey()).isEqualTo(1);
	}

	// ["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
	// [[3],[2,2],[1,1],[2],[1],[2],[3,3],[4,4],[3],[2],[1],[4]]

	@Test
	void t1() {
		DoubleLink dl = new DoubleLink(3);
		dl.put(2, 2);
		dl.put(1, 1);
		int v1 = dl.get(2);
		assertThat(v1).isEqualTo(2);
		v1 = dl.get(1);
		assertThat(v1).isEqualTo(1);
		v1 = dl.get(2);
		assertThat(v1).isEqualTo(2);
		dl.put(3, 3);
		dl.put(4, 4);
		v1 = dl.get(3);
		assertThat(v1).isEqualTo(-1);
		v1 = dl.get(2);
		assertThat(v1).isEqualTo(2);
		v1 = dl.get(1);
		assertThat(v1).isEqualTo(1);
		v1 = dl.get(4);
		assertThat(v1).isEqualTo(4);
	}

// ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
// [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
// [null,null,null,1,null,-1,3,null,-1,3,4]

	@Test
	void t3() {
		DoubleLink dl = new DoubleLink(2);
		dl.put(1, 1);
		dl.put(2, 2);
		int v1 = dl.get(1);
		assertThat(v1).isEqualTo(1);
		dl.put(3, 3);
		v1 = dl.get(2);
		assertThat(v1).isEqualTo(-1);
		v1 = dl.get(3);
		assertThat(v1).isEqualTo(3);
		v1 = dl.get(3);
		dl.put(4, 4);
		v1 = dl.get(1);
		assertThat(v1).isEqualTo(-1);
		v1 = dl.get(3);
		assertThat(v1).isEqualTo(3);
		v1 = dl.get(4);
		assertThat(v1).isEqualTo(4);
	}

// ["LFUCache","put","get"]
// [[0],[0,0],[0]]

	@Test
	void t4() {
String actions = """
["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
		""";
String parameters = """
 [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
		""";
		DoubleLink dl = null;
		JSONArray actionsJa = new JSONArray(actions);
		JSONArray parametersJa = new JSONArray(parameters);

		for(int i=0; i< actionsJa.length(); i++) {
			String a = actionsJa.getString(i);
			JSONArray pa = parametersJa.getJSONArray(i);
			if ("LFUCache".equals(a)) {
				dl = new DoubleLink(pa.getInt(0));
			} else {
				if (pa.length() == 1) {
					dl.get(pa.getInt(0));
				} else {
					dl.put(pa.getInt(0), pa.getInt(1));
				}
			}
		}
	}
}
