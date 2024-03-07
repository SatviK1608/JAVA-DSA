import java.util.Scanner;


public class TextEditor {

	class Node{
		 char value;
		 Node next;
		 Node prev;
		 
		 Node(char value){
			 this.value=value;
			 next=prev=null;
		 }
	 }
	class pNode{
		 Node data;
		 pNode next=null;
		 pNode prev=null;
		 
		 pNode(){
			 data=null;
			 next=null;
			 prev=null;
		 }
	 }
	
	pNode head;
	pNode currentLine;
	Node cursor;
	private static Scanner scanner;
	
	TextEditor(){
		Node thead=null;
		cursor=new Node('|');
		pNode newNode=new pNode();
		thead=cursor;
		newNode.data=thead;
		head=newNode;
		currentLine=head;
	}
	void insert(String text) {
		for (char c : text.toCharArray()) {
		      Node newNode = new Node(c);
		      newNode.prev = cursor.prev;
		      newNode.next = cursor;
		      if (newNode.prev != null) {
		        newNode.prev.next = newNode;
		      } else {
		        currentLine.data = newNode;
		      }
		      cursor.prev = newNode;
		    }
		displayText();
    }
	void newLine(){
		//Handle kr rha hu agr koi line hi nhi hai to simply return krdo
		
		pNode nextNode=currentLine.next;
		pNode newNode=new pNode();
		currentLine.next=newNode;
		newNode.prev=currentLine;
		if(cursor.prev!=null){
			cursor.prev.next=null;
			cursor.prev=null;
		}else{
			
			currentLine.data=null;
		}
		currentLine=newNode;
		currentLine.next=nextNode;
		//Agr khali line p cursor hai and uske niche wali line m kuch hai aur next line ko use kiya to voh un dono ke beech m new line ko append krde
		if(nextNode!=null){
			nextNode.prev=currentLine;
		}
		Node thead=null;
		thead=cursor;
		newNode.data=thead;
		displayText();
	}
	
	void deleteChar() {
        if (cursor.prev != null) {
            cursor.prev = cursor.prev.prev;
            if (cursor.prev != null) {
                cursor.prev.next = cursor;
            }
            //last word bhi khali krdiyaa
            else{
            	currentLine.data=cursor;
            }
        }   
        //Agar khaaali line ko delete kr rhe hai to puri line delete hojaye
        else{
        	if(currentLine.prev==null){
    			System.out.println("You are the only line");
    			return;
    			
    		}
        	Node leftData=cursor.next;
    		currentLine.data=delete(currentLine.data,0);
    		currentLine=currentLine.prev;
    		if(currentLine.next.data==null){
    			currentLine.next=currentLine.next.next;
    			if(currentLine.next!=null){
    				currentLine.next.prev=currentLine;
    			}
    			currentLine.data=insertCursor(currentLine.data,getLength(currentLine.data),0);
    		}
    		//agr hmara cursor 0pos p h aur hmne delete dbaya to uske age ka text upr wali line m shift hojegaa
    		else{
    			currentLine.data=insertCursor(currentLine.data,getLength(currentLine.data),1);
        		cursor.next=leftData;
        		leftData.prev=cursor;
        		if(currentLine.next.data!=null){
        			currentLine.next=currentLine.next.next;
        			if(currentLine.next!=null){
        				currentLine.next.prev=currentLine;
        			}
        		}
    		}
    		
    		//currentLine.next.data=null;
    		
        	
        }
        displayText();
        
    }

    void moveLeft() {
        if (cursor.prev != null) {
//        	System.out.println("if of left");
            cursor.value = cursor.prev.value;
            cursor = cursor.prev;
            cursor.value = '|';
        }
        else{
        	//similar code of moveUp
        	if(currentLine.prev==null){
    			System.out.println("You are at the first line");
    			return;
    			
    		}
    		currentLine.data=delete(currentLine.data,search(currentLine.data));
    		currentLine=currentLine.prev;
    		currentLine.data=insertCursor(currentLine.data,getLength(currentLine.data),0);
    		
        }
        displayText();
    }

    // Move cursor right
    void moveRight() {
        if (cursor.next != null) {
//        	System.out.println("if of right");
            cursor.value = cursor.next.value;
            cursor = cursor.next;
            cursor.value = '|';
        }
        else{
        	//similar code of move down
        	if(currentLine.next==null){
    			System.out.println("You are at the ending line");
    			return;
    		}
    		int posi=search(currentLine.data);
    		currentLine.data=delete(currentLine.data,posi);
    		currentLine=currentLine.next;
    		currentLine.data=insertCursor(currentLine.data,0,0);
    		
        }
        displayText();
    }
	
	
	
