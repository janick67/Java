
public class Punkt {
public int x, y;

Punkt(int x, int y) {
	this.x = x;
	this.y = y;
}

Punkt(String str)
{
	String[] nowyparts = str.replace("|", ",").split(",");
	x = Integer.parseInt(nowyparts[0]);
	y = Integer.parseInt(nowyparts[1]);
}

void set_x(int x) {
	this.x = x;
}

void set_y(int y) {
	this.x = y;
}


int get_x() {
	return x;
}

int get_y() {
	return y;
}

String get_wsp() {
	return x+"|"+y;
}

double getodl(int ix,int iy) {
	double odl = Math.sqrt(Math.pow(ix-x,2)+Math.pow(iy-y,2));
	odl = Math.round(odl*10)/10;
	return odl;
}

double getodl(Punkt punkt) {
	double odl = Math.sqrt(Math.pow(punkt.get_x()-x,2)+Math.pow(punkt.get_y()-y,2));
	//System.out.println("x = "+x+" y = "+y+" pkt x ="+punkt.get_x()+" pkt y = "+punkt.get_y()+"odl "+odl );
	//System.out.println("razy 10 "+Math.round(odl*10)+" dziel przez 10 "+(double)Math.round(odl*10)/10);
	//odl = (double)Math.round(odl*1000)/1000;
	//System.out.println("x = "+x+" y = "+y+" pkt x ="+punkt.get_x()+" pkt y = "+punkt.get_y()+"odl "+odl );
	return odl;
}

}
