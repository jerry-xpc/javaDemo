package com.java.javaSE.proxy;

public class WangPo implements KindWomen{
    private KindWomen kindWomen;

    public WangPo(){
        this.kindWomen = new PanJinLian();
    }

    public WangPo(KindWomen kindWomen){
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWithMen() {
        this.kindWomen.makeEyesWithMen();
    }

    @Override
    public void playWithMen() {
        this.kindWomen.playWithMen();
    }
}
