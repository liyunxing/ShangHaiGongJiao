package com.shjt.map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
//import com.baidu.location.LocationClient;
//import com.baidu.location.LocationClientOption;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public class ShJtMap
{
  private static boolean bLocateMap = false;
  private static Context context;
  public static int id = 0;
//  public static Line line;
  public static int line_fetch = 0;
  public static boolean line_up = false;
//  private static LocationClient locClient;
//  private static BDLocationListener locListener;
  public static String locName;
  public static float locX = 0.0F;
  public static float locY = 0.0F;
//  private static MapView mapView = null;
//  private static OnMapZoom mapZoom;
//  private static OnLocate onLocate;
  private static String perferName;
  public static float r_around = 0.0F;
  public static int station = 0;
  public static String str_around;
  public static String str_from;
  public static String str_to;
  public static boolean touchMap = false;
  public static int tran_hour = 0;
  public static int tran_minute = 0;
//  public static Transfer transfer;
  public static float x_around = 0.0F;
  public static float x_from = 0.0F;
  private static final float x_temp = 121.46671F;
  public static float x_to = 0.0F;
  public static float y_around = 0.0F;
  public static float y_from = 0.0F;
  private static final float y_temp = 31.224464F;
  public static float y_to;

  static
  {
//    line = new Line();
//    line_fetch = -1;
//    line_up = true;
//    station = 0;
//    transfer = new Transfer();
//    str_from = "";
//    x_from = 0.0F;
//    y_from = 0.0F;
//    str_to = "";
//    x_to = 0.0F;
//    y_to = 0.0F;
//    tran_hour = 0;
//    tran_minute = 0;
//    str_around = "";
//    x_around = 0.0F;
//    y_around = 0.0F;
//    r_around = 0.005F;
//    locName = "我的位置";
//    locX = 121.46671F;
//    locY = 31.224464F;
//    bLocateMap = false;
//    onLocate = null;
//    id = 0;
//    context = null;
//    perferName = "loc_history";
//    locClient = null;
//    locListener = new LocationListener();
//    mapZoom = null;
    System.loadLibrary("shjtmap");
  }


  private static native void drawMap(int paramInt);



  private static native void fixZoominMap(int paramInt);



  private static native void fixZoomoutMap(int paramInt);

  public static boolean fromIsMyLocation()
  {
    return str_from.equalsIgnoreCase("我的位置");
  }

  private static native int[] getBitmap(int paramInt);

  public static native String getPDMD5String();

  public static native String getPXMD5String();
  
  
/*  
 
    public static void fixZoomoutMap()
  {
    if (id != 0)
    {
      fixZoomoutMap(id);
      refreshView();
    }
  }
  
    public static void fixZoominMap()
  {
    if (id != 0)
    {
      fixZoominMap(id);
      refreshView();
    }
  }
  
  
  public static boolean canTransfer()
  {
    return (str_from.length() > 0) && (str_to.length() > 0);
  }

  public static void cancelLocate()
  {
    onLocate = null;
  }

  public static void centerLocation()
  {
    if (id != 0)
    {
      locate(id, locX, locY);
      centerMap(id, locX, locY);
      refreshView();
    }
  }

  public static void centerMap(float paramFloat1, float paramFloat2)
  {
    if (id != 0)
    {
      centerMap(id, paramFloat1, paramFloat2);
      refreshView();
    }
  }

  private static native void centerMap(int paramInt, float paramFloat1, float paramFloat2);

  public static void clear()
  {
    if (id != 0)
    {
      str_from = "";
      str_to = "";
      str_around = "";
      clear(id);
      refreshView();
    }
  }

  private static native void clear(int paramInt);

  public static void clearFrom()
  {
    str_from = "";
  }

  public static void clearTo()
  {
    str_to = "";
  }

  private static native float convertX(int paramInt, float paramFloat1, float paramFloat2);

  private static native float convertY(int paramInt, float paramFloat1, float paramFloat2);

  public static void create(Context paramContext)
  {
    if (id == 0)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int[] arrayOfInt = FileStream.read(paramContext, localByteArrayOutputStream);
      if (arrayOfInt != null)
        id = createMap(arrayOfInt, localByteArrayOutputStream.toByteArray(), paramContext.getResources().getDisplayMetrics().density);
      Log.i("shjtmap", "Map create");
    }
  }

  private static native int createMap(int[] paramArrayOfInt, byte[] paramArrayOfByte, float paramFloat);

  private static native void deleteMap(int paramInt);

  public static void destroy()
  {
    Log.i("shjtmap", "ShJtMap destroy");
    if (id != 0)
    {
      deleteMap(id);
      id = 0;
      bLocateMap = false;
    }
  }

  public static void drawCanvas(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (id != 0)
    {
      int[] arrayOfInt = getBitmap(id);
      if (arrayOfInt != null)
        paramCanvas.drawBitmap(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2, false, null);
      if (mapZoom != null)
        mapZoom.onZoom();
    }
  }


  private static boolean inRegion(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= 120.84862F) && (paramFloat1 <= 122.09745F) && (paramFloat2 >= 30.574829F) && (paramFloat2 <= 31.851643F);
  }

  public static void locate()
  {
    if ((id != 0) && (!bLocateMap))
    {
      bLocateMap = true;
      locate(id, locX, locY);
    }
  }

  private static native void locate(int paramInt, float paramFloat1, float paramFloat2);

  public static void locateAround()
  {
    str_around = locName;
    x_around = locX;
    y_around = locY;
  }

  public static void locateAround(int paramInt1, int paramInt2)
  {
    if (id != 0)
    {
      str_around = "地图选点";
      x_around = convertX(id, paramInt1, paramInt2);
      y_around = convertY(id, paramInt1, paramInt2);
    }
  }

  public static void locateCompleted(BDLocation paramBDLocation)
  {
    int i = paramBDLocation.getLocType();
    boolean bool1;
    if ((i != 61) && (i != 161))
    {
      bool1 = false;
      bool2 = false;
      if (bool1)
      {
        double d1 = paramBDLocation.getLongitude();
        double d2 = paramBDLocation.getLatitude();
        if (bLocateMap)
        {
          OnLocate localOnLocate = onLocate;
          bool2 = false;
          if (localOnLocate == null);
        }
        else
        {
          locName = "我的位置";
          if (!inRegion((float)d1, (float)d2))
            break label116;
          locX = (float)d1;
          locY = (float)d2;
        }
      }
    }
    for (boolean bool2 = false; ; bool2 = true)
    {
      saveLocation();
      if (onLocate != null)
      {
        onLocate.onLocate(bool1, bool2);
        onLocate = null;
      }
      return;
      bool1 = true;
      break;
      label116: locX = 121.46671F;
      locY = 31.224464F;
    }
  }

  public static void locateFrom()
  {
    str_from = locName;
    x_from = locX;
    y_from = locY;
  }

  public static void locateFrom(int paramInt1, int paramInt2)
  {
    if (id != 0)
    {
      str_from = "地图选点";
      x_from = convertX(id, paramInt1, paramInt2);
      y_from = convertY(id, paramInt1, paramInt2);
    }
  }

  public static void locateTo()
  {
    str_to = locName;
    x_to = locX;
    y_to = locY;
  }

  public static void locateTo(int paramInt1, int paramInt2)
  {
    if (id != 0)
    {
      str_to = "地图选点";
      x_to = convertX(id, paramInt1, paramInt2);
      y_to = convertY(id, paramInt1, paramInt2);
    }
  }

  public static void offsetMap(float paramFloat1, float paramFloat2)
  {
    if (id != 0)
    {
      offsetMap(id, paramFloat1, paramFloat2);
      refreshView();
    }
  }

  private static native void offsetMap(int paramInt, float paramFloat1, float paramFloat2);

  private static native void putStream();

  private static void readLocation()
  {
    Map localMap = context.getSharedPreferences(perferName, 0).getAll();
    if (localMap.size() > 0)
    {
      locName = (String)localMap.get("locName");
      locX = ((Float)localMap.get("locX")).floatValue();
      locY = ((Float)localMap.get("locY")).floatValue();
    }
  }

  public static void redrawMap()
  {
    if (id != 0)
    {
      drawMap(id);
      refreshView();
    }
  }

  public static void refreshView()
  {
    if (mapView != null)
      mapView.refresh();
  }

  public static void requestLocate(OnLocate paramOnLocate)
  {
    if ((locClient != null) && (locClient.isStarted()))
    {
      locClient.requestLocation();
      onLocate = paramOnLocate;
    }
  }

  private static void saveLocation()
  {
    SharedPreferences.Editor localEditor = context.getSharedPreferences(perferName, 0).edit();
    localEditor.putString("locName", locName);
    localEditor.putFloat("locX", locX);
    localEditor.putFloat("locY", locY);
    localEditor.commit();
  }

  public static void setAroundRadius(float paramFloat)
  {
    r_around = paramFloat;
  }

  private static native void setConnectParam(String paramString, int paramInt);

  public static void setDeviceSize(int paramInt1, int paramInt2)
  {
    if (id != 0)
    {
      setDeviceSize(id, paramInt1, paramInt2);
      drawMap(id);
    }
  }

  private static native void setDeviceSize(int paramInt1, int paramInt2, int paramInt3);

  public static void setMapView(MapView paramMapView)
  {
    mapView = paramMapView;
  }

  public static void setOnMapZoom(OnMapZoom paramOnMapZoom)
  {
    mapZoom = paramOnMapZoom;
  }

  public static void showScheme(int paramInt)
  {
    if (id != 0)
    {
      transfer.showScheme(id, paramInt);
      refreshView();
    }
  }

  public static void startLocate(Context paramContext)
  {
    context = paramContext.getApplicationContext();
    readLocation();
    if (locClient == null)
    {
      locClient = new LocationClient(context);
      LocationClientOption localLocationClientOption = new LocationClientOption();
      localLocationClientOption.setOpenGps(true);
      localLocationClientOption.setAddrType("all");
      localLocationClientOption.setCoorType("gcj02");
      localLocationClientOption.disableCache(true);
      localLocationClientOption.setPriority(1);
      locClient.setLocOption(localLocationClientOption);
      locClient.registerLocationListener(locListener);
      locClient.start();
    }
  }

  public static void stopLocate()
  {
    if ((id != 0) && (locClient != null))
    {
      locClient.stop();
      locClient = null;
    }
  }

  public static void switchFromTo()
  {
    String str = str_from;
    str_from = str_to;
    str_to = str;
    float f1 = x_from;
    float f2 = y_from;
    x_from = x_to;
    y_from = y_to;
    x_to = f1;
    y_to = f2;
  }

  public static boolean toIsMyLocation()
  {
    return str_to.equalsIgnoreCase("我的位置");
  }

  public static boolean zoominEnabled()
  {
    if (id != 0)
      return zoominEnabled(id);
    return false;
  }

  private static native boolean zoominEnabled(int paramInt);

  public static void zoominMap(float paramFloat1, float paramFloat2)
  {
    if (id != 0)
    {
      zoominMap(id, paramFloat1, paramFloat2);
      refreshView();
    }
  }

  private static native void zoominMap(int paramInt, float paramFloat1, float paramFloat2);

  public static boolean zoomoutEnabled()
  {
    if (id != 0)
      return zoomoutEnabled(id);
    return false;
  }

  private static native boolean zoomoutEnabled(int paramInt);

  public static void zoomoutMap(float paramFloat1, float paramFloat2)
  {
    if (id != 0)
    {
      zoomoutMap(id, paramFloat1, paramFloat2);
      refreshView();
    }
  }*/

  private static native void zoomoutMap(int paramInt, float paramFloat1, float paramFloat2);
}