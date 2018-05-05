/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PerguntaDAO {
    
    private static String tabela = "original";
    
    public void insert(Pergunta p){
    
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("INSERT INTO "+tabela+"(DISCIPLINA, ASSUNTO, DESCRICAO, IMAGEMENUNCIADO, IMAGEMRESPOSTA) VALUES(?,?,?,?,?)");
            stmt.setString(1, p.getDisciplina());
            stmt.setString(2, p.getAssunto());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getImagemEnunciado());
            stmt.setString(5, p.getImagemResposta());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        ConnectionFactory.closeConnection(conexao, stmt);
        
    }
    
    public List<Pergunta> read(){
    
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pergunta> perguntas = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM "+tabela);
            rs = stmt.executeQuery();
            int count = 1;
            
            while(rs.next()){
                Pergunta p = new Pergunta();
                
                p.set_Id(rs.getInt("id"));
                p.setId(count);
                p.setDisciplina(rs.getString("disciplina"));
                p.setAssunto(rs.getString("assunto"));
                p.setDescricao(rs.getString("descricao"));
                p.setImagemEnunciado(rs.getString("imagemenunciado"));
                p.setImagemResposta(rs.getString("imagemresposta"));
                
                perguntas.add(p);
                count++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        ConnectionFactory.closeConnection(conexao, stmt, rs);
        
        return perguntas;
    }
    
    public void update(Pergunta p){
    
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("UPDATE "+tabela+" SET DISCIPLINA=?, ASSUNTO=?, DESCRICAO=?, IMAGEMENUNCIADO=?, IMAGEMRESPOSTA=?;");
            stmt.setString(1, p.getDisciplina());
            stmt.setString(2, p.getAssunto());
            stmt.setString(3, p.getDescricao());
            stmt.setString(4, p.getImagemEnunciado());
            stmt.setString(5, p.getImagemResposta());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        ConnectionFactory.closeConnection(conexao, stmt);
        
    }
    
    public void remove(Pergunta p){
    
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conexao.prepareStatement("DELETE FROM "+tabela+" WHERE id=?");
            stmt.setInt(1, p.get_Id());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        ConnectionFactory.closeConnection(conexao, stmt);
        
    }
    

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }
    
   
    
}
