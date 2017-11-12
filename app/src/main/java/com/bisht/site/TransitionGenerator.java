package com.bisht.site;

/**
 * Created by prashantkumar on 03-05-2017.
 */


        import android.graphics.RectF;

public interface TransitionGenerator {


    public Transition generateNextTransition(RectF drawableBounds, RectF viewport);

}