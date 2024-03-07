/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ItemModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Username
 */
public class ItemController {
    
    public void ItemController( String status, String dataLocacao, String dataDevolucao) {

        if ((status != null && status.length() > 0)
                && (dataLocacao != null && dataLocacao.length() > 0)
                && (dataDevolucao != null && dataDevolucao.length() > 0)
                )
               {

          ItemModel novoitem = new ItemModel(status, dataLocacao, dataDevolucao);

            novoitem.cadastraritemDAO(novoitem);

        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");

        }

    }

    public ArrayList<ItemModel> ItemController() {
        ItemModel item = new ItemModel();
        return item.listaritem();

    }

    public void alteraritem(String status, String dataLocacao, String dataDevolucao) {
         if ((status != null && status.length() > 0)
                && (dataLocacao != null && dataLocacao.length() > 0)
                && (dataDevolucao != null && dataDevolucao.length() > 0)
                )
               {

            ItemModel itemAjuste = new ItemModel(status, dataLocacao, dataDevolucao);
           itemAjuste.alteraritem(itemAjuste);
        }
    }

    public void excluirItem(String status) {
        ItemModel nomeitem = new ItemModel();
        nomeitem.excluirItem(status);

    }
}


