package com.dh.streaming.componentes;

public class Cliente {
    private int ip01;
    private int ip02;
    private int ip03;
    private int ip04;

    public Cliente(int ip01, int ip02, int ip03, int ip04) {
        if (ip01 >= 0 && ip01 < 256) {
            this.ip01 = ip01;
        } else {
            this.ip01 = 255;
        }
        if (ip02 >= 0 && ip02 < 256) {
            this.ip02 = ip02;
        } else {
            this.ip02 = 255;
        }
        if (ip03 >= 0 && ip03 < 256) {
            this.ip03 = ip03;
        } else {
            this.ip03 = 255;
        }
        if (ip04 >= 0 && ip04 < 256) {
            this.ip04 = ip04;
        } else {
            this.ip04 = 255;
        }
    }

    public int getIp01() {
        return ip01;
    }

    public void setIp01(int ip01) {
        if (ip01 >= 0 && ip01 < 256) {
            this.ip01 = ip01;
        } else {
            System.out.println("Valor inválido.");
        }
    }
}
