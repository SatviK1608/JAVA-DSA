package tries;

public class Tries {
	
	
	class TrieNode{
		boolean isWordComplete;
		TrieNode children[];
		
		public TrieNode(){
			isWordComplete=false;
			children=new TrieNode[26];
		}
	}
	TrieNode root;
	public Tries() {
		// TODO Auto-generated constructor stub
		 root=new TrieNode();
	}
	
	public void insert(String word){
		TrieNode current=root;
		
		for(int i=0;i<word.length();i++){
			char ch=word.charAt(i);
			int index=ch-'a';
			if(current.children[index]==null){
				current.children[index]=new TrieNode();
			}
			current=current.children[index];
		}
		current.isWordComplete=true;
	}
	
	public boolean search(String word){
		TrieNode current=root;
		for(int i=0;i<word.length();i++){
			char ch=word.charAt(i);
			int index=ch-'a';
			
			if(current.children[index]==null){
				return false;
			}
			current=current.children[index];
		}
		return current.isWordComplete;
		
	}
	public boolean startsWith(String prefix){
		TrieNode current=root;
		
		for(int i=0;i<prefix.length();i++){
			char ch=prefix.charAt(i);
			int index=ch-'a';
			
			if(current.children[index]==null){
				return false;
			}
			current=current.children[index];
		}
		return true;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries trie=new Tries();
		trie.insert("coder");
		trie.insert("coke");
		trie.insert("coded");
		
		System.out.println(trie.search("code"));
		System.out.println(trie.search("coder"));
		System.out.println(trie.search("coded"));
		
		System.out.println("Starts with code :"+trie.startsWith("code"));
		

	}
}
