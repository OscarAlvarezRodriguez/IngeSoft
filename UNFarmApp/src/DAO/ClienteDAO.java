package DAO;

import Entidad.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class ClienteDAO {
    
    private ResultSet resultSet;
    private PreparedStatement statement;
    private final Conexion conexion =  new Conexion();
   
    private final String INSERT = "INSERT INTO cliente( cedulaCliente, nombre, apellido, telefono, direccionCliente, descripcionDireccion) VALUES(?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE cliente SET cedulaCliente = ?, nombre = ?, apellido= ?, telefono = ?, direccionCliente = ?, descripcionDireccion = ? WHERE cedulaCliente = ?";
    private final String DELETE = "DELETE FROM cliente WHERE cedulaCliente = ?";
    private final String GETONE = "SELECT * FROM cliente WHERE cedulaCliente = ?";
    private final String GETALL = "SELECT * FROM cliente";
    
    public boolean crear(Cliente cliente) {
        try {
            statement = conexion.prepareScript(INSERT);
            statement.setString(1, cliente.getCedulaCliente());
            statement.setString(2, cliente.getNombreCliente());
            statement.setString(3, cliente.getApellidoCliente());
            statement.setString(4, cliente.getTelefonoCliente());
            statement.setString(5, cliente.getDireccionCliente());
            statement.setString(6, cliente.getDescripcionDireccionCliente());
            if(statement.executeUpdate() == 0){
                throw new Exception("No se pudo crear el cliente");
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           if (statement != null){
               try{
                   statement.close();
               } catch (SQLException e){
                   
               }
           }
        }return true;
    }

    public boolean eliminar(Cliente cliente) {
        try {
            statement = conexion.prepareScript(DELETE);
            statement.setString(1, cliente.getCedulaCliente());
            if(statement.executeUpdate() == 0){
                throw new Exception("no se pudo eliminar al cliente porque no existe");
            }
           
        } catch (Exception e) {
           
        } finally {
           if(statement != null){
               try{
                   statement.close();
               }catch (SQLException e){
                   
               }
           }
        }return true;
    }

    public Cliente leer(String c) {
        Cliente cliente = null;
        try{
            statement = conexion.prepareScript(GETONE);
            statement.setString(1, c);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                cliente = convertir(resultSet);
            }
        } catch (SQLException e) {
        }finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch(SQLException e){
                    
                }
            }
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException e){
                    
                }
            }
        }return cliente;
    }
    
    private Cliente convertir(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        c.setApellidoCliente(rs.getString("Apellido"));
        c.setCedulaCliente(rs.getString("cedulaCliente"));
        c.setDescripcionDireccionCliente(rs.getString("descripcionDireccion"));
        c.setDireccionCliente(rs.getString("direccionCliente"));
        c.setNombreCliente(rs.getString("nombre"));
        c.setTelefonoCliente(rs.getString("telefono"));
        return c;  
    }
    
    public boolean leer(){
        boolean r = false;
        try{
            statement = conexion.prepareScript(GETALL);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                r = true;
            }
        }catch (SQLException e){
            
        }finally{
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e) {
                    
                }
            }
            
            if(statement != null){
                try {
                    statement.close();
                }catch (SQLException e) {
                    
                }
            }
        }return r;
    }

    public boolean actualizar(Cliente clin, String cedulaCliente) {
        try {
            statement = conexion.prepareScript(UPDATE);
            statement.setString(1, clin.getCedulaCliente());
            statement.setString(2, clin.getNombreCliente());
            statement.setString(3, clin.getApellidoCliente());
            statement.setString(4, clin.getTelefonoCliente());
            statement.setString(5, clin.getDireccionCliente());
            statement.setString(6, clin.getDescripcionDireccionCliente());
            statement.setString(7, cedulaCliente);
            if(statement.executeUpdate() == 0){
                throw new Exception("no se pudo actualizar el cliente");
            }
        }catch (Exception e){
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException e){
                    
                }
            }
        }return true;    
    }
    
}
