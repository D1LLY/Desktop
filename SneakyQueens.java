// Dilly Jacques
// COP 3503, Fall 2022
// di115915

import java.lang.*;
import java.util.*;
import java.io.*;

public class SneakyQueens
{
      public static boolean allTheQueensAreSafe(ArrayList<String> coordinateStrings, int boardSize)
      {
          int diagonal_size=boardSize*2-1;
          int row,colum,mul_row;
          char col_str[];
          int rows[] = new int[boardSize];
          int columns[] = new int[boardSize];
          int l_diagonal[] = new int[diagonal_size];
          int r_diagonal[] = new int[diagonal_size];
          Stack<Character> colum_stack = new Stack<Character>();

          for (String col : coordinateStrings)
          {
              row = 0;
              mul_row = 1;
              col_str = col.toCharArray();

              for (char alpha : col_str)
              {
                  if (Character.isLetter(alpha) )
                      colum_stack.push(alpha);
                  else
                  {
                      row = row * mul_row + Character.getNumericValue(alpha);
                      mul_row = 10;
                  }
              }

              colum = SneakyQueens.parseFunc(colum_stack);
              row --;

              if (columns[colum] == 0)
                  columns[colum] = 1;
              else
                  return false;

              if (rows[row] == 0)
                  rows[row] = 1;
              else
                  return false;

                if (l_diagonal[row+colum+1] == 0)
                    l_diagonal[row+colum+1] = 1;
                else
                    return false;

              if (r_diagonal[row-colum+boardSize] == 0)
                  r_diagonal[row-colum+boardSize] = 1;
              else
                  return false;
          }
          return true;
      }

    public static int parseFunc(Stack<Character> coordinates)
    {
        int res = 0;
        int k = 1;
        while (!coordinates.empty())
        {
            res += ((int)coordinates.pop()-96)*k;
            k *= 26;
        }
        return --res;
    }

    public static double difficultyRating()
    {
        return 3.0;
    }

     public static double hoursSpent()
     {
         return 7.0;
     }
}
