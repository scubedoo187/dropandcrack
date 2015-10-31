package dropandcrack.android.dac;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;



public class Message extends AppWidgetProvider {


    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){

        for(int i = 0; i<appWidgetIds.length; i++) {
            RemoteViews remote = new RemoteViews(context.getPackageName(), R.layout.message);

            String messageContent; //메세지를 받을 부분
            messageContent = "안녕하세요";

            remote.setTextViewText(R.id.textview, messageContent);


            Intent intent = new Intent(context,Message.class);
            intent.setAction("TOUCH FOR SEND MESSAGE");
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
            remote.setOnClickPendingIntent(R.id.layout,pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], remote);
        }
    }

    public void onReceive(Context context, Intent intent){

        String action = intent.getAction();

        if(action != null && action.equals("TOUCH FOR SEND MESSAGE")){

            Intent intent2 = new Intent();
            intent.setClassName("dropandcrack.android.dac", "dropandcrack.android.dac.SendMessage");
            intent.setAction("android.intent.action.SendMessage");

            context.startActivity(intent2);

            return;
        }
        super.onReceive(context,intent);
    }
}