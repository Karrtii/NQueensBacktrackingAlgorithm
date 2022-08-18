import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NQueenTest
{
  NQueen queen;

  @BeforeEach void setUp()
  {
    queen = new NQueen(4);
  }

  @Test
  public void isSafeTrue()
  {
    char mat[][] = {{'-', '-', '-', '-'},
                    {'-','-','-','Q'},
                    {'Q','-','-','-'},
                    {'-','-','Q','-'}};

    assertEquals(true, queen.isSafe(mat, 0,1));
  }

  @Test
  public void isSafeFalse()
  {
    char mat[][] = {{'-', '-', '-', '-'},
        {'-','-','-','Q'},
        {'Q','-','-','-'},
        {'-','-','Q','-'}};

    assertEquals(false, queen.isSafe(mat, 1,3));
  }

  @Test
  public void printSolutionTrue()
  {
    char mat[][] = {{'-', '-', '-', '-'},
        {'-','-','-','Q'},
        {'Q','-','-','-'},
        {'-','-','Q','-'}};

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    queen.printSolution(mat);

    String expectedOutput = "[- - - -]\n" + "[- - - Q]\n" + "[Q - - -]\n"
        + "[- - Q -]\n" + "\n";

    assertEquals(expectedOutput.trim().replaceAll("\n", "").replaceAll("\r", ""),
        outContent.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
  }

  @Test
  public void printSolutionFalse()
  {
    char mat[][] = {{'Q', '-', '-', '-'},
        {'-','-','-','Q'},
        {'Q','-','-','-'},
        {'-','-','Q','-'}};

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    queen.printSolution(mat);

    String expectedOutput = "[- - - -]\n" + "[- - - Q]\n" + "[Q - - -]\n"
        + "[- - Q -]\n" + "\n";

    assertNotEquals(expectedOutput.trim().replaceAll("\n", "").replaceAll("\r", ""),
        outContent.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
  }

  @Test
  public void nQueenTest()
  {
    char mat[][] = {{'-', '-', '-', '-'},
        {'-','-','-','-'},
        {'-','-','-','-'},
        {'-','-','-','-'}};

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    queen.nQueen(mat, 0);

    queen.printSolution(mat);

    String expectedOutput = "[– Q - -]\n" + "[- - – Q]\n" + "[Q – - -]\n"
        + "[- - Q -]\n" + "\n" + "[– – Q -]\n" + "[Q - – –]\n" + "[– – - Q]\n"
        + "[- Q – -]\n" + "\n" + "[– – – –]\n" + "[– – – –]\n" + "[– – – –]\n"
        + "[- – – -]\n" + "\n";

    assertEquals(expectedOutput.trim().replaceAll("\n", "").replaceAll("\r", ""),
        outContent.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
  }

  @Test
  public void printTest()
  {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    queen.print();

    String expectedOutput = "[– Q – –]\n" + "[– – – Q]\n" + "[Q – – –]\n"
        + "[– – Q –]\n" + "\n" + "[– – Q –]\n" + "[Q – – –]\n" + "[– – – Q]\n"
        + "[– Q – –]\n" + "\n";

    assertEquals(expectedOutput.trim().replaceAll("\n", "").replaceAll("\r", ""),
        outContent.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
  }

}