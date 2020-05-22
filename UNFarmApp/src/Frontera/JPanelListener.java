/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontera;

/**
 *
 * @author Oscar Alvarez
 */
public interface JPanelListener {

    public enum JpanelEvent {

        /*	si se añaden nuevas herramientas, hay que actualizar Mycanvas.compareTools
 * 	y cada uno de los toolchange (MenuManager, ToolbarManager)
         */
        LFramePrincipal(FramePrincipal.INTFramePrincipal),	//0
        LFronteraRegDrogueria(FramePrincipal.INTFronteraRegDrogueria),	//1
        LFronteraRegEmpleado(FramePrincipal.INTFronteraEmpleado),	//2
        LFronteraSplash(FramePrincipal.INTFronteraSplash);	//3
        
        private int Jpanel;

        JpanelEvent(int Jpanel) {
            this.Jpanel = Jpanel;
        }

        public int getJpanel() {
            return this.Jpanel;
        }
    }

    void JpanelChange (JpanelEvent E);
}
