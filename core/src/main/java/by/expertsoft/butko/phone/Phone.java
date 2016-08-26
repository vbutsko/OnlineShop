package by.expertsoft.butko.phone;

import java.math.BigDecimal;

/**
 * Created by wladek on 09.08.16.
 */
public class Phone
{
    private int id;
    private String name;

    // BigDecimal has higher precision than double
    private BigDecimal price;
    private Manufacturer manufacturer;

    public Phone(){

    }

    public Phone(int id, String name, BigDecimal cost, Manufacturer manufacturer){
        this.id = id;
        this.name = name;
        this.price = cost;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
