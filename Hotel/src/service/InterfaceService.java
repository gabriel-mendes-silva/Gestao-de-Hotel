/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author GABRIEL
 */
public interface InterfaceService<T> {
    void criar(T t);
    T Carregar(int id);
    List<T> carregar(int id);
    void atualizar(T t);
    void apagar(T t);
}
