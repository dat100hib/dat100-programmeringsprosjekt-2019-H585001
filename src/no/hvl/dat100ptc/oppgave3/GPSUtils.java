package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		// TODO - SLUT

	} 

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] tabell = new double[gpspoints.length];
		
		for (int i = 0; i < tabell.length; i++) {
			tabell[i] = gpspoints[i].getLatitude();
		}
		
		return tabell;	
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		
		double[] tabell = new double[gpspoints.length];
		
		for (int i = 0; i < tabell.length; i++) {
			tabell[i] = gpspoints[i].getLongitude();
		}
		return tabell;
		
		// TODO - SLUTT
		
	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = toRadians(gpspoint1.getLatitude());
		latitude2 = toRadians(gpspoint2.getLatitude());
		longitude1 =toRadians(gpspoint1.getLongitude());
		longitude2 =toRadians(gpspoint2.getLongitude());
		
		double lati = latitude2 - latitude1;
		double longi = longitude2 - longitude1;
		
		double a = pow(sin(lati / 2),2) + cos(latitude1) * cos(latitude2) * pow(sin(longi / 2),2);
		double c = 2 * atan2(sqrt(a),sqrt(1-a));
		d = R * c;
		
		return d;

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		double distance = distance(gpspoint1, gpspoint2);
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = (distance / secs) * 3.6;
		
		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int h = secs / 3600;
		int m = (secs % 3600) / 60;
		int s = secs % 60;
		
		timestr = String.format("%02d" + TIMESEP + "%02d" + TIMESEP + "%02d", h, m, s);
		timestr = String.format("%1$10s", timestr);
		
		return timestr;
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		
		String dRound = String.format("%.2f", d).replace(',', '.');
		str = String.format("%1$" + TEXTWIDTH + "s", dRound);
		
		return str;

		// TODO - SLUTT
		
	}
}
