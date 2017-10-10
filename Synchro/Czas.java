import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Czas {

Calendar calendar = Calendar.getInstance();



int error = 0; //1 - parse
//ustawianie
Czas(String str){
set(str);
}

Czas(Date data){	
		calendar.setTime(data);
}

void set(Calendar calen) {
	calendar = calen;
}

int set(String str) {
	Date dateStr = new Date();
	dateStr = parse_date(str);
	if (error == 1) { System.out.println("B³¹d podczas parsowania daty");
	return 1;}
	if (error == 2) { return 1;}
	else {
		calendar.setTime(dateStr);
		return 0;
	}
}

Calendar get() {
return calendar;
}

private Date parse_date(String str) {
	
	try{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss::SSS");
		return formatter.parse(str);
		}catch(ParseException e) {}
	try{
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return formatter.parse(str);
		}catch(ParseException e) {}
	try{
	    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss::SSS");
	    return formatter.parse(str);
		}catch(ParseException e) {}
	try{
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss::SSS");
	    return formatter.parse(str);
		}catch(ParseException e) {}
	try{
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	    return formatter.parse(str);
		}catch(ParseException e) {}
	error = 2;
	calendar.setTimeInMillis(0);
	return new Date(1);
}

//odejmowanie godzin
public Calendar odejmij(String str) {
	//System.out.println(str);
String[] parts = str.replace("::", ":").split(":");
int hour = Integer.parseInt(parts[0]);
int min = Integer.parseInt(parts[1]);
int sec = Integer.parseInt(parts[2]);
int msec = 0;

try {
msec = Integer.parseInt(parts[3]);
}catch(ArrayIndexOutOfBoundsException e){}
catch(NumberFormatException e){}

//System.out.println("msec = " + msec);

long nowy = calendar.getTimeInMillis() - ((hour*60+min)*60+sec)*1000+msec;
Calendar cnowy = Calendar.getInstance();
cnowy.setTimeInMillis(nowy);
return cnowy;
}

//dodawanie godzin
public Calendar dodaj(String str) {
String[] parts = str.replace("::", ":").split(":");
int hour = Integer.parseInt(parts[0]);
int min = Integer.parseInt(parts[1]);
int sec = Integer.parseInt(parts[2]);
int msec = 0;

try {
msec = Integer.parseInt(parts[3]);
}catch(ArrayIndexOutOfBoundsException e){}
catch(NumberFormatException e){}

//System.out.println("msec = " + hour);

long nowy = calendar.getTimeInMillis() + ((hour*60+min)*60+sec)*1000+msec;
Calendar cnowy = Calendar.getInstance();
cnowy.setTimeInMillis(nowy);
return cnowy;
}


}

