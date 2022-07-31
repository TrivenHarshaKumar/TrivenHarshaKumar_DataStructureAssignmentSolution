package ga2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p1 {

		static Scanner sc = new Scanner(System.in);
		static p1 tree = new p1();
		static Node output = null;

		static Stack order = new Stack();
		static PriorityQueue<Integer> daybyDay = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		static Node NewNode(int node)
		{
			Node temp = new Node();
			temp.node = node;
			temp.left =null;
			temp.right = null;
			return temp;
			
		}
		
		public Node Insert(Node root,int  key)
		{
			if(root ==null)
				return NewNode(key);
			if(key<root.node)
				root.left=Insert(root.left,key);
			else
				root.right=Insert(root.right,key);
			return root;
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Node  root =null;
			System.out.println("enter the total no of floors in the building");
			int n= sc.nextInt();
			int[] array = new int[n];
			for(int i=0;i<n;i++)
			{
				System.out.println("enter the floor size given on day : "+(i+1));
				int  number = sc.nextInt();
				root = tree.Insert(root, number);
				array[i]=number;
			}
			
			 Iterate(root);
			 System.out.println();
			System.out.println("The order of construction is as follows");

			 System.out.println();
			for(int i=0;i<n;i++)
			{
				System.out.println("Day: "+(i+1));
				daybyDay.add(array[i]);
				while(!order.isEmpty() && !daybyDay.isEmpty())
				{
						int a = (int)order.pop();
						int b = (int)daybyDay.poll();
						
						if(a == b)
						{
							System.out.print(a+" ");
							
						}
						else
						{
							order.push(a);
							daybyDay.add(b);
							break;
						}
					
				}

				System.out.println();
				
			}
		}
		
		public static void Iterate(Node root)
		{
			if(root.left!=null)
			{
				Iterate(root.left);
			}
				order.push(root.node);
				if(root.right!=null)
				{
					Iterate(root.right);
				}
		}
		
		

}