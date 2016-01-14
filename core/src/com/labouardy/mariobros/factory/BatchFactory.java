package com.labouardy.mariobros.factory;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by mlabouardy on 14/01/16.
 */
public class BatchFactory {
    private static SpriteBatch batch;

    public static SpriteBatch getInstance(){
        if(batch==null)
            batch=new SpriteBatch();
        return batch;
    }

}
