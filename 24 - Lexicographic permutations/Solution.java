import java.util.*;

public class Solution {

	static ArrayList<String> lex = new ArrayList<String>();
	public static void main(String[] args) {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(int i = 0; i<10; i++){
			Node newNode = new Node(String.valueOf(i));
			for(int j = 0; j<nodes.size(); j++){
				nodes.get(j).addConnection(newNode);
				newNode.addConnection(nodes.get(j));
			}
			nodes.add(newNode);
		}
		
		for(int i=0;i<nodes.size();i++){
			findPaths(nodes.get(i), "" , 1);
			if(lex.size() == 1000000){
				break;
			}
		}
		System.out.println(lex.get(999999));
		
		
	}
	
	static void findPaths(Node currNode, String path, int depth){
		
		if(lex.size() == 1000000){
			return;
		}
		
		for(int i = 0;i<path.length();i++){
			if(path.substring(i, i+1).equals(currNode.value)){
				return;
			}
		}
		path += currNode.value;
		if(depth == 10){
			lex.add(path);
			return;
		}
		
		for(int i=0;i<currNode.connections.size();i++){
			findPaths(currNode.connections.get(i), path, depth + 1);
		}
		
	}
}

class Node{
	
	String value;
	ArrayList<Node> connections = new ArrayList<Node>();
	
	public Node(String val){
		this.value = val;		
	}
	
	public void addConnection(Node toAdd){
		this.connections.add(toAdd);
	}
}
