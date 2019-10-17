package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 600;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);

		playRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		ystep = MAPYSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		
		for (int i= 0; i < gpspoints.length; i++) {
			
		int x = (int)(MARGIN + xstep() * (gpspoints[i].getLongitude() - gpspoints[0].getLongitude()));
		int y = (int)(ystep() * (gpspoints[i].getLatitude() - gpspoints[0].getLatitude()));
		
		setColor(255,165,0);
		fillCircle(x, 150 - y ,4);
		}
		
		for (int i= 0; i < gpspoints.length-1; i++) {
			
			int x = (int)(MARGIN + xstep() * (gpspoints[i].getLongitude() - gpspoints[0].getLongitude()));
			int y = (int)(ystep() * (gpspoints[i].getLatitude() - gpspoints[0].getLatitude()));
			int x2 = (int)(MARGIN + xstep() * (gpspoints[i+1].getLongitude() - gpspoints[0].getLongitude()));
			int y2 = (int)(ystep() * (gpspoints[i+1].getLatitude() - gpspoints[0].getLatitude()));
			setColor(255,165,0);
			drawLine(x, 150 - y, x2, 150 - y2);
			}
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		
		String[] tabell = gpscomputer.displayStatistics();
		
		int y = 30;
for (int i = 1; i < tabell.length-1; i++) {
			
			drawString(tabell[i], MARGIN - 10, y);
			
			y += 20;
		}
		
		// TODO - SLUTT;
	}

	public void playRoute(int ybase) {

		// TODO - START
		
		
		
		// TODO - SLUTT
	}

}
