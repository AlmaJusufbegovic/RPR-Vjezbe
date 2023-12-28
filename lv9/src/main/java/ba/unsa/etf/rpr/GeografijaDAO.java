package ba.unsa.etf.rpr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private Connection con;
    private PreparedStatement glavniGrad, getDrzavu, deleteDrzavu, deleteGradoveZaDrzavu, findDrzavu, getGradove, addGrad, addDrzavu, setId, setIdDrzave, promijeniGrad, dajGrad;;

    public GeografijaDAO() throws SQLException {
    try {
        con = DriverManager.getConnection("jdbc:sqlite:baza_za_rpr_gradovi.db");
    } catch (SQLException e){
        e.printStackTrace();
    }
    try {
        glavniGrad=con.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id and drzava.glavni_grad=?  ");
    }catch (SQLException e){
        obnoviBazu();
        try {
            glavniGrad=con.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id and drzava.glavni_grad=?  ");
        }catch (SQLException ea){
            ea.printStackTrace();
        }
        try {
            getDrzavu=con.prepareStatement("SELECT * FROM drzava WHERE id=?");
            dajGrad=con.prepareStatement("SELECT * FROM grad WHEREE id=?");
            deleteGradoveZaDrzavu=con.prepareStatement("DELETE FROM grad WHERE drzava=?");
            deleteDrzavu= con.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            findDrzavu=con.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
            getGradove = con.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            setId= con.prepareStatement("SELECT Max(id)+1 FROM grad");
            addDrzavu=con.prepareStatement(("INSERT INTO drzava VALUES(?,?,?)"));
            addGrad=con.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
            setIdDrzave=con.prepareStatement("SELECT Max(id)+1 FROM grad");
            promijeniGrad=con.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=? WHERE id=?");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    }
    public static GeografijaDAO getInstance() throws SQLException{
        if(instance==null) instance=new GeografijaDAO();
        return instance;
    }

    public static void removeInstance(){
        instance.close();
        instance=null;
    }
    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Grad glavniGrad(String drzava){
        try {
            glavniGrad.setString(1,drzava);
            ResultSet rs =glavniGrad.executeQuery();
            if(!rs.next()) return null;
            return dajGradizRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Grad dajGradizRS(ResultSet rs) throws SQLException {
        Grad grad= new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3), 4 );
        grad.setDrzava(dajDrzavu(rs.getInt(4), grad));
        return grad;
    }
    private Drzava dajDrzavu(int id, Grad grad) {
        try {

            getDrzavu.setInt(1, id);
            ResultSet rs= getDrzavu.executeQuery();
            if (!rs.next()) return null;
            return dajDrzavuizRS(rs, grad);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private Grad dajGrad(int id) {
        try {

            dajGrad.setInt(1, id);
            ResultSet rs= dajGrad.executeQuery();
            if (!rs.next()) return null;
            return dajGradizRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Drzava dajDrzavuizRS(ResultSet rs, Grad grad) throws SQLException {
        return new Drzava(rs.getInt(1),rs.getString(2),rs.getInt(3));
    }

    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));

            String sqlUpit = "";
            while (ulaz.hasNext()) {
                String line = ulaz.nextLine();
                sqlUpit += line;
                if (sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement st = con.createStatement();
                        st.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void obrisiDrzavu(String nazivDrzave){
        try {
            findDrzavu.setString(1, nazivDrzave);
            ResultSet rs=findDrzavu.executeQuery();
            if (!rs.next()) return;
            Drzava drzava=dajDrzavuizRS(rs,null);

            deleteGradoveZaDrzavu.setInt(1, drzava.getId());
            deleteGradoveZaDrzavu.executeUpdate();

            deleteDrzavu.setInt(1,drzava.getId());
            deleteDrzavu.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> rezultat = new ArrayList<>();
        try (ResultSet rs = getGradove.executeQuery()) {
            while (rs.next()) {
                Grad grad = dajGradizRS(rs);
                rezultat.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }


    public void dodajGrad(Grad grad) {
        try {
            ResultSet rs = setId.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            addGrad.setInt(1, id);
            addGrad.setString(2, grad.getNaziv());
            addGrad.setInt(3, grad.getBroj_stanovnika());
            addGrad.setInt(4, grad.getDrzava());
            addGrad.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajDrzavu(Drzava drzava) {
        try {
            ResultSet rs = setIdDrzave.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            addDrzavu.setInt(1, id);
            addDrzavu.setString(2, drzava.getNaziv());
            addDrzavu.setInt(3, drzava.getGlavni_grad());
            addDrzavu.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void izmijeniGrad(Grad grad){
        try {

            promijeniGrad.setString(1, grad.getNaziv());
            promijeniGrad.setInt(2, grad.getBroj_stanovnika());
            promijeniGrad.setInt(3, grad.getDrzava());
            promijeniGrad.setInt(4, grad.getGrad_id());
            promijeniGrad.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Drzava nadjiDrzavu(String nazivDrzave){
        try {
            findDrzavu.setString(1, nazivDrzave);
            ResultSet rs=findDrzavu.executeQuery();
            if (!rs.next()) return null;
            return dajDrzavuizRS(rs, dajGrad(rs.getInt(3)));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    private void obnoviBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza_za_rpr_gradovi.sql"));

            String sqlUpit = "";
            while (ulaz.hasNext()) {
                String line = ulaz.nextLine();
                sqlUpit = sqlUpit + line;
                if (sqlUpit.charAt(sqlUpit.length() - 1) == ';') {
                    try {
                        Statement st = con.createStatement();
                        st.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
