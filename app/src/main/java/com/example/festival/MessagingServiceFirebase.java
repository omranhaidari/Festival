package com.example.festival;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingServiceFirebase extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String CANAL = "notificationCanal";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String bodyMessage = remoteMessage.getNotification().getBody();
        String titleMessage = remoteMessage.getNotification().getTitle();

        Log.d("FirebaseMessage", "Vous venez de recevoir une notification : " + bodyMessage);

        // Création d'une notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CANAL);
        notificationBuilder.setContentTitle(titleMessage);
        notificationBuilder.setContentText(bodyMessage);

        // Ajout de l'icône alarme dans la notification
        notificationBuilder.setSmallIcon(R.drawable.alarm);

        // Envoi de la notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Pour la version Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = getString(R.string.notification_channel_id);
            String channelTitle = getString(R.string.notification_channel_title);
            String channelDescription = getString(R.string.notification_channel_description);
            NotificationChannel channel = new NotificationChannel(channelId, channelTitle, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDescription);
            notificationManager.createNotificationChannel(channel);
            notificationBuilder.setChannelId(channelId);
        }

        // Redirection vers l'application (écran de chargement) lors du clic dessus
        Intent intent = new Intent(getApplicationContext(), SplashScreen.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,  intent, 0);

        // Ajout de la redirection
        notificationBuilder.setContentIntent(pendingIntent);

        // Création de la vibration
        long [] vibrationPattern = {500, 1000};
        notificationBuilder.setVibrate(vibrationPattern);

        notificationManager.notify(1, notificationBuilder.build());
    }
}
