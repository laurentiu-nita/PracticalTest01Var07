package ro.pub.cs.systems.eim.practicaltest01var07;

public interface Constants {
    final public static int SERVICE_STOPPED = 0;
    final public static int SERVICE_STARTED = 1;
    final public static String PROCESSING_THREAD_TAG = "[Processing Thread]";
    final public static String ACTION_TYPE = "ro.pub.cs.systems.eim.practicaltest01var07.actionType";
    final public static String BROADCAST_RECEIVER_EXTRA = "ro.pub.cs.systems.eim.practicaltest01var07.broadcastreceiverextra";
    String[] actionTypes = {
            "ro.pub.cs.systems.eim.practicaltest01var07.actionType1",
            "ro.pub.cs.systems.eim.practicaltest01var07.actionType2",
            "ro.pub.cs.systems.eim.practicaltest01var07.actionType3",
            "ro.pub.cs.systems.eim.practicaltest01var07.actionType4",
            "ro.pub.cs.systems.eim.practicaltest01var07.actionType5"
    };
    final public static String BROADCAST_RECEIVER_TAG = "[Message]";
}
