package com.jiahuan.svgmapview.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jiahuan.svgmapview.SVGMapView;
import com.jiahuan.svgmapview.SVGMapViewListener;
import com.jiahuan.svgmapview.sample.helper.AssetsHelper;


public class OperationActivity extends AppCompatActivity {
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mapView = (SVGMapView) findViewById(R.id.operation_mapview);

        mapView.registerMapViewListener(new SVGMapViewListener() {
            @Override
            public void onMapLoadComplete() {
                // 地图加载完成
                OperationActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OperationActivity.this, "onMapLoadComplete ZEE", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onMapLoadError() {
                // 地图加载失败
                OperationActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OperationActivity.this, "onMapLoadError", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap) {
                // 获取地图截图
                // 保存到本地
                //........
                OperationActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OperationActivity.this, "onGetCurrentMap", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_operation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_rotation_gesture:
                if (item.getTitle().toString().contains("close")) {
                    // Turn off the map rotation gesture by default
                    // if the map rotation gesture is set to false, the map will be fixed in the middle and the related operations of the map rotation will be disabled. if true then the location of the map will not be fixed
                    mapView.getController().setRotationGestureEnabled(false);
                    item.setTitle("turn on rotation gesture");
                } else {
                    mapView.getController().setRotationGestureEnabled(true);
                    item.setTitle("turn off rotation gesture");
                }
                break;
            case R.id.action_scroll_gesture:
                if (item.getTitle().toString().contains("close")) {
                    // Turn on map drag gestures by default
                    mapView.getController().setScrollGestureEnabled(false);
                    item.setTitle("open drag gesture");
                } else {
                    mapView.getController().setScrollGestureEnabled(true);
                    item.setTitle("close drag gesture");
                }
                break;
            case R.id.action_zoom_gesture:
                if (item.getTitle().toString().contains("close")) {
                    // Turn on map zoom gesture by default
                    mapView.getController().setZoomGestureEnabled(false);
                    item.setTitle("turn zoom gesture");
                } else {
                    mapView.getController().setZoomGestureEnabled(true);
                    item.setTitle("turn off zoom gesture");
                }
                break;
            case R.id.action_rotate_touch_center:
                if (item.getTitle().toString().contains("close")) {
                    // Turn off the center point of the map rotation is the center of the gesture. The default is off, the center point is the center point of the map.
                    mapView.getController().setRotateWithTouchEventCenterEnabled(false);
                    item.setTitle("open gesture rotation center");
                } else {
                    mapView.getController().setRotateWithTouchEventCenterEnabled(true);
                    item.setTitle("close gesture rotation center");
                }
                break;
            case R.id.action_zoom_touch_center:
                if (item.getTitle().toString().contains("close")) {
                    // Turn off the center point of the map zoom is the center point of the gesture. The default is off, the center point is the center point of the map.
                    mapView.getController().setZoomWithTouchEventCenterEnabled(false);
                    item.setTitle("open gesture zoom center");
                } else {
                    mapView.getController().setZoomWithTouchEventCenterEnabled(true);
                    item.setTitle("close gesture zoom center");
                }
                break;
            case R.id.action_zoom_double:
                mapView.getController().setCurrentZoomValue(2);
                break;
            case R.id.action_zoom_half:
                mapView.getController().setCurrentZoomValue(0.5f);
                break;
            case R.id.action_rotate_to:
                // Timing is clockwise rotation
                mapView.getController().setCurrentRotationDegrees(30);
                break;
            case R.id.action_get_current_map:
                mapView.getCurrentMap();
                break;
        }
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_rotation_gesture:
                if (item.getTitle().toString().contains("关闭"))
                {
                    // 关闭地图旋转的手势 默认开启
                    // 如果将地图旋转手势置为false，那么地图将被固定在中间，地图旋转的相关操作也将被禁止掉。如果为true那么地图的位置将不会被固定
                    mapView.getController().setRotationGestureEnabled(false);
                    item.setTitle("开启旋转手势");
                }
                else
                {
                    mapView.getController().setRotationGestureEnabled(true);
                    item.setTitle("关闭旋转手势");
                }
                break;
            case R.id.action_scroll_gesture:
                if (item.getTitle().toString().contains("关闭"))
                {
                    // 开启地图拖拉手势  默认开启
                    mapView.getController().setScrollGestureEnabled(false);
                    item.setTitle("开启拖拉手势");
                }
                else
                {
                    mapView.getController().setScrollGestureEnabled(true);
                    item.setTitle("关闭拖拉手势");
                }
                break;
            case R.id.action_zoom_gesture:
                if (item.getTitle().toString().contains("关闭"))
                {
                    // 开启地图缩放手势 默认开启
                    mapView.getController().setZoomGestureEnabled(false);
                    item.setTitle("开启缩放手势");
                }
                else
                {
                    mapView.getController().setZoomGestureEnabled(true);
                    item.setTitle("关闭缩放手势");
                }
                break;
            case R.id.action_rotate_touch_center:
                if (item.getTitle().toString().contains("关闭"))
                {
                    // 关闭地图旋转的中心点是手势中心点 默认关闭，中心点是地图的中心点
                    mapView.getController().setRotateWithTouchEventCenterEnabled(false);
                    item.setTitle("开启手势旋转中心");
                }
                else
                {
                    mapView.getController().setRotateWithTouchEventCenterEnabled(true);
                    item.setTitle("关闭手势旋转中心");
                }
                break;
            case R.id.action_zoom_touch_center:
                if (item.getTitle().toString().contains("关闭"))
                {
                    // 关闭地图缩放的中心点是手势中心点 默认关闭，中心点是地图的中心点
                    mapView.getController().setZoomWithTouchEventCenterEnabled(false);
                    item.setTitle("开启手势缩放中心");
                }
                else
                {
                    mapView.getController().setZoomWithTouchEventCenterEnabled(true);
                    item.setTitle("关闭手势缩放中心");
                }
                break;
            case R.id.action_zoom_double:
                mapView.getController().setCurrentZoomValue(2);
                break;
            case R.id.action_zoom_half:
                mapView.getController().setCurrentZoomValue(0.5f);
                break;
            case R.id.action_rotate_to:
                // 正时为顺时针旋转
                mapView.getController().setCurrentRotationDegrees(30);
                break;
            case R.id.action_get_current_map:
                mapView.getCurrentMap();
                break;
        }
        return true;
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
