package bbi.carpooling.web.app;

import org.apache.wicket.Session;

import bbi.carpooling.model.map.WorkArea;

public class GoogleMapGenerator {

	protected static String createDynamicGoogleMapJs() {
		WorkArea workArea = ((CarPoolingSession) Session.get()).getWorkArea();
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("var map;");
		if (workArea == null) {
			builder.append("function initialize() { ");
			builder.append("var latlng = new google.maps.LatLng(-34.397, 150.644); ");
			builder.append("var myOptions = { ");
			builder.append("zoom : 8, ");
			builder.append("center : latlng, ");
			builder.append("mapTypeId : google.maps.MapTypeId.ROADMAP }; ");
			
			builder.append("map = new google.maps.Map(document.getElementById( \"map_canvas\"), myOptions);}");
			
		}

		else {
			builder.append("function initialize() { ");
			builder.append(String.format("var latlng = new google.maps.LatLng(%f, %f); " , workArea.getxPosition() , workArea.getyPosition()));
			builder.append("var myOptions = { ");
			builder.append(String.format("zoom : %d, ", workArea.getZoomLevel()));
			builder.append("center : latlng, ");
			builder.append("mapTypeId : google.maps.MapTypeId.ROADMAP }; ");
			
			builder.append("map = new google.maps.Map(document.getElementById( \"map_canvas\"), myOptions);}");
		}
		return builder.toString();
	}
}
