package RPC;

import java.io.*;
import biz.Base64Coder;

public enum Choices implements Serializable
{
  Rock, Paper, Scissors;
  
  public static String toString(Choices choice) throws IOException
  {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ObjectOutputStream writer = null;
    try
    {
      writer = new ObjectOutputStream(output);
      writer.writeObject(choice);
      return new String(Base64Coder.encode(output.toByteArray()));
    }
    finally
    {
      if(writer != null)
      {
        writer.close();
      }
    }
  }
  public static Choices fromString(String choice) throws ClassNotFoundException, IOException
  {
    ObjectInputStream reader = null;
    Choices o = null;
    try
    {
      reader = new ObjectInputStream(new ByteArrayInputStream(Base64Coder.decode(choice)));
      o = (Choices)reader.readObject();
    }
    finally
    {
      if(reader != null)
      {
        reader.close();
      }
    }
    return o;
  }
}