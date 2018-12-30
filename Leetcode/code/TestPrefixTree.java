package niuke;

public class TestPrefixTree {
	public static void main(String[] args) {
		PrefixTree tree = new PrefixTree();
		tree.insert("lyc");
		System.out.println(tree.search("lyc"));
		tree.insert("lyc");
		System.out.println(tree.search("lyc"));
		tree.insert("lycgood");
		System.out.println(tree.searchByPrefix("lyc"));
		tree.delete("lyc");
		System.out.println(tree.search("lyc"));
		tree.delete("lyc");
		System.out.println(tree.search("lyc"));
	}
}
