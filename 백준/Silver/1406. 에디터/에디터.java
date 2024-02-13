import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		String data;
		Node left;
		Node right;

		public Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static Node head = new Node(null);
	static Node cur;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Node node = new Node(s.charAt(0) + "");
		head.right = node;
		node.left = head;
		cur = head.right;
		for (int i = 1; i < s.length(); i++) {
			node = new Node(s.charAt(i) + "");
			cur.right = node;
			node.left = cur;
			cur = cur.right;
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "L":
				if (cur != head) {
					cur = cur.left;
				}
				break;
			case "D":
				if (cur.right != null) {
					cur = cur.right;
				}
				break;
			case "B":
				if (cur != head) {
					if (cur.right != null) {
						cur.right.left = cur.left;
					}
					cur.left.right = cur.right;
					cur = cur.left;
				}
				break;
			case "P":
				node = new Node(st.nextToken());
				if (cur == head) {
					head.right.left = node;
					node.right = head.right;
					head.right = node;
					node.left = head;
					cur = node;
				} else if (cur.right == null) {
					node.left = cur;
					cur.right = node;
					cur = node;
				}
//				else if (cur.left == head) {
//					node.right = head.right;
//					head.right.left = node;
//					head.right = node;
//					node.left = head;
//					cur = node;
//				} 
				else {
					node.left = cur;
					node.right = cur.right;
					cur.right.left = node;
					cur.right = node;
					cur = node;
				}

				break;
			}
		}
		cur = head.right;
		while (cur.right != null) {
			sb.append(cur.data);
			cur = cur.right;
		}
		sb.append(cur.data);
		System.out.println(sb.toString());
	}// end of main
}// end of class