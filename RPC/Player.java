//© A+ Computer Science  -  www.apluscompsci.com

//Computer class

package RPC;

import java.util.Random;

public class Player implements Comparable
{
  protected Choices choice;
  private Random rand = new Random();
  public Player()
  {
    this.ChooseAnew();
  }
  Player(Choices choice)
  {
    this.choice = choice;
  }
  public Choices Choice()
  {
    return choice;
  }
  public void ChooseAnew()
  {
    choice = Choices.values()[rand.nextInt(3)];
  }
  public int compareTo(Object obj)
  {
    return this.compareTo((Player)obj).ordinal() - 1;
  }
  public Outcome compareTo(Player p)
  {
    return Outcome.values()[(this.choice.ordinal() - p.choice.ordinal() + 4) % 3];
  }
  public String toString()
  {
    return "[Player {choice = " + choice + "}]";
  }
}