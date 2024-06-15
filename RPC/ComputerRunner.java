//© A+ Computer Science  -  www.apluscompsci.com

package RPC;

import static java.lang.System.*;

public class ComputerRunner
{
 public static void main(String[] args)
 {
   Player computer = new Player(), user;
   user = new Player(Choices.Rock);
   out.println(computer);
   out.println(computer.compareTo(user));
   user = new Player(Choices.Paper);
   out.println(computer.compareTo(user));
   user = new Player(Choices.Scissors);
   out.println(computer.compareTo(user));
 }
}





