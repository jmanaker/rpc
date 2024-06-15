//© A+ Computer Science  -  www.apluscompsci.com

//Rock / Paper / Scissors

package RPC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.lang.Thread;
import static biz.Base64Coder.*;
import static javax.swing.JOptionPane.*;
import static RPC.Choices.*;
import static RPC.Outcome.*;

public class RockPaperScissorsRunner extends JFrame implements ActionListener
{
  private static final int WIDTH = 400, HEIGHT = 200;
  //this variable is the area to which all text is written
  private JTextArea text;
  private final int tWidth, tHeight;
  //these are the buttons that can be clicked
  private JButton rock, paper, scissors, yes, no;
  //use these variables to keep track of the players
  private User player;
  private Player computer;
  //use these variables to keep track of the score
  private int playerWinCount, computerWinCount;
  private Throwable error;
  private JPanel top, bot;
  
  private class Continue implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      bot.remove(no);
      bot.remove(yes);
      bot.add(rock);
      bot.add(paper);
      bot.add(scissors);
      bot.repaint();
      if(!e.getActionCommand().equals("yes"))
      {
        System.exit(0);
      }
    }
  }
  
  private Continue extension;
  
  public RockPaperScissorsRunner()
  {
    super("RockPaperScissors Runner");
    setSize(WIDTH, HEIGHT);
    player = new User("dude");
    computer = new Player();
    JPanel main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
    top = new JPanel();
    bot = new JPanel();
    top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
    text = new JTextArea();
    text.setText("WELCOME TO ROCK-PAPER-SCISSORS!!!\n\n");
    tWidth = text.getWidth();
    tHeight = text.getHeight();
    extension = this.new Continue();
    yes = new JButton("yes");
    yes.addActionListener(extension);
    yes.setActionCommand("yes");
    no = new JButton("no");
    no.addActionListener(extension);
    no.setActionCommand("no");
    try
    {
      reTagButtons(null);
    }
    catch(IOException e)
    {
      prep(e);
    }
//add all three buttons to the bottom panel
    bot.add(rock);
    bot.add(paper);
    bot.add(scissors);
//add the text to the top panel
    top.add(text);
//add both panels to the main panel
    main.add(top);
    main.add(bot);
//add the main panel to the frame
    this.getContentPane().add(main);
  }
  public void actionPerformed(ActionEvent e)
  {
    try
    {
//get the String value from the button pressed
      player.setChoice(e.getActionCommand());
    }
    catch(ClassNotFoundException error)
    {
      prep(error);
    }
    catch(IOException error)
    {
      prep(error);
    }
    text.append("You chose " + player.Choice().toString() + SLS);
    text.append("The computer chose....");
    computer.ChooseAnew();
    try
    {
      Thread.sleep(3000);
    }
    catch(InterruptedException error)
    {
      showMessageDialog(null, "The computer is thinking!", "Hmmmm...", WARNING_MESSAGE);
    }
    text.append(computer.Choice().toString() + SLS);
    Outcome end = computer.compareTo(player);
    if(end != Tie)
    {
      switch(end)
      {
        case Win:
          text.append("You win!" + SLS);
          break;
        case Lose:
          text.append("Sorry, you lose." + SLS);
          break;
      }
      text.append("Play again?" + SLS);
      swap();
    }
    else
    {
      text.append("Tie! Pick again" + SLS);
    }
  }
  private void prep(Throwable error)
  {
    try
    {
      reTagButtons(error);
    }
    catch(Throwable e)
    {
      prep(e);
    }
  }
  private void reTagButtons(Throwable error) throws IOException
  {
    if(this.error != null)
    {
      int result = showConfirmDialog(null, "We seem to be experiencing persistent trouble associating commands with executable code.  Do you want to " +
                                     "see more information?", "Button hookup error", YES_NO_OPTION, ERROR_MESSAGE);
      if(result == YES_OPTION)
      {
        showMessageDialog(null, "The initial exception: " + this.error.getMessage() + SLS + "The new exception: " + error.getMessage(), "Error data", 
                          ERROR_MESSAGE);
      }
      System.exit(1);
    }
    this.error = error;
    rock = new JButton("Rock");
    rock.addActionListener(this);
    rock.setActionCommand(Rock.toString());
//instantiate a new JButton and refer paper to it
    paper = new JButton("Paper");
    paper.addActionListener(this);
    paper.setActionCommand(Paper.toString());
//instantiate a new JButton and refer scissors to it
    scissors = new JButton("Scissors");
    scissors.addActionListener(this);
    scissors.setActionCommand(Scissors.toString());
  }
  private void swap()
  {
    bot.remove(rock);
    bot.remove(paper);
    bot.remove(scissors);
    bot.add(yes);
    bot.add(no);
    bot.repaint();
  }
  public void Show()
  {
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public static void main(String args[])
  {
    new RockPaperScissorsRunner().Show();
  }
}