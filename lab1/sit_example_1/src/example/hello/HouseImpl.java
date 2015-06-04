/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hello;

/**
 *
 * @author Dina
 */
public class HouseImpl implements House{

    private int[][] field = new int[3][3];

    public HouseImpl() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                field[i][j] = 0;
    }
    
    
    
    @Override
    public void setFilled(int x, int y) {
        if (x >= 0 &&  x < 3 && y >= 0 &&  y < 3 )
            field[x][y] = 1;
    }
    
    
    @Override
    public String getField() {
        String result = "";
         for(int i = 0; i < 3; i++)
         {
            for(int j = 0; j < 3; j++)
                if (field[i][j] == 0)
                    result += "_|";
                else
                    result += "!|";
            result +="\n";
         }
         return result;
    }
    
    
}
