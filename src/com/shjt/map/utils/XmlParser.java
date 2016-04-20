package com.shjt.map.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

import com.shjt.map.bean.StopInfo;

public class XmlParser {

	public static List<StopInfo> getStopList(InputStream is){
		List<StopInfo> list = null;
		StopInfo stopInfo = null;
		
		XmlPullParser xpp = Xml.newPullParser();  
        try {
        	xpp.setInput(is,"UTF-8");  
        	int eventType = xpp.getEventType(); 
        	while (eventType != XmlPullParser.END_DOCUMENT){  
                switch (eventType) {  
                
                case XmlPullParser.START_DOCUMENT:  
                	list = new ArrayList<StopInfo>(); 
                    break;  
               
                case XmlPullParser.START_TAG:  
                    if (xpp.getName().equals("stop")) { 
                        stopInfo = new StopInfo();  
                    } else if (xpp.getName().equals("zdmc")) {  
                        eventType = xpp.next();
                        stopInfo.setName(xpp.getText());  
                    } else if (xpp.getName().equals("id")) {
                        eventType = xpp.next();
                        stopInfo.setId(xpp.getText());  
                    }   
                    break;  

                case XmlPullParser.END_TAG:  
                    if (xpp.getName().equals("stop")) { 
                    	list.add(stopInfo); 
                    	stopInfo = null;  
                    }  
                    break;  
                }  

                eventType = xpp.next();  
        
        	}
        
        } catch (Exception e) {
			
		}
		return list;
	}
}