	void moveUp(){
		if(currentLine.prev==null){
			System.out.println("You are at the first line");
			return;
			
		}
		
		int posi=search(currentLine.data);
		currentLine.data=delete(currentLine.data,posi);
		currentLine=currentLine.prev;
		currentLine.data=insertCursor(currentLine.data,posi,0);
		displayText();
	}
	void moveDown(){
		if(currentLine.next==null){
			System.out.println("You are at the ending line");
			return;
		}
		int posi=search(currentLine.data);
		currentLine.data=delete(currentLine.data,posi);
		currentLine=currentLine.next;
		currentLine.data=insertCursor(currentLine.data,posi,0);
		displayText();
	}
	
	void displayText() {
		pNode temp=head;
        while(temp!=null){
        	Node node=temp.data;
        	while(node!=null){
        		System.out.print(node.value);
        		
        		node=node.next;
        	}
        	System.out.println();
        	temp=temp.next;
        }
    }
	int search(Node t){
		Node temp=t;
		int pos=0;
		while(temp!=null){
			if(temp.value=='|'){
				return pos;
			}
			temp=temp.next;
			pos++;
		}
		return pos;
	}
	int getLength(Node t){
		Node temp=t;
		int pos=0;
		while(temp!=null){
			temp=temp.next;
			pos++;
		}
		return pos;
	}
	Node delete(Node t,int posi){
		Node temp=t;
		if(posi==0){
			if(cursor.next==null){
				return null;
			}
			temp=temp.next;
			temp.prev=null;
			return temp;
		}
		if(posi==getLength(temp)-1){
			cursor.prev.next=null;
			cursor.prev=null;
			return temp;
		}
		cursor.prev.next=cursor.next;
		cursor.next.prev=cursor.prev;
		return temp;
	}
	Node insertCursor(Node t,int posi,int flag){
		if(t==null){
			if(flag==1)
			return cursor;
			else{
				cursor.next=null;
				return cursor;
			}
		}
		Node temp=t;
		if(posi>=getLength(t)){
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=cursor;
			cursor.prev=temp;
			cursor.next=null;
			return t;
		}
		else{
			int p=0;
			while(temp!=null){
				if(p==posi){
					break;
				}
				p++;
				temp=temp.next;
			}
			if(p==0){
				temp.prev=cursor;
				cursor.next=temp;
				return cursor;
			}
			temp.prev.next=cursor;
			cursor.prev=temp.prev;
			temp.prev=cursor;
			cursor.next=temp;
			return t;
		}
	}
	boolean searchWord(String word){
	   pNode temp=head;
	   int wordIndex = 0;
	   while (temp != null) {
		   Node currentNode=temp.data;
		   while(currentNode!=null){
			   if(currentNode.value=='|'){
				   currentNode=currentNode.next;
				   continue;
			   }
			   if (currentNode.value == word.charAt(wordIndex)) {
				   wordIndex++;
			       if (wordIndex == word.length()) {
			                    // Entire word found in linked list
			    	   return true;
			       }
			       currentNode = currentNode.next;
			   } 
			   else {
			       // Reset index and start over
				   currentNode = currentNode.next;
			       wordIndex = 0;
			   }
		   }
		   if(word.charAt(wordIndex)==' '){
			   wordIndex++;
		   }
		   temp=temp.next;
	  }	
	   return false;
	}
	void goTo(int pos){
		if(pos<0){
			System.out.println("Line no doesn't exist. Enter valid line no");
			return ;
		}
		int c=0;
		currentLine.data=delete(currentLine.data,search(currentLine.data));
		pNode temp=head;
		while(temp!=null){
			if(pos==c){
				break;
			}
			c++;
			temp=temp.next;
		}
		if(temp==null){
			System.out.println("Line no doesn't exist. Enter valid line no");
		}
		else{
			currentLine=temp;
			currentLine.data=insertCursor(currentLine.data,getLength(currentLine.data),0);
			displayText();
		}
	}
	public static void main(String[] args) {
		
		TextEditor editor=new TextEditor();

		scanner = new Scanner(System.in);
        char command;

        while (true) {
            System.out.print("Enter command (I: Insert, D: Delete, L: Left, R: Right, N: New Line, U: Up, B: Down, S: Search, G: GoTo): ");
            command = scanner.next().charAt(0);
            scanner.nextLine(); 
            
            switch (command) {	
                case 'I':			
                    System.out.print("Enter text to insert: ");			
                    String text = scanner.nextLine();		
                    editor.insert(text);		
                    break;		
                case 'D':
                    editor.deleteChar();
                    break;
                case 'L':
                    editor.moveLeft();
                    break;
                case 'R':
                    editor.moveRight();
                    break;
                case 'N':
                	editor.newLine();
                	break;
                case 'U':
                	editor.moveUp();
                	break;
                case 'B':
                	editor.moveDown();
                	break;
                case 'S':
                	System.out.print("Enter text to search: ");
                    String in = scanner.nextLine();
                    System.out.println("Word found : "+editor.searchWord(in));
                    break;
                case 'G':
                	System.out.print("Enter line no: ");
                    int line = scanner.nextInt();
                    editor.goTo(line);
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
	}

}