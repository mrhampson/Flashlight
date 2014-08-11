package com.marshallhampson.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

	private Camera c;
	private boolean on;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = null;
        on = true;
        try 
		{
    		c = Camera.open();
    	}
    	catch (Exception e) 
    	{
    	}
		Parameters p = c.getParameters();
		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		c.setParameters(p);
		c.startPreview();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void OnOffSwitchClick(View view) {
    	on = !on;
    	if (on)
    	{
    		try 
    		{
        		c = Camera.open();
        	}
        	catch (Exception e) 
        	{
        	}
    		Parameters p = c.getParameters();
    		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
    		c.setParameters(p);
    		c.startPreview();
    	}
    	else 
    	{
    		c.stopPreview();
    		c.release();
    	}
    }
}
