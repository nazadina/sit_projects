/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dina
 */
public interface House  extends Remote{
    public void setFilled(int x, int y) throws RemoteException;;
    public String getField() throws RemoteException;
}
