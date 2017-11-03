package entity;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "product", catalog = "")
public class ProductEntity {
    private int id;
    private String name;
    private String type;
    private int money;
    private String color;
    private String efficiency;
    private double weight;
    private Double weight2;
    private Double maoweight;
    private Integer maoweight2;
    private double sizechang;
    private double sizekuan;
    private double sizegao;
    private Double size2Chang;
    private Integer size2Kuan;
    private Integer size2Gao;
    private double volume;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "efficiency")
    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Basic
    @Column(name = "weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "weight2")
    public Double getWeight2() {
        return weight2;
    }

    public void setWeight2(Double weight2) {
        this.weight2 = weight2;
    }

    @Basic
    @Column(name = "maoweight")
    public Double getMaoweight() {
        return maoweight;
    }

    public void setMaoweight(Double maoweight) {
        this.maoweight = maoweight;
    }

    @Basic
    @Column(name = "maoweight2")
    public Integer getMaoweight2() {
        return maoweight2;
    }

    public void setMaoweight2(Integer maoweight2) {
        this.maoweight2 = maoweight2;
    }

    @Basic
    @Column(name = "sizechang")
    public double getSizechang() {
        return sizechang;
    }

    public void setSizechang(double sizechang) {
        this.sizechang = sizechang;
    }

    @Basic
    @Column(name = "sizekuan")
    public double getSizekuan() {
        return sizekuan;
    }

    public void setSizekuan(double sizekuan) {
        this.sizekuan = sizekuan;
    }

    @Basic
    @Column(name = "sizegao")
    public double getSizegao() {
        return sizegao;
    }

    public void setSizegao(double sizegao) {
        this.sizegao = sizegao;
    }

    @Basic
    @Column(name = "size2chang")
    public Double getSize2Chang() {
        return size2Chang;
    }

    public void setSize2Chang(Double size2Chang) {
        this.size2Chang = size2Chang;
    }

    @Basic
    @Column(name = "size2kuan")
    public Integer getSize2Kuan() {
        return size2Kuan;
    }

    public void setSize2Kuan(Integer size2Kuan) {
        this.size2Kuan = size2Kuan;
    }

    @Basic
    @Column(name = "size2gao")
    public Integer getSize2Gao() {
        return size2Gao;
    }

    public void setSize2Gao(Integer size2Gao) {
        this.size2Gao = size2Gao;
    }

    @Basic
    @Column(name = "volume")
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (money != that.money) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.sizechang, sizechang) != 0) return false;
        if (Double.compare(that.sizekuan, sizekuan) != 0) return false;
        if (Double.compare(that.sizegao, sizegao) != 0) return false;
        if (Double.compare(that.volume, volume) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (efficiency != null ? !efficiency.equals(that.efficiency) : that.efficiency != null) return false;
        if (weight2 != null ? !weight2.equals(that.weight2) : that.weight2 != null) return false;
        if (maoweight != null ? !maoweight.equals(that.maoweight) : that.maoweight != null) return false;
        if (maoweight2 != null ? !maoweight2.equals(that.maoweight2) : that.maoweight2 != null) return false;
        if (size2Chang != null ? !size2Chang.equals(that.size2Chang) : that.size2Chang != null) return false;
        if (size2Kuan != null ? !size2Kuan.equals(that.size2Kuan) : that.size2Kuan != null) return false;
        if (size2Gao != null ? !size2Gao.equals(that.size2Gao) : that.size2Gao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + money;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (efficiency != null ? efficiency.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (weight2 != null ? weight2.hashCode() : 0);
        result = 31 * result + (maoweight != null ? maoweight.hashCode() : 0);
        result = 31 * result + (maoweight2 != null ? maoweight2.hashCode() : 0);
        temp = Double.doubleToLongBits(sizechang);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sizekuan);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sizegao);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (size2Chang != null ? size2Chang.hashCode() : 0);
        result = 31 * result + (size2Kuan != null ? size2Kuan.hashCode() : 0);
        result = 31 * result + (size2Gao != null ? size2Gao.hashCode() : 0);
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
