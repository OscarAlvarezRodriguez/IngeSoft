package DAO;

import Entidad.Drogueria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrogueriaDAO {

    private ResultSet resultSet;
    private PreparedStatement statement;
    private final Conexion conexion = new Conexion();
    // se declaran los Sreings con las sentencias SQL que vamos a ejecutar
    private final String INSERT = "INSERT INTO drogueria( nitDrogueria, nombreDrogueria, direccionDrogueria, telefono, email, representanteLegal) VALUES(?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE drogueria SET nitDrogueria = ?, nombreDrogueria = ?, direccionDrogueria = ?, telefono = ?, email = ?, representanteLegal = ? WHERE nit_Drogueria = ?";
    private final String DELETE = "DELETE FROM drogueria WHERE nitDrogueria = ?";
    private final String GETONE = "SELECT * FROM drogueria WHERE nitDrogueria = ?";
    private final String GETALL = "SELECT * FROM drogueria";

    public boolean crear(Drogueria d) {
        try {
            // se carga el PreparedStatement con la coneccion desde la clase Conexion
            //y el comando que queremos ejecutar
            statement = conexion.prepareScript(INSERT);
            //se le pasan los valores "?" de la sentencia de SQL,
            //el primer "?" que aparece de izquierda a derecha tiene el valor de 1
            //en la funcion set del PreparedStatement 
            statement.setString(1, d.getNitDrogueria());
            statement.setString(2, d.getNombreDrogueria());
            statement.setString(3, d.getDireccionDrogueria());
            statement.setString(4, d.getTelefonoDrogueria());
            statement.setString(5, d.getEmailDrogueria());
            statement.setString(6, d.getRepresentanteLegalDrogueria());
            // se executa el PreparedStatement con lo valores cargados
            // si es igual a 0 es por que ocurrio un error o no se ejecuto el PreparedStatement
            if (statement.executeUpdate() == 0) {
                throw new Exception("No se pudo crear la drogueria");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // se verifica que el PreparedStatement no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return true;
    }

    public boolean eliminar(Drogueria d) {
        try {
            // se carga el PreparedStatement con la coneccion desde la clase Conexion
            //y el comando que queremos ejecutar
            statement = conexion.prepareScript(DELETE);
            //se le pasan los valores "?" de la sentencia de SQL,
            //el primer "?" que aparece de izquierda a derecha tiene el valor de 1
            //en la funcion set del PreparedStatement 
            statement.setString(1, d.getNitDrogueria());
            // se executa el PreparedStatement con lo valores cargados
            // si es igual a 0 es por que ocurrio un error o no se ejecuto el PreparedStatement
            if (statement.executeUpdate() == 0) {
                throw new Exception("no se pudo eliminar la drogueria");
            }

        } catch (Exception e) {
        } finally {
            // se verifica que el PreparedStatement no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return true;
    }

    public Drogueria leer(Drogueria d) {
        Drogueria drogueria = null;
        try {
            // se carga el PreparedStatement con la coneccion desde la clase Conexion
            //y el comando que queremos ejecutar
            statement = conexion.prepareScript(GETONE);
            //se le pasan los valores "?" de la sentencia de SQL,
            //el primer "?" que aparece de izquierda a derecha tiene el valor de 1
            //en la funcion set del PreparedStatement 
            statement.setString(1, d.getNitDrogueria());
            // se ejecuta el PreparedStatement y se convierte en un ResultSet
            resultSet = statement.executeQuery();
            // se utiliza la funcion convertir()
            //para convertir el ResultSet en una drogueria
            if (resultSet.next()) {
                drogueria = convertir(resultSet);
            }
        } catch (SQLException e) {
        } finally {
            // se verifica que el ResultSet no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            // se verifica que el PreparedStatement no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return drogueria;
    }

    public boolean leer() {
        boolean b = false;
        try {
            // se carga el PreparedStatement con la coneccion desde la clase Conexion
            //y el comando que queremos ejecutar
            statement = conexion.prepareScript(GETALL);
            // se ejecuta el PreparedStatement y se convierte en un ResultSet
            resultSet = statement.executeQuery();
            //debido a que queremos saber si existe algun dato en la base de datos
            //para poder decidir que pantalla mostar
            //se analiza si hay un dato en la base de datos
            // si es asi se retorna verdadero 
            if (resultSet.next()) {
                b = true;
            }

        } catch (SQLException e) {
        } finally {
            // se verifica que el ResultSet no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            // se verifica que el PreparedStatement no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return b;
    }

    public boolean actualizar(Drogueria viejo, Drogueria nuevo) {
        try {
            // se carga el PreparedStatement con la coneccion desde la clase Conexion
            //y el comando que queremos ejecutar
            statement = conexion.prepareScript(UPDATE);
            //se le pasan los valores "?" de la sentencia de SQL,
            //el primer "?" que aparece de izquierda a derecha tiene el valor de 1
            //en la funcion set del PreparedStatement 
            statement.setString(1, nuevo.getNitDrogueria());
            statement.setString(2, nuevo.getNombreDrogueria());
            statement.setString(3, nuevo.getDireccionDrogueria());
            statement.setString(4, nuevo.getTelefonoDrogueria());
            statement.setString(5, nuevo.getEmailDrogueria());
            statement.setString(6, nuevo.getRepresentanteLegalDrogueria());
            statement.setString(7, viejo.getNitDrogueria());
            // se executa el PreparedStatement con lo valores cargados
            // si es igual a 0 es por que ocurrio un error o no se ejecuto el PreparedStatement
            if (statement.executeUpdate() == 0) {
                throw new Exception("no se pudo actualizar la drogueria");
            }

        } catch (Exception e) {
        } finally {
            // se verifica que el PreparedStatement no sea nulo para luego cerrarlo
            // y ahorrar espacio de memoria
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return true;
    }

    private Drogueria convertir(ResultSet rs) throws SQLException {
        //convierte el resulset (fila en una base de datos) en un objeto
        Drogueria d = new Drogueria();
        d.setDireccionDrogueria(rs.getString("direccion__Drogueria"));
        d.setEmailDrogueria(rs.getString("email"));
        d.setNitDrogueria(rs.getString("nit_Drogueria"));
        d.setNombreDrogueria(rs.getString("nombre_Drogueria"));
        d.setRepresentanteLegalDrogueria(rs.getString("representante_Legal"));
        d.setTelefonoDrogueria(rs.getString("telefono"));
        return d;
    }
}
