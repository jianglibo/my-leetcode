package my.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DoubleLink {

	public static class Dnode {
		private Integer key;

		/**
		 * @return the key
		 */
		public Integer getKey() {
			return key;
		}

		private Integer value;

		/**
		 * @return the value
		 */
		public Integer getValue() {
			return value;
		}


		private int cnt;

		private Dnode prev;
		private Dnode next;

		public Dnode(int key, int value) {
			this.key = key;
			this.value = value;
			this.cnt = 1;
		}

		@Override
		public String toString() {
			return "key=>" + key + ", value=" + value + ", cnt=" + cnt;
		}

	}

	private Dnode header;
	private Dnode tail;
	private int size;

	private int capacity;

	Map<Integer, Dnode> cntToFirstNode;

	Map<Integer, Dnode> keyToNode;

	public DoubleLink(int capacity) {
		size = 0;
		header = new Dnode(0, 0);
		tail = new Dnode(0, 0);

		header.next = tail;
		tail.prev = header;
		this.capacity = capacity;

		cntToFirstNode = new HashMap<>();
		keyToNode = new HashMap<>();
	}

	public void add(Dnode node) {
		if (capacity == 0)
			return;
		if (keyToNode.size() >= capacity) {
			popTail();
		}

		Dnode toInsertBefore = cntToFirstNode.containsKey(1) ? cntToFirstNode.get(1) : tail;

		Dnode newPre = toInsertBefore.prev;

		node.prev = newPre;
		node.next = toInsertBefore;
		newPre.next = node;
		toInsertBefore.prev = node;

		cntToFirstNode.put(1, node);
		keyToNode.put(node.getKey(), node);
		size++;
	}

	public void increaseCnt(Dnode node) {
		Dnode curFirst = cntToFirstNode.get(node.cnt);
		Dnode prev = node.prev;
		Dnode next = node.next;

		if (prev.prev == null) { // it's header. it musts be firstNode.
			cntToFirstNode.put(node.cnt + 1, node);
		} else {
			assert curFirst != null : "key: " + node.getKey() + ", value: "
					+ node.getValue();
			Dnode preCurFirst = curFirst.prev;
			Dnode preFirst = null;
			if (preCurFirst.prev != null) { // it's header.
				int preCnt = preCurFirst.cnt;
				preFirst = cntToFirstNode.get(preCnt);
			}

			// if curFirst.cnt == 2, then preFirst.cnt maybe 3 or more.
			// if preFirst.cnt is 3, then move to the front of th preFirst.
			// if preFirst.cn is >3, then move to the front of the curFirst.
			if (preFirst != null && preFirst.cnt == curFirst.cnt + 1) {
				next.prev = prev; // leaving origin place.
				prev.next = next;
				// node had moved to new place.
				node.prev = preFirst.prev;
				node.next = preFirst;
				preFirst.prev.next = node;
				preFirst.prev = node;
			} else { // the gap is more than 1;
					// even if node == curFirst, we need to put it back cause we
					// had unattached before.
				if (node != curFirst) {
					next.prev = prev; // leaving origin place.
					prev.next = next;
					node.prev = curFirst.prev;
					node.next = curFirst;
					curFirst.prev.next = node;
					curFirst.prev = node;
				}
			}

			cntToFirstNode.put(node.cnt + 1, node);
		}
		if (node == curFirst) {
			if (next.next == null) { // it's tail.
				cntToFirstNode.remove(node.cnt);
			} else if (next.cnt == node.cnt) {
				cntToFirstNode.put(node.cnt, next); // replace to the next
									// same account.
			} else {
				cntToFirstNode.remove(node.cnt); // it's the only one.
			}
		} else {
			// just move the new place.
		}
		node.cnt++;
	}

	public void increaseCnt(int key) {
		Dnode dn = keyToNode.get(key);
		if (dn != null) {
			increaseCnt(dn);
		}

	}

	void remove(Dnode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		keyToNode.remove(node.getKey());

		if (cntToFirstNode.get(node.cnt) == node) {
			cntToFirstNode.remove(node.cnt);
		}
		size--;
	}

	Dnode getTail() {
		if (size > 0) {
			Dnode node = tail.prev;
			return node;
		}
		return null;
	}

	public Dnode popTail() {
		if (size > 0) {
			Dnode node = tail.prev;
			remove(node);
			return node;
		} else
			return null;
	}

	int get(int key) {
		if (keyToNode.containsKey(key)) {
			Dnode dn = keyToNode.get(key);
			increaseCnt(dn);
			return dn.getValue();
		} else {
			return -1;
		}
	}

	void put(int key, int value) {
		if (keyToNode.containsKey(key)) {
			Dnode dn = keyToNode.get(key);
			dn.value = value;
			increaseCnt(dn);
		} else {
			Dnode dn = new Dnode(key, value);
			add(dn);
		}
	}
}
