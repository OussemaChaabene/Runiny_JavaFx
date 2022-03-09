/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author MSI
 */
public interface IService<T>  {
    void insert(T t);
    List<T>readAll();
    boolean modifier(T t);
    boolean supprimer(T t);
}
