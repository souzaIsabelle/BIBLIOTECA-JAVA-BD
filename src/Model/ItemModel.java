/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ItemBancoDeDados;
import java.util.ArrayList;

/**
 *
 * @author Username
 */
public class ItemModel {

   
    private String status;
    private String dataLocacao;
    private String dataDevolucao;
   


    public ItemModel(String status, String dataLocacao, String dataDevolucao) {
        this.status = status;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

   
    public ItemModel(String status, String dataDevolucao) {
       this.status = status;
        this.dataDevolucao = dataDevolucao;
        
    }

    public ItemModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getdataLocacao() {
        return dataLocacao;
    }

    public void setdataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getdataDevolucao() {
        return dataDevolucao;
    }

    public void setdataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void cadastraritemDAO(ItemModel novoitem) {
        ItemBancoDeDados novoRegistro = new ItemBancoDeDados();
        novoRegistro.inserirItemBD(novoitem);
    }

    public ArrayList<ItemModel> listaritem() {
        return new ItemBancoDeDados().listarTodosItem();
    }

    public void alterarItem(ItemModel itemAjuste) {
        new ItemBancoDeDados().alteraritemBD(itemAjuste);
    }

    public void excluirItem(String status) {
        new ItemBancoDeDados().excluirItem(status);
    }

    public void alteraritem(ItemModel itemAjuste) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getstatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setstatus(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
