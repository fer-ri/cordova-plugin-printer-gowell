package com.rafadev.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
// import org.apache.cordova.*;
// import org.apache.cordova.api.*;

import android.annotation.TargetApi;

import com.RT_Printer.BluetoothPrinter.BLUETOOTH.BluetoothPrintDriver;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

@TargetApi(19)
public class PrinterGowell extends CordovaPlugin {

    /**
     * Executes the request.
     *
     * This method is called from the WebView thread.
     * To do a non-trivial amount of work, use:
     *     cordova.getThreadPool().execute(runnable);
     *
     * To run on the UI thread, use:
     *     cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action   The action to execute.
     * @param args     The exec() arguments in JSON form.
     * @param callback The callback context used when calling back into JavaScript.
     * @return         Whether the action was valid.
     */
    @Override
    public boolean execute (String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equalsIgnoreCase("openPrinter")) {
            openPrinter(args, callbackContext);

            return true;
        }

        if (action.equalsIgnoreCase("close")) {
            BluetoothPrintDriver.close();

            return true;
        }

        if (action.equalsIgnoreCase("isNoConnection")) {
            // BluetoothPrintDriver.IsNoConnection();
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, "Rafa");
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);

            return true;
        }

        if (action.equalsIgnoreCase("print")) {
            // print(args, callbackContext);

            return true;
        }

        // Returning false results in a "MethodNotFound" error.
        return false;
    }

    private void openPrinter(JSONArray args, CallbackContext callbackContext) throws JSONException
    {
        String macAddress = args.getString(0);

        if (BluetoothPrintDriver.OpenPrinter(macAddress)) 
        {
            //Keep the callback
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
        }
        else 
        {
            callbackContext.error("Could not connect to " + macAddress);
        }
    }

    // private void print (JSONArray args, CallbackContext callbackContext) {
    //     final String content   = args.optString(0, "<html></html>");
    //     final JSONObject props = args.optJSONObject(1);

    //     if(BluetoothPrintDriver.IsNoConnection()){
    //         return;
    //     }

    //     cordova.getActivity().runOnUiThread( new Runnable() {
    //         @Override
    //         public void run() {
    //             BluetoothPrintDriver.Begin();
    //             String tmpString = "Rafadev";
    //             BluetoothPrintDriver.ImportData(tmpString);
    //             BluetoothPrintDriver.ImportData("\r");
    //             BluetoothPrintDriver.LF();
    //             BluetoothPrintDriver.LF();
    //             BluetoothPrintDriver.excute();
    //             BluetoothPrintDriver.ClearData();
    //         }
    //     });
    // }

}
