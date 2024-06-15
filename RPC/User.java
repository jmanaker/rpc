//© A+ Computer Science  -  www.apluscompsci.com

//Player class

package RPC;

import java.lang.ClassNotFoundException;
import java.io.IOException;

public class User extends Player
{
  private String name;
  public User()
  {
    this("");
  }
  User(Choices choice)
  {
    this("", choice);
  }
  public User(String name)
  {
    super();
    this.name = name;
  }
  User(String name, Choices choice)
  {
    super(choice);
    this.name = name;
  }
  public String toString()
  {
    return name + ", who chose " + choice;
  }
  public void setChoice(String choice) throws ClassNotFoundException, IOException
  {
    this.choice = Choices.fromString(choice);
  }
}