package DAO;

import Entidad.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
    private ResultSet resultSet;
    private PreparedStatement statement;
    private final Conexion conexion = new Conexion();
    // se declaran los Sreings con las sentencias SQL que vamos a ejecutar
    private final String INSERT = "INSERT INTO empleado( cedulaEmpleado, nombreEmpleado, telefono, direccionEmpleado, apellidoEmpleado, contrasenia, correo) VALUES(?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE empleado SET cedulaEmpleado = ?, nombreEmpleado = ?, telefono = ?, telefono = ?, direccionEmpleado = ?, apellidoEmpleado = ? ,contrasenia = ?, correo=? WHERE cedulaEmpleado = ?";
    private final String DELETE = "DELETE FROM empleado WHERE cedulaEmpleado = ?";
    private final String GETONE = "SELECT * FROM empleado WHERE cedulaEmpleado = ?";
    private final String GETALL = "SELECT * FROM empleado";

    public boolean crear(Empleado object) {
        try {
            statement = conexion.prepareScript(INSERT);
            statement.setString(1, object.getCedulaEmpleado());
            statement.setString(2, object.getNombreEmpleado());
            statement.setString(3, object.getTelefonoEmpleado());
            statement.setString(4, object.getDireccionEmpleado());
            statement.setString(5, object.getApellidoEmpleado());
            statement.setString(6, object.getContraseniaEmpleado());
            statement.setString(7, object.getCorreoEmpleado());
            if (statement.executeUpdate() == 0) {
                throw new Exception("No se pudo crear el empleado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return true;
    }

    public boolean eliminar(Empleado empleado) {
        try {
            statement = conexion.prepareScript(DELETE);
            statement.setString(1, empleado.getCedulaEmpleado());
            if (statement.executeUpdate() == 0) {
                throw new Exception("no se pudo eliminar el empleado");
            }

        } catch (Exception e) {
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        return true;
    }

    public Empleado leer(Empleado par) {
        Empleado empleado = null;
        try {
            statement = conexion.prepareScript(GETONE);
            statement.setString(1, par.getCedulaEmpleado());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empleado = convertir(resultSet);
            }
        } catch (SQLException e) {
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return empleado;
    }

    public boolean leerex(Empleado par) {
        Boolean b = false;
        try {
            statement = conexion.prepareScript(GETONE);
            statement.setString(1,par.getCedulaEmpleado());
            resultSet= statement.executeQuery();
            if (resultSet.next()) {
                b=true;
            }
        } catch (SQLException e) {
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return b;
    }
    public boolean actualizar(Empleado object, Empleado nuevoObjeto) {
        try {
            statement = conexion.prepareScript(UPDATE);
            statement.setString(1, nuevoObjeto.getCedulaEmpleado());
            statement.setString(2, nuevoObjeto.getNombreEmpleado());
            statement.setString(3, nuevoObjeto.getTelefonoEmpleado());
            statement.setString(4, nuevoObjeto.getDireccionEmpleado());
            statement.setString(5, nuevoObjeto.getApellidoEmpleado());
            statement.setString(6, nuevoObjeto.getContraseniaEmpleado());
            statement.setString(7, nuevoObjeto.getCorreoEmpleado());
            statement.setString(8, object.getCedulaEmpleado());
            if (statement.executeUpdate() == 0) {
                throw new Exception("no se pudo actualizar el empleado");
            }

        } catch (Exception e) {
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }

            }
        }
        return true;

    }
    private Empleado convertir(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
        empleado.setCedulaEmpleado(rs.getString("cedulaEmpleado"));
        empleado.setContraseniaEmpleado(rs.getString("contrasenia"));
        empleado.setCorreoEmpleado(rs.getString("correo"));
        empleado.setDireccionEmpleado(rs.getString("direccionEmpleado"));
        empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
        empleado.setTelefonoEmpleado(rs.getString("telefono"));
        return empleado;
    }
}
