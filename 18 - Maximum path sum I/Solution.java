import java.util.*;

public class Solution {
	
	static long maxSum = 0L;
	
	public static void main(String[] args) {
		
		//Paste ONLY the triangle from the website into the input and press Enter to read it and execute
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		Node start = new Node(num, 1, null);
		
		int lines = 15;
		Node[] prevNums = new Node[]{start};
		
		for(int i = 2; i < lines + 1; i++){
			Node[] currNums = new Node[i];
			for(int j = 0; j < i; j++){
				num = in.nextInt();
				Node newNode = new Node(num, i, null);
				currNums[j] = newNode;
				if(j == 0){
					prevNums[j].AddConnection(newNode);
				}
				else if(j == i - 1){
					prevNums[prevNums.length - 1].AddConnection(newNode);
				}
				else{
					prevNums[j-1].AddConnection(newNode);
					prevNums[j].AddConnection(newNode);
				}
			}
			prevNums = currNums;
		}
		
		in.close();
		
		calculateMax(start, 0, lines);
		
		System.out.println(maxSum);
	}
	
	static void calculateMax(Node currNode, long sum, int lines){
		
		if(currNode.connections.size() == 0){
			if(sum + currNode.value > maxSum){
				maxSum = sum + currNode.value;
			}
			return;
		}
		
		sum += currNode.value;
		
		if((lines - currNode.line) * 99 + sum < maxSum){
			return;
		}
		
		for(int i=0;i<currNode.connections.size();i++){
			calculateMax(currNode.connections.get(i), sum, lines);
		}
		return;
		
	}
	
}

class Node{
	
	int value;
	int line;
	ArrayList<Node> connections = new ArrayList<Node>();
	
	public Node(int value, int line, Node to){
		this.value = value;
		this.line = line;
		if(to != null){
			this.connections.add(to);
		}
	}
	
	public void AddConnection(Node conn){
		this.connections.add(conn);
	}
}
