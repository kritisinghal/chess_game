package chess;
import java.util.*;
class Game
{
  static Board board = new Board();
  Game()
  {
	  // initialize board
	  board.bo[0][0].p1 = board.r[0];
	  board.bo[0][1].p1 = board.kn[0];
	  board.bo[0][2].p1 = board.b[0];
	  board.bo[0][3].p1 = board.k[0];
	  board.bo[0][4].p1 = board.q[0];
	  board.bo[0][5].p1 = board.b[1];
	  board.bo[0][6].p1 = board.kn[1];
	  board.bo[0][7].p1 = board.r[1];
	  for(int i=0;i<8;i++)
	  {
		 board.bo[1][i].p1 = board.pn[i];
	  }
	  
	  board.bo[7][0].p1 = board.r[2];
	  board.bo[7][1].p1 = board.kn[2];
	  board.bo[7][2].p1 = board.b[2];
	  board.bo[7][3].p1 = board.k[1];
	  board.bo[7][4].p1 = board.q[1];
	  board.bo[7][5].p1 = board.b[3];
	  board.bo[7][6].p1 = board.kn[3];
	  board.bo[7][7].p1 = board.r[3];
	  for(int i=0;i<8;i++)
	  {
		  board.bo[6][i].p1 = board.pn[i+8];
	  }
  }
  
  public static void main(String args[])
  {
	Game game = new Game();
    String color = "white";
	int xcw=-1,ycw=-1,xcb=-1,ycb=-1;
	System.out.println();
	game.board.display();
	boolean checkOpp = false;
	Scanner scan = new Scanner(System.in);
	while(true)                                   
	{ 
     try
	 {
	  if(color == "white")
	  {
		  
		System.out.println("PLAYER WHITE......."); 
		System.out.println("enter initial position");
		int xi = scan.nextInt();
		int yi = scan.nextInt();
		System.out.println();
		
		System.out.println("enter final position");
		int xf = scan.nextInt();
		int yf = scan.nextInt();
        System.out.println();
	
		if(xi>7 || yi>7 || xf>7 || yf>7 || xi<0 || yi<0 || xf<0 || yf<0)
		{
			System.out.println("invalid move as positions are not valid.");
		}
		
		else if((xi-xf)==0 && (yi-yf)==0)
		{
			System.out.println("invalid move as initial and final position are same.");
			System.out.println();
		}
		
		else
		{
		   boolean check = game.board.move(color,xi,yi,xf,yf);  
           System.out.println("Is the move valid for game....... "+check);
           System.out.println();		   
		   if(check)
		   {
			 Piece dead = board.bo[xf][yf].p1;
			 
			 boolean checker = game.board.update(color,xi,yi,xf,yf);
			 System.out.println("Can the board be updated....... "+checker);
			 
			 	
	       for(int i=0;i<8;i++)
	       {
		     for(int j=0;j<8;j++)
		     {
			   if(game.board.bo[i][j].p1 == board.k[0])            
			    {
				 xcw = i;
				 ycw = j;
			    }

               if(game.board.bo[i][j].p1 == board.k[1])
			    {
				 xcb = i;
				 ycb = j;
			    }			
		     }
	       }
	  
			 boolean checkCondition = game.board.checkPlayer(color,xi,yi,xcw,ycw);
			 System.out.println("Is there check on yourself....... "+checkCondition);
			 System.out.println();
			 
			 // REVERSING THE MOVE MADE.....
			 if(checkCondition && checker)
			 {
				board.bo[xi][yi].p1 = board.bo[xf][yf].p1;
                board.bo[xf][yf].p1 = dead;
                System.out.println("invalid move as it leads to check on king.");
				if(dead!=null)
                   dead.status = 0;				
			 }
			 
			 else if(checker)
			 {
			   System.out.println("valid move");
			   checkOpp = game.board.checkOpponent(color,xcb,ycb);
			   System.out.println("Is there check on opponent king....."+checkOpp);
			   color = "black";
			   System.out.println();
			 }
			 
			 else
			 {
			   System.out.println("invalid move as there is already a piece of same color.");
			   System.out.println();
			 }
		   }
		
		   else
		   {
			 System.out.println("invalid try as the move is not valid..");
			 System.out.println();
		   }
        }
		System.out.println();
		game.board.display();
	  }
	  
	 
	  else
	  {
		System.out.println("PLAYER BLACK........");
		System.out.println("enter initial position");
		int xi = scan.nextInt();
		int yi = scan.nextInt();
		System.out.println();
		
		System.out.println("enter final position");
		int xf = scan.nextInt();
		int yf = scan.nextInt();
		System.out.println();
		  
		if(xi>7 || yi>7 || xf>7 || yf>7 || xi<0 || yi<0 || xf<0 || yf<0)
		{
			System.out.println("invalid move as positions are not valid.");
		}
		
		else if((xi-xf)==0 && (yi-yf)==0)
		{
			System.out.println("invalid move as initial and final position are same.");
			System.out.println();
		}
		
		else
		{
		   boolean check = game.board.move(color,xi,yi,xf,yf);
		   System.out.println("Is the move valid for game...... "+check);
		   System.out.println();
		   if(check)
		   {
			 Piece dead = board.bo[xf][yf].p1;
			 
			 boolean checker = game.board.update(color,xi,yi,xf,yf);
			 System.out.println("Can the board be updated....... "+checker);
			 
			 for(int i=0;i<8;i++)
	         {
		      for(int j=0;j<8;j++)
		       {
			    if(game.board.bo[i][j].p1 == board.k[0])            
			     {
				  xcw = i;
				  ycw = j;
			     }

                if(game.board.bo[i][j].p1 == board.k[1])
			     {
				  xcb = i;
				  ycb = j;
			     }			
		       }
	         }
		   
			 boolean checkCondition = game.board.checkPlayer(color,xi,yi,xcb,ycb);
			 System.out.println("Is there check on yourself....... "+checkCondition);
			 
			 // REVERSING THE MOVE MADE.....
			 if(checkCondition && checker)
			 {
				board.bo[xi][yi].p1 = board.bo[xf][yf].p1;
                board.bo[xf][yf].p1 = dead;
                System.out.println("invalid move as it leads to check on king.");
				if(dead!=null)
                   dead.status = 0;				
			 }
			 
			 else if(checker)
			 { 
			   System.out.println("valid move");
			   checkOpp = game.board.checkOpponent(color,xcw,ycw);
			   System.out.println("Is there check on opponent king...."+checkOpp);
			   color = "white";
			   System.out.println();
			 }
			 
			 else
			 {
			   System.out.println("invalid move as there is already a piece of same color.");
			   System.out.println();
			 }
		   }
		
		   else
		   {
			 System.out.println("invalid try as the move is not valid..");
			 System.out.println();
		   }
			
        }
		System.out.println();
		game.board.display();
	  }
	  
	  if(board.k[0].status==-1 || board.k[1].status==-1)
		  break;
	 }
	 
	 catch(InputMismatchException e)
	 {
		 System.out.println("enter valid inputs");
		 System.out.println();
		 scan.next();
	 }
    }
    System.out.println("GAME OVER.....");	
  }
}