/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.DAO;

import java.util.List;

/**
 *
 * @author GABRIEL
 */
public interface Persistencia <T> {
    void inserir(T t);
    T buscar(int id);
    List<T> buscar(String atributo, String valor);
    void atualizar(T t);
    void deletar(T t);
}
