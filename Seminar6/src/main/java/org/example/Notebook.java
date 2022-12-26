package org.example;

import java.util.Objects;
public class Notebook {
    /**
     * id ноутбука
     */
    private int id;
    /**
     * марка ноутбука
     */
    private String label;

    /**
     * размер оперативной памяти
     */
    private int ram;
    /**
     * размер жесткого диска
     */
    private int ssd;
    /**
     * название оперционной системы
     */
    private String os;
    /**
     * цвет ноутбука
     */
    private String color;

    public Notebook(int id, String label, int ram, int ssd, String os, String color) {
        this.id = id;
        this.label = label;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", ram=" + ram +
                ", ssd=" + ssd +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getRam() {
        return ram;
    }

    public int getSsd() {
        return ssd;
    }

    public String getOs() {
        return os;
    }
    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notebook notebook)) return false;
        return getId() == notebook.getId() && getRam() == notebook.getRam() && getSsd() == notebook.getSsd() &&
                Objects.equals(getLabel(), notebook.getLabel()) && Objects.equals(getOs(), notebook.getOs()) &&
                Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLabel(), getRam(), getSsd(), getOs(), getColor());
    }
}
