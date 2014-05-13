package com.sitenizinadi;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;

public final class DataModelSiralamasi<T> extends DataModel<T> {

    DataModel<T> dataModel;
    private Integer[] satirlar;

    DataModelSiralamasi(DataModel<T> dataModel) {
        this.dataModel = dataModel;
        satirlariAl();
    }
//-----------------------------

    public void satirlariAl() {
        int satirSayisi = dataModel.getRowCount();
        if (satirSayisi != -1) {
            this.satirlar = new Integer[satirSayisi];
            for (int i = 0; i < satirSayisi; ++i) {
                satirlar[i] = i;
            }
        }
    }
//----------------------------- 

    public void sirala(final Comparator<T> comparator) {
        Comparator<Integer> satirKarsilastirmasi = 
                                        new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                T o1 = getData(i1);
                T o2 = getData(i2);
                return comparator.compare(o1, o2);
            }
        };
        Arrays.sort(satirlar, satirKarsilastirmasi);
    }
//-----------------------------
    private T getData(int satir) {
        int originalSatirIndeksi = dataModel.getRowIndex();

        dataModel.setRowIndex(satir);
        T newRowData = dataModel.getRowData();
        dataModel.setRowIndex(originalSatirIndeksi);

        return newRowData;
    }
//-----------------------------
    @Override
    public void setRowIndex(int satirIndeksi) {

        if (0 <= satirIndeksi && satirIndeksi < satirlar.length) {
            dataModel.setRowIndex(satirlar[satirIndeksi]);
        } else {
            dataModel.setRowIndex(satirIndeksi);
        }
    }
//-----------------------------

    @Override
    public boolean isRowAvailable() {
        return dataModel.isRowAvailable();
    }

    @Override
    public int getRowCount() {
        return dataModel.getRowCount();
    }

    @Override
    public T getRowData() {
        return dataModel.getRowData();
    }

    @Override
    public int getRowIndex() {
        return dataModel.getRowIndex();
    }

    @Override
    public Object getWrappedData() {
        return dataModel.getWrappedData();
    }

    @Override
    public void setWrappedData(Object data) {

        dataModel.setWrappedData(data);
        satirlariAl();
    }
}