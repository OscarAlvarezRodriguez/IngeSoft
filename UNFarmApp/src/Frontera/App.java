package Frontera;

public final class App {

    // SIEMPRE debe tener estos 3 atributos
    public FramePrincipal framePrincipal;
    private static App app; // Se crea el atributo de él mismo como un objeto

    // este es el constructor es privado
    // aqui se llaman la vista y el modelo
    private App() {
    }

    // este es el contructor del constructor 
    public static App getInstance() {
        // Revisa si ya está creado, si lo está entonces lo retorna	
        if (app == null) {
            app = new App();
        }
        return app;
    }

    private void run(String[] args) {
        framePrincipal = new FramePrincipal();
        framePrincipal.main(args);
    }

    public void ChangePanel(int n) {
        framePrincipal.ChangePanel(n);
    }

    public void setFramePrincipal(FramePrincipal frame) {
        this.framePrincipal = frame;
    }

    public static void main(String[] args) {
        App app = App.getInstance();
        app.run(args);
    }

}
