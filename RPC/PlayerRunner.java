//© A+ Computer Science  -  www.apluscompsci.com

//Player Runner

package RPC;

public class PlayerRunner
{
 public static void main(String[] args)
 {
  Player s = new User("Michael Jackson", Choices.Rock);

  System.out.println(s.Choice());   //outs rock
  //call the getName() method      //outs Michael Jackson
  System.out.println(s);        //outs Michael Jackson rock
  
  //set the choice to paper
  System.out.println(s);        //outs Michael Jackson paper 
  
  //instantiate a new Player named jb named Jim Bob that chose scissors
  //print out Jim Bob 
  s = new User("Jim Bob", Choices.Scissors);
 }
}





