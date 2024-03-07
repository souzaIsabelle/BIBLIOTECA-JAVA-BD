/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ItemModel; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author Username
 */
public class ItemBancoDeDados {

    private String status;
    // por exemplo; ajustem os atriutos para receber um usuário que contenha o construtor do modelo
    // implementado na camada model...
    // O que está definido abaixo, ainda é o que fizemos na atividade da aula..
    
    public void inserirItemBD(ItemModel novoitem) {
        String sql = "INSERT INTO ITEM (status, dataLocacao, dataDevolucao) VALUES (?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBDBiblioteca().getNewConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoitem.getstatus());
            stmt.setString(2, novoitem.getdataLocacao());
            stmt.setString(3, novoitem.getdataDevolucao());     
            stmt.execute();
            System.out.println("REGISTRO REALIZADO COM SUCESSO!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR O REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");

            }

        }
    }
        
        
        public ArrayList<ItemModel> listarTodosItem() {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        ItemModel item = null;
        ArrayList<ItemModel> listaitems = null;
        
        String sql = "SELECT * FROM ROOT.ITEM";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaitems = new ArrayList<>();
                while (rs.next()) {
                    item = new ItemModel();
                    item.setstatus(rs.getString("status"));
                    item.setdataLocacao(rs.getString("dataLocacao"));
                    item.setdataDevolucao(rs.getString("dataDevolucao"));
                    listaitems.add(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR O REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }

        }
        System.out.println("Lista: " + listaitems);
        return listaitems;
        
    }
        
        public void alteraritemBD(ItemModel itemAjuste) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE ROOT.USUARIO SET status, dataLocacao, dataDevolucao";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, itemAjuste.getstatus());
            stmt.setString(2, itemAjuste.getdataLocacao());
            stmt.setString(3, itemAjuste.getdataDevolucao());
           
            stmt.execute();
            System.out.println("Alteração do registro realizada do sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR A ALTERAÇÃO DO REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }
        }
        
        public void excluirItem(String status) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM ROOT.ITEM WHERE status=?";

        try {
            conn = new ConexaoBDBiblioteca().getNewConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.execute();
            System.out.println("Exclusão realizada do sucesso");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERRO AO REALIZAR A EXCLUSÃO DO REGISTRO");
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR O STMT");
                ex.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();

                }

            } catch (Exception ex) {
                System.out.println("ERRO AO FINALIZAR A CONEXÃO COM O BD");
                ex.printStackTrace();
            }
        }

    }

 }
