import java.util.*;

public class Solution {
	
	static int maxSum = 0;
	
	public static void main(String[] args) {
		
		//Paste ONLY the triangle from the website into the input and press Enter to read it and execute
		
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		Node start = new Node(num, 1, null);
		int lines = 15; //how many rows
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
	static void calculateMax(Node currNode, int sum, int lines){
		
		sum += currNode.value;
		
		if(checkForReturn(lines, currNode.line, sum)){
			return;
		}
		
		if(currNode.connections.size() == 0){
			if(sum > maxSum){
				maxSum = sum;
			}
			return;
		}
		
		
		if(currNode.connections.get(0).value > currNode.connections.get(1).value){
			calculateMax(currNode.connections.get(0), sum, lines);
			if(checkForReturn(lines, currNode.line, sum)){
				return;
			}
			calculateMax(currNode.connections.get(1), sum, lines);
		}
		else{
			calculateMax(currNode.connections.get(1), sum, lines);
			if(checkForReturn(lines, currNode.line, sum)){
				return;
			}
			calculateMax(currNode.connections.get(0), sum, lines);
		}
		return;
		
	}
	
	static boolean checkForReturn(int lines, int currLine, int sum){
		if((lines - currLine) * 99 + sum <= maxSum){
			return true;
		}
		return false;
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
