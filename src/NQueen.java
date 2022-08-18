import java.util.Arrays;

public class NQueen
{

  private int N;

  public NQueen(int N)
  {
    this.N = N;
  }

  public boolean isSafe(char mat[][], int r, int c)
  {
    for (int i = 0; i < r; i++)
    {
      if (mat[i][c] == 'Q') {
        return false;
      }
    }

    for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
    {
      if (mat[i][j] == 'Q') {
        return false;
      }
    }

    for (int i = r, j = c; i >= 0 && j < N; i--, j++)
    {
      if (mat[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  public void printSolution(char mat[][])
  {
    for (int i = 0; i < N; i++) {
      System.out.println(Arrays.toString(mat[i]).replaceAll(",", ""));
    }
    System.out.println();
  }

  public void nQueen(char mat[][], int r)
  {
    if (r == N)
    {
      printSolution(mat);
      return;
    }

    for (int i = 0; i < N; i++)
    {
      if (isSafe(mat, r, i))
      {
        mat[r][i] = 'Q';

        nQueen(mat, r + 1);

        mat[r][i] = '–';
      }
    }
  }

  public void print()
  {
    char[][] mat = new char[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(mat[i], '–');
    }

    nQueen(mat, 0);
  }
}