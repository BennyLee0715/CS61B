public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	String imgFileName;
	public double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Initialize an identical Planet object (i.e. a copy).*/
	public Planet(Planet p) {
		p.xxPos = xxPos;
		p.yyPos = yyPos;
		p.xxVel = xxVel;
		p.yyVel = yyVel;
		p.mass = mass;
		p.imgFileName = imgFileName;
	}

	public double calcDistance(Planet target) {
		double dx = target.xxPos - this.xxPos;
		double dy = target.yyPos - this.yyPos;
		double r = Math.sqrt(dx*dx + dy*dy);
		return r;
	}

	public double calcForceExertedBy(Planet target) {
		double exertedForce = G * target.mass * this.mass / (calcDistance(target) * calcDistance(target));
		return exertedForce;
	}

	public double calcForceExertedByX(Planet target){
		double exertedForceX = calcForceExertedBy(target) * (target.xxPos - this.xxPos) / calcDistance(target);
		return exertedForceX;
	}

	public double calcForceExertedByY(Planet target){
		double exertedForceY = calcForceExertedBy(target) * (target.yyPos - this.yyPos) / calcDistance(target);
		return exertedForceY;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		int Planets_num = allPlanets.length;
		double NetForceExertedByX = 0;
		for (int i =0; i < Planets_num; i++){
			if (allPlanets[i] != this){
				NetForceExertedByX = NetForceExertedByX + this.calcForceExertedByX(allPlanets[i]);
			}
		}
		return NetForceExertedByX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		int Planets_num = allPlanets.length;
		double NetForceExertedByY = 0;
		for (int i =0; i < Planets_num; i++){
			if (allPlanets[i] != this){
				NetForceExertedByY = NetForceExertedByY + this.calcForceExertedByY(allPlanets[i]);
			}
		}
		return NetForceExertedByY;
	}

	public void update(double dt, double fX, double fY){
		double aNetX = fX / this.mass;
		double aNetY = fY / this.mass;
		this.xxVel = this.xxVel + dt * aNetX;
		this.yyVel = this.yyVel + dt * aNetY;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
		}
}

