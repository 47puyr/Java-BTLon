
package POJO;

/**
 *
 * @author tungk
 */
public class ChiTietChuongTrinhGiamGiaPOJO {
    private String MaGG;
    private double percent;
    private String MaSach;

    public ChiTietChuongTrinhGiamGiaPOJO(String MaGG, double percent, String MaSach) {
        this.MaGG = MaGG;
        this.percent = percent;
        this.MaSach = MaSach;
    }

    public ChiTietChuongTrinhGiamGiaPOJO() { //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaGG() {
        return MaGG;
    }

    public void setMaGG(String MaGG) {
        this.MaGG = MaGG;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }
    
    
}
