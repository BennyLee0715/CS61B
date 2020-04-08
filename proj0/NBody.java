public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int planetNum = in.readInt();
        double universeR = in.readDouble();
        return universeR;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int planetNum = in.readInt();
        double universeR = in.readDouble();
        Planet[] planets = new Planet[planetNum];
        for (int i = 0; i < planetNum; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, mass,imgFileName);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double universeR = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-universeR, universeR);
//        StdDraw.clear();
//        StdDraw.picture(0, 0, "images/starfield.jpg");
//        int planetNum = planets.length;
//        for (int i = 0; i < planetNum; i++){
//            planets[i].draw();
//    }
//        for (Planet p : planets){
//            p.draw();
//      }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        for (time = 0; time < T; time += dt){
            double[] xForce = new double[planets.length];
            double[] yForce = new double[planets.length];
            for (int i = 0; i < planets.length; i++){
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++){
                planets[i].update(dt, xForce[i], yForce[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(2);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universeR);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}

