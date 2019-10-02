package com.jiahuan.svgmapview;

import android.graphics.PointF;

import com.jiahuan.svgmapview.core.componet.MapMainView;

/**
 * Map control class
 *
 * @author forward
 * @since 1/7/2014
 */
public class SVGMapController {
    private MapMainView mapMainView;

    public SVGMapController(SVGMapView mapView) {
        this.mapMainView = (MapMainView) mapView.getChildAt(0);
    }

    /**
     * Set whether to enable map gesture movement, which is enabled by default.
     *
     * @param enabled true/false
     */
    public void setScrollGestureEnabled(boolean enabled) {
        this.mapMainView.setScrollGestureEnabled(enabled);
    }


    /**
     * Set whether to enable map map gesture zoom, which is enabled by default.
     *
     * @param enabled
     */
    public void setZoomGestureEnabled(boolean enabled) {
        this.mapMainView.setZoomGestureEnabled(enabled);
    }


    /**
     * Set whether to enable map gesture rotation, which is enabled by default.
     *
     * @param enabled true/false
     */
    public void setRotationGestureEnabled(boolean enabled) {
        if (!enabled) {
            setCurrentRotationDegrees(0);
        }
        this.mapMainView.setRotationGestureEnabled(enabled);

    }


    /**
     * Set whether the map gesture zoom center is the center point of the gesture
     *
     * @param enabled
     */
    public void setZoomWithTouchEventCenterEnabled(boolean enabled) {
        this.mapMainView.setZoomWithTouchEventCenter(enabled);
    }

    /**
     * Set whether the map gesture rotation center is the center point of the gesture
     *
     * @param enabled true/false
     */
    public void setRotateWithTouchEventCenterEnabled(boolean enabled) {
        this.mapMainView.setRotateWithTouchEventCenter(enabled);
    }


    /**
     * Non-animated map movement
     *
     * @param x x direction offset + right
     * @param y y direction offset + down
     */
    public void translateBy(float x, float y) {
        this.mapMainView.translateBy(x, y);
    }


    /**
     * Set the zoom ratio of the current map in non-animated form
     *
     * @param zoom   zoom ratio
     * @param pivotX zoom center point x
     * @param pivotY zoom center point y
     */
    public void setCurrentZoomValue(float zoom, float pivotX, float pivotY) {
        this.mapMainView.setCurrentZoomValue(zoom, pivotX, pivotY);
    }

    public void setCurrentZoomValue(float zoom) {
        setCurrentZoomValue(zoom, mapMainView.getWidth() / 2, mapMainView.getHeight() / 2);
    }

    /**
     * Set the rotation angle of the current map in a non-animated form [0,360]
     *
     * @param degrees
     */
    public void setCurrentRotationDegrees(float degrees) {
        setCurrentRotationDegrees(degrees, mapMainView.getWidth() / 2, mapMainView.getHeight() / 2);
    }

    public void setCurrentRotationDegrees(float degrees, float pivotX, float pivotY) {
        this.mapMainView.setCurrentRotationDegrees(degrees, pivotX, pivotY);
    }


    /**
     * Set the maximum zoom ratio of the map, the default is the size of the Unit display on all maps
     *
     * @param maxZoomValue
     */
    public void setMaxZoomValue(float maxZoomValue) {
        this.mapMainView.setMaxZoomValue(maxZoomValue);
    }

    /**
     * Set the map flashing point
     *
     * @param point       target point
     * @param radius      radius
     * @param color       color
     * @param repeatTimes number of repetitions
     */
    public void sparkAtPoint(PointF point, float radius, int color, int repeatTimes) {
        this.mapMainView.sparkAtPoint(point, radius, color, repeatTimes);
    }

}