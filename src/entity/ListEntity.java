package entity;

import Util.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Entity
@Table(name = "list", schema = "product", catalog = "")
public class ListEntity {
    private int id;
    private String address;
    private int product;
    private String sendname;
    private int sendtel;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "product")
    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    @Basic
    @Column(name = "sendname")
    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    @Basic
    @Column(name = "sendtel")
    public int getSendtel() {
        return sendtel;
    }

    public void setSendtel(int sendtel) {
        this.sendtel = sendtel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListEntity that = (ListEntity) o;

        if (id != that.id) return false;
        if (product != that.product) return false;
        if (sendtel != that.sendtel) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (sendname != null ? !sendname.equals(that.sendname) : that.sendname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + product;
        result = 31 * result + (sendname != null ? sendname.hashCode() : 0);
        result = 31 * result + sendtel;
        return result;
    }
    public static void main(String[] args) throws IOException {
        Session sessions=null;
        try {

            sessions = HibernateUtils.getSession();
            sessions.beginTransaction();

            List<ListEntity> listEntities = (List<ListEntity>)sessions.createQuery("from ListEntity").list();
            sessions.getTransaction().commit();

        }catch(Exception e) {
            e.printStackTrace();
            sessions.getTransaction().rollback();
        }finally {
        }

    }
}
